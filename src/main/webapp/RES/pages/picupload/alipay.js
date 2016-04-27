//图片上传
var basePath = '${base}';
$('#save_btn').on('click', function(event) {
	if(checknum() == false || checkMenpai() == false || checkMentou() == false 
			|| checkInside() == false || checkOfficeones() == false || checkOfficetwo() == false
			|| checkOfficethree() == false)
	{
		alert("check fail");
		return false;
	}
	var apply_form = $('#alipay_apply_form');
	var param = $.serializeObject(apply_form);
	
	var paramJson = encodeURI(encodeURI(JSON.stringify(param)));
	
	var url = basePath + '/picupload/addAlipay.do?paramJson=' + paramJson;
	$.ajax({
		type : "post",
		url : url,
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success : function(data) {
			$("#save").removeAttr("disabled");
			if (data.status == "1") {
				alert(data.message);
				window.location.href="${base}/picupload/toAlipay.do";
			}
			if (data.status == "0") {
				alert(data.message);
			}
		}
	});
 });
	
$("#btn_ok").on('click', function(event) {
	window.location.href="${base}/picupload/toAlipay.do";
})

  //验证支付宝账号
function checknum(){
	var num = $("#num").val();
	if(num == ""){
		helpInfo("shownum","不能为空");
		return false;
	}
	helpInfo("shownum","");
}

//显示提示信息
function helpInfo(id,msg){
	$("#"+id+"").html(msg);
	$("#"+id+"").show("slow");
}

function checkMenpai()
{
	var name = $("#show").attr('src');
	if (name == "") {
		helpInfo("showMenpai","门牌号照片不能为空，请输入");
		return false;
	}
	helpInfo("showMenpai","");
}

function checkMentou()
{
	var name = $("#doorshow").attr('src');
	if (name == "") {
		helpInfo("showMentou","门头照片不能为空，请输入");
		return false;
	}
	helpInfo("showMentou","");
}

function checkInside()
{
	var name = $("#insideshow").attr('src');
	if (name == "") {
		helpInfo("showInside","内景照片不能为空，请输入");
		return false;
	}
	helpInfo("showInside","");
}

function checkOfficeones()
{
	var name = $("#officeoneshow").attr('src');
	if (name == "") {
		helpInfo("showOfficeones","工作实景(1)不能为空，请输入");
		return false;
	}
	helpInfo("showOfficeones","");
}

function checkOfficetwo()
{
	var name = $("#officetwoshow").attr('src');
	if (name == "") {
		helpInfo("showOfficetwo","工作实景(2)不能为空，请输入");
		return false;
	}
	helpInfo("showOfficetwo","");
}

function checkOfficethree()
{
	var name = $("#officethreeshow").attr('src');
	if (name == "") {
		helpInfo("showOfficethree","工作实景(2)不能为空，请输入");
		return false;
	}
	helpInfo("showOfficethree","");
}
