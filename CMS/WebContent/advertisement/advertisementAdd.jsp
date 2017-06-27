<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/advertisementAdd" method="post" enctype="multipart/form-data"><br/>
	<input type="text" name="advertisementName" id="advertisementName" placeholder="广告名称"><span>${advertisementAddTips }</span><br/>
	<input type="text" name="advertisementUrl" id="advertisementUrl" placeholder="广告超链接地址"><br/>
	<input type="file" name="advertisementImg" id="advertisementImg"><br/>
	<input type="submit" value="提交">
	<a href="${pageContext.request.contextPath }/advertisementShow"><input type="button" value="返回"/></a>
</form>
</body>
</html>