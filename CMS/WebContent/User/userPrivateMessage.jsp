<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<ul>
			<li>帐号:${user.userAccount }</li>
			<li>用户名：${user.userName }</li>
			<li>性别：${user.userSex }</li>
			<li>出生年月：${user.userBirthday }</li>
			<li>电话：${user.userPhone }</li>
			<li>Email：${user.userEmail }</li>
			<li>地址：${user.userAddress }</li>
  		</ul>
</body>
</html>