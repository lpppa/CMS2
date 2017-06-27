<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-3.2.1/jquery-3.2.1.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath }/js/myAjax.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userRegister.js"></script>
<script type="text/javascript">
	$("document").ready(function(){
		$("form").submit(function(){
			alert(1);
			alert($("#userPassword").val());
			/*if($("#userPassword").val() == ""){
				alert("怎么说？");
				return false;
			}else{
				alert(1);
				out.write("1");
			}*/
		});
		
	});
</script>
<title>用户注册</title>
</head>
<body>
	<div>
		<form action="#" method="post" name="registerForm">
			帐号：<input type="text" id="userAccount" name="userAccount" placeholder="请输入用户名" /><span id="userAccountTips"></span><br />
			密码:<input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" /><span id="passwordTips"></span><br /> 
			确认密码:<input type="password" id="userPasswordComfirm" name="userPasswordComfirm" placeholder="请确认密码" /><span id="userPasswordComfirmTips"></span><br /> 
                               昵称:<input type="text" id="userName" name="userName"  placeholder="请输入姓名" /><span id="userNametips"></span><br />
			性别:<input type="radio" id="usersex" name="usersex" value="男" checked="checked" />男<input type="radio" id="usersex" name="usersex" value="女" />女<br /> 
			生日:<input type="date" id="userBirthday" name="userBirthday"  /><br /> 
	                     电子邮箱:<input type="email" id="userEmail" name="userEmail" placeholder="请输入邮箱" /><span id="userEmailTips"></span><br /> 
			手机号码:<input type="tel" id="userPhoneNumber" name="userPhoneNumber" placeholder="请输入手机号" /><span id="userPhoneNumberTips"></span><br />
			住址:<select id="userAddressProvince" name="userAddressProvince">
				<option>选择省份</option>
				<c:forEach var="addressp" items="${provinceList }">
					<option value="${addressp.provinceId }" id="provinceId">${addressp.provinceName }</option>
				</c:forEach>
			</select> <select id="userAddressCity" name="userAddressCity">
				<option>选择城市</option>
				<c:forEach var="addressc" items="${cityList }">
					<option value="${addressc.cityId }" id="cityId">${addressc.cityName }</option>
				</c:forEach>
			</select><br /> <input type="submit" value="注册" />
		</form>
	</div>
</body>
</html>