<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mashen.domian.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户的详细信息</title>
</head>

<body>
	<ul >
		<li>ID：${user.userId }</li>
		<li>账号：${user.userAccount }</li>
		<li>用户名：${user.userName }</li>
		<li>性别：${user.userSex }</li>
		<li>出生年月：${user.userBirthday }</li>
		<li>Email：${user.userEmail }</li>
		<li>手机号码：${user.userPhone }</li>
		<li>地址：${user.userAddress }</li>
	</ul>
	<a href="${pageContext.request.contextPath }/userShowAll">返回</a>
</body>
</html>