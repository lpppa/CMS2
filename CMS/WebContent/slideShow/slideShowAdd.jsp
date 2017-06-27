<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/slideShowAdd" method="post" enctype="multipart/form-data">
	<input type="text" name="slideShowName" placeholder="请输入轮播图的名称"/>
	<input type="text" name="slideShowUrl"  placeholder="请输入轮播图的跳转地址"/>
	<input type="file" name="slideShowImg" />	
	<input type="submit" value="添加" />
</form>
</body>
</html>