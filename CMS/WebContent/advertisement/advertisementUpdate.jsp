<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updataImg</title>
<style type="text/css">
	img{
		width:150px
	}
</style>
</head>

<body>
<form action="${pageContext.request.contextPath }/advertisementUpdata?advertisementId=${advertisement.advertisementId }"  enctype="multipart/form-data" method="post">
	广告名称：<input type="text" name="advertisementName" id="advertisementName" value="${advertisement.advertisementName }"><br/>
	广告跳转地址：<input type="text" name="advertisementUrl" id="advertisementUrl" value="${advertisement.advertisementUrl }"><br/>
	<input type="file" name="advertisementImg" id="advertisementImg"><br/>
	<input type="submit" value="提交"/><br>
	广告图片<br>
	<img alt="#" src="${advertisement.advertisementImg }">
</form>
</body>
</html>