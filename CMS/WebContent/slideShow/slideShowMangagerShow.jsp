<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	img{
		width:70px
	}
</style>
</head>
<body>
<div class="headline">
		<br>
			<span style="text-align: center;"><h3>轮播图管理</h3></span>
		</div>
	
<div class="container">
			<div class="row">
			<div id="search">
			<form action="" method="post">
				<input type="text" name="slideShowSearch" placheholder="请输入要查询的轮播图片名"/>
				<input type="submit" value="搜索" />
				<a href="${pageContext.request.contextPath }/slideShowAdd"><input type="button" value="添加轮播图" /></a>
			</form>
		</div>	
			<br>
			<br>
				<table class="table table-bordered table-hover table-striped table-condensed " style="border: 3px solid white">
					<tr>
						<th style="border-color: white">轮播图片</th>
						<th style="border-color: white">轮播图名称</th>
						<th style="border-color: white">轮播图跳转地址</th>
						<th style="border-color: white">是否推送</th>
						<th style="border-color: white">轮播图操作</th>
					</tr>
					<c:forEach var="slideShow" items="${slideShowList }">
						<tr>
							<td style="border-color: white"><img src="${slideShow.slideShowSrc }"></td>
							<td style="border-color: white">${slideShow.slideShowName }</td>
							<td style="border-color: white">${slideShow.slideShowUrl }</td>
							<td style="border-color: white">${slideShow.show }</td>
							<td style="border-color: white"><a href="${pageContext.request.contextPath }/slideShowManager?action=update&slideShowId=${slideShow.slideShowId }"><input type="button" value="修改"></a>
							<a href="${pageContext.request.contextPath }/slideShowManager?action=delete&slideShowId=${slideShow.slideShowId }"><input type="button" value="删除"></a>
							<a href="${pageContext.request.contextPath }/slideShowManager?action=showing&slideShowId=${slideShow.slideShowId }"><input type="button" value="推送"></a>
							<a href="${pageContext.request.contextPath }/slideShowManager?action=off&slideShowId=${slideShow.slideShowId }"><input type="button" value="下线"></a></td>
						</tr>
					</c:forEach>
				</table>
				<h2>${admin_articleType_search_msg }</h2>
			</div>
		</div>
</body>
</html>