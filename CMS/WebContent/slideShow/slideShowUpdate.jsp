<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/slideShowUpdate?slideShowId=${slideShow.slideShowId }" method="post" enctype="multipart/form-data">
	<ul>
	<c:forEach var="slideShow" items="${slideShowList }">
		<input type="text" name="slideShowName" value="${slideShow.slideShowName }" />
		<input type="text" name="slideShowUrl" value="${slideShow.slideShowUrl }" />
		<img src="${slideShow.slideShowSrc }"/>
		<input type="file" name="slideShowSrc" />
		<input type="submit" value="修改" />
	</c:forEach>
	</ul>
</form>
</body>
</html>