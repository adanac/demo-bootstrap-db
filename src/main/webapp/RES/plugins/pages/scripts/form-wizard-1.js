var FormWizard = function () {


    return {
        //main function to initiate the module
        init: function () {
            if (!jQuery().bootstrapWizard) {
                return;
            }

            function format(state) {
                if (!state.id) return state.text; // optgroup
                return "<img class='flag' src='../../assets/global/img/flags/" + state.id.toLowerCase() + ".png'/>&nbsp;&nbsp;" + state.text;
            }

            $("#country_list").select2({
                placeholder: "Select",
                allowClear: true,
                formatResult: format,
                formatSelection: format,
                escapeMarkup: function (m) {
                    return m;
                }
            });

            var form = $('#submit_form');
            var error = $('.alert-danger', form);
            var success = $('.alert-success', form);
			jQuery.extend(jQuery.validator.messages, {
				  required: "必填字段",
				  remote: "请修正该字段",
				  email: "请输入正确格式的电子邮件地址",
				  url: "请输入合法的网址",
				  date: "请输入合法的日期",
				  dateISO: "请输入合法的日期 (ISO).",
				  number: "请输入合法的数字",
				  digits: "只能输入整数",
				  creditcard: "请输入合法的信用卡号",
				  equalTo: "请再次输入相同的值",
				  accept: "请输入拥有合法后缀名的字符串",
				  maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
				  minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
				  rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
				  range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
				  max: jQuery.validator.format("请输入一个最大为{0} 的值"),
				  min: jQuery.validator.format("请输入一个最小为{0} 的值")
				}); 
             form.validate({
                doNotHideMessage: true, //this option enables to show the error/success messages on tab switch.
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                rules: {
                    //基本信息
					email: {
                        required: true,
                        email: true
                    },
                    password: {
                        minlength: 6,
						maxlength: 29,
                        required: true
                    },
                    rpassword: {
                        required: true,
                        equalTo: "#password"
                    },
                    bisID:"required",
					bisName:"required",
					legalRepName:"required",
					IDnumber:"required",
					corporationName:"required",
					phone:"required",
					bankName:"required",
					taxBankAccountNumber:"required",
					bankOfDepositName:"required",
					s_province:"required",
					s_city:"required",
					bankAccountNumber:"required",
					AccountHolder:"required",
					ContactNumber:"required",
					BillingRate:"required",
					businessName:"required",
					TaxNumber:"required",
					comBank:"required",
					bankAccount:"required",
					comAddress:"required",
					comPhone:"required",
					contactName:"required",
					contactPhone:"required",
					//:"required",:"required",
					
                    'payment[]': {
                        required: true,
                        minlength: 1
                    }
                },

                messages: { // custom messages for radio buttons and checkboxes
                    email: {
						required: "请输入邮箱",
						email:"请输入正确格式的电子邮件地址",
					   },
					password: {
						required: "请输入密码",
						rangelength:jQuery.validator.format("密码为{0}-{1}个字符"),
					   },
					'payment[]': {
                        required: "Please select at least one option",
                        minlength: jQuery.validator.format("Please select at least one option")
                    }
                },

                errorPlacement: function (error, element) { // render error placement for each input type
                    if (element.attr("name") == "gender") { // for uniform radio buttons, insert the after the given container
                        error.insertAfter("#form_gender_error");
                    } else if (element.attr("name") == "payment[]") { // for uniform checkboxes, insert the after the given container
                        error.insertAfter("#form_payment_error");
                    } else {
                        error.insertAfter(element); // for other inputs, just perform default behavior
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit   
                    success.hide();
                    error.show();
                    Metronic.scrollTo(error, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.form-group').removeClass('has-success').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    if (label.attr("for") == "gender" || label.attr("for") == "payment[]") { // for checkboxes and radio buttons, no need to show OK icon
                        label
                            .closest('.form-group').removeClass('has-error').addClass('has-success');
                        label.remove(); // remove error label here
                    } else { // display success icon for other inputs
                        label
                            .addClass('valid') // mark the current input as valid and display OK icon
                        .closest('.form-group').removeClass('has-error').addClass('has-success'); // set success class to the control group
                    }
                },

                submitHandler: function (form) {
                    success.show();
                    error.hide();
                    //add here some ajax code to submit your form or just call form.submit() if you want to submit the form without ajax
                }
				
            });

            var displayConfirm = function() {
                $('#tab4 .form-control-static', form).each(function(){
                    var input = $('[name="'+$(this).attr("data-display")+'"]', form);
                    if (input.is(":radio")) {
                        input = $('[name="'+$(this).attr("data-display")+'"]:checked', form);
                    }
                    if (input.is(":text") || input.is("textarea")) {
                        $(this).html(input.val());
                    } else if (input.is("select")) {
                        $(this).html(input.find('option:selected').text());
                    } else if (input.is(":radio") && input.is(":checked")) {
                        $(this).html(input.attr("data-title"));
                    } else if ($(this).attr("data-display") == 'payment[]') {
                        var payment = [];
                        $('[name="payment[]"]:checked', form).each(function(){ 
                            payment.push($(this).attr('data-title'));
                        });
                        $(this).html(payment.join("<br>"));
                    }
                });
            }

            var handleTitle = function(tab, navigation, index) {
                var total = navigation.find('li').length;
                var current = index + 1;
                // set wizard title
                $('.step-title', $('#form_wizard_1')).text('Step ' + (index + 1) + ' of ' + total);
                // set done steps
                jQuery('li', $('#form_wizard_1')).removeClass("done");
                var li_list = navigation.find('li');
                for (var i = 0; i < index; i++) {
                    jQuery(li_list[i]).addClass("done");
                }

                if (current == 1) {
                    $('#form_wizard_1').find('.button-previous').hide();
                } else {
                    $('#form_wizard_1').find('.button-previous').show();
                }
				if (current == 1) {
					$('#form_wizard_1').find('.button-save').hide();
                    $('#form_wizard_1').find('.button-next').show();
                } else if (current == 2) {
                    $('#form_wizard_1').find('.form-actions .button-next').hide();
					$('#form_wizard_1').find('.button-save').hide();
                   // displayConfirm();
                } else if (current >= total) {
					$('#form_wizard_1').find('.button-save').hide();
                    $('#form_wizard_1').find('.button-next').hide();
                    displayConfirm();
                } else {
					$('#form_wizard_1').find('.button-save').show();
                    $('#form_wizard_1').find('.button-next').show();
                }
				
                Metronic.scrollTo($('.page-title'));
            }

            // default form wizard
            $('#form_wizard_1').bootstrapWizard({
                'nextSelector': '.button-next',
                'previousSelector': '.button-previous',
                onTabClick: function (tab, navigation, index, clickedIndex) {
                    return false;
                    /*
                    success.hide();
                    error.hide();
                    if (form.valid() == false) {
                        return false;
                    }
                    handleTitle(tab, navigation, clickedIndex);
                    */
                },
                onNext: function (tab, navigation, index) {
                    success.hide();
                    error.hide();

                    if (form.valid() == false) {
                        return false;
                    }

                    handleTitle(tab, navigation, index);
                },
                onPrevious: function (tab, navigation, index) {
                    success.hide();
                    error.hide();

                    handleTitle(tab, navigation, index);
                },
                onTabShow: function (tab, navigation, index) {
                    var total = navigation.find('li').length;
                    var current = index + 1;
                    var $percent = (current / total) * 100;
                    $('#form_wizard_1').find('.progress-bar').css({
                        width: $percent + '%'
                    });
                }
            });

            $('#form_wizard_1').find('.button-previous').hide();
			$('#form_wizard_1').find('.button-save').hide();
            $('#form_wizard_1 .button-submit').click(function () {
                alert('Finished! Hope you like it :)');
            }).hide();

            //apply validation on select2 dropdown value change, this only needed for chosen dropdown integration.
            $('#country_list', form).change(function () {
                form.validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
            });
        }

    };

}();