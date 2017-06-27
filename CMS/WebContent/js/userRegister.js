window.onload=function(){

	/*$("form").submit(function(){
	    alert("Submitted");
	  });*/
	$("#userAccount").blur(
			function() {
				var a = $("#userAccount").val();
				var xhr = getXMLHttpRequest();
				xhr.onreadystatechange = function() {
					if ($("#userAccount").val() == "") {
						$("#userAccountTips").html('<font color="red">帐号不能为空</font>');
					}
					if (xhr.readyState == 4 && xhr.status == 200) {
						if (xhr.responseText == "userAccountTrue") {
							$("#userAccountTips").html('<font color="green">可以使用</font>');
						} else {
							$("#userAccountTips").html('<font color="red">该帐号已被注册</font>');
						}
					}
				}
				xhr.open("post","../userCheck?userAccount="+ a);
				xhr.send(null);
			});

	$("#userName").blur(
			function() {
				var a = $("#userName").val();
				var xhr = getXMLHttpRequest();
				xhr.onreadystatechange = function() {
					if ($("#userName").val() == "") {
						$("#userNametips").html('<font color="red">昵称不能为空</font>');
					}
					if (xhr.readyState == 4 && xhr.status == 200) {
						if (xhr.responseText == "userNameTrue") {
							$("#userNametips").html('<font color="green">可以使用</font>');
						} else {
							$("#userNametips").html('<font color="red">该帐号已被注册</font>');
						}
					}
				};
				
				xhr.open("post","../userCheck?userName="+ a);
				xhr.send(null);
			});
	$("#userPassword").blur(function() {
		if ($("#userPassword").val() == "") {
			$("#passwordTips").html('<font color="red">密码不能为空</font>');
		} else {
			$("#passwordTips").html("");
		}
		if ($("#userPasswordComfirm").val() != "" && $("#userPassword").val() !=
	
		$("#userPasswordComfirm").val()) {
			$("#userPasswordComfirmTips").html('<font color="red">两次密码不一致</font>');
		} else {
			$("#userPasswordComfirmTips").html('');
		}
	});
	$("#userPasswordComfirm").blur(
			function() {
				if ($("#userPasswordComfirm").val() == "") {
					$("#userPasswordComfirmTips").html(
							'<font color="red">确认密码不能为空</font>');
				} else {
					$("#userPasswordComfirmTips").html("");
				}
				if ($("#userPassword").val() != $("#userPasswordComfirm").val()) {
					$("#userPasswordComfirmTips").html(
							'<font color="red">两次密码不一致</font>');
				} else {
					$("#userPasswordComfirmTips").html("");
				}
	
			});
	
	$("#userEmail").blur(function() {
		if ($("#userEmail").val() == "") {
			$("#userEmailTips").html('<font color="red">邮箱不能为空</font>');
		} else {
			$("#userEmailTips").html('');
		}
	});
	
	$("#userPhoneNumber").blur(function() {
		if ($("#userPhoneNumber").val() == "") {
			$("#userPhoneNumberTips").html('<font color="red">请输入手机号码</font>');
		} else {
			$("#userPhoneNumberTips").html('');
		}
	});
	
	
};