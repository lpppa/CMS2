<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>private</title>
</head>
<body>
<div>
	<ul>
		<li><a href="${pageContext.request.contextPath }/s_userMessageMainPage?userId=${user.userId}&private=true">我的主页</a></li>
		<li><a href="${pageContext.request.contextPath }/s_userMessagePage?userId=${user.userId}&private=true">个人信息</a></li>
		<li><a href="${pageContext.request.contextPath }/articleWrite">写文章</a></li>
		<li><a href="#">文章管理</a></li>
		<li><a href="#">个人信息修改</a></li>
	</ul>
</div>
<div>
	<jsp:include page="${s_userPage }"></jsp:include>
</div>
</body>
</html>