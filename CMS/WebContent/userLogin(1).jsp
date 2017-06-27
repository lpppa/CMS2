<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/2.2.0/jquery.js"></script>

</head>
<body>
<h2>登录模版</h2>
<div>
	<form action="${pageContext.request.contextPath }/login" method="post">
		请输入用户名：<input type="text" id="account" name="userAccount" placeholder="请输入用户名" required="required"/><br/>
		请输入密码：<input type="password" id="password" name="userPassword" placeholder="请输入密码" required="required"/><br/>
		记住密码：<input type="checkbox" id="remember_account" name="remember_account"><br/>
		<input type="submit" value="登录" onclick="login()"/>
		<a href="${pageContext.request.contextPath }/User/userRegister.jsp">注册</a>
	</form>
</div>
</body>
<script type="text/javascript">
	 $(document).ready(function(){
		if($("#msg").val().length > 0 ){
			alert($("#msg").val());
		}
	});
</script>
</html>