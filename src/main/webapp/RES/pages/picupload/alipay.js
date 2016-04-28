//图片上传
//var basePath = '${base}';
var basePath = $("#basePath").val();
function saveAlipay(flag){
	console.log(basePath)
	var apply_form = $('#apply_form');
	var param = $.serializeObject(apply_form);
	var now = new Date();
	var applyDate = now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate()+" "+(now.getHours()<10?"0":"")+now.getHours()+":"+(now.getMinutes()<10?"0":"")+now.getMinutes()+":"+(now.getSeconds()<10?"0":"")+now.getSeconds();
	console.log(applyDate);
	param.applyDate = applyDate;
	var paramJson = encodeURI(encodeURI(JSON.stringify(param)));
	
	var url = basePath + 'picupload/addAlipay.do?paramJson=' + paramJson;
	$.ajax({
		type : "post",
		url : url,
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success : function(data) {
			$("#save").removeAttr("disabled");
			if (data.status == "1") {
				alert(data.message);
			}else if (data.status == "0") {
				alert(data.message);
			}
		}
	});
}


function saveAlipay2(flag){
	console.log(basePath)
	var apply_form = $('#apply_form');
	var param = $.serializeObject(apply_form);
	var now = new Date();
	var applyDate = now.getFullYear()+"-"+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate()+" "+(now.getHours()<10?"0":"")+now.getHours()+":"+(now.getMinutes()<10?"0":"")+now.getMinutes()+":"+(now.getSeconds()<10?"0":"")+now.getSeconds();
	console.log(applyDate);
	param.applyDate = applyDate;
//	var coupon = new Object();
//	coupon.buttonPicture = buttonPicture;
//	coupon.backgroundPicture = backgroundPicture;
//	coupon.id = id;
	
	var url = basePath + 'picupload/addAlipay2.do';
	$.ajax({
		type : "post",
		url : url,
		data : param,
		dataType : "json",
		success : function(data) {
			$("#save").removeAttr("disabled");
			if (data.status == "1") {
				alert(data.message);
			}else if (data.status == "0") {
				alert(data.message);
			}
		}
	});
}

function goBack(flag){
	if(flag == "0"){
		window.location.href="${base}/payment/toAlipay.do";
	}else{
		window.location.href="${base}";
	}
	//window.history.back(-1); 
}

  //验证支付宝账号
function checknum(){
	var account = $("#account").val();
	if(account == ""){
		return false;
	}else{
		return true;
	}
}

function checkUphoto()
{
	var name = $("#cardPhotoUp").val();
	console.log("cardPhotoUp:"+name)
	if (name == "") {
		return false;
	}else{
		return true;
	}
}

function checkDphoto()
{
	var name = $("#cardPhotoDn").val();
	console.log("cardPhotoDn:"+name)
	if (name == "") {
		return false;
	}else{
		return true;
	}
}





function checkApply(){
	if( checknum() && checkUphoto() && checkDphoto() ){
		console.log("支付宝申请验证通过");
		return true;
	}else{
		console.log("支付宝申请验证失败");
		return false;
	}
}