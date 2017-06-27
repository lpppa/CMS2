<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<ul>
		<li><a href="${pageContext.request.contextPath }/s_userMessageMainPage?userId=${user.userId}">他的主页</a></li>
		<li><a href="${pageContext.request.contextPath }/s_userMessagePage?userId=${user.userId}">个人信息</a></li>
	</ul>
</div>
<div>
	<jsp:include page="${s_userPage }"></jsp:include>
</div>
</body>
</html>