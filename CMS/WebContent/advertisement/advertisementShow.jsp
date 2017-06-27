<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>广告管理</title>
	</head>

	<body>
		<div class="headline">
		<br>
			<span style="text-align: center;"><h3>广告管理</h3></span>
		</div>
		<div class="container">
			<div class="row">
				<div id="search">
					<form action="${pageContext.request.contextPath }/advertisementShow" method="post">
						<input type="text" name="s_advertisementName" id="s_advertisementName" placeholder="请输入要搜索的广告名称" />
						<input type="submit" value="搜索" />
						<a href="${pageContext.request.contextPath }/advertisementShow"><input type="button" value="重置" /></a>
						<a href="${pageContext.request.contextPath }/advertisementAdd"><input type="button" value="添加广告" /></a>
					</form>
				</div>
				<br />
				<br />
				<table class="table table-bordered table-hover table-striped " style="border: 3px solid white">
					<tr>
						<th style="border-color: white">广告图片</th>
						<th style="border-color: white">广告名称</th>
						<th style="border-color: white">广告超链接跳转地址</th>
						<th style="border-color: white">操作</th>
					</tr>
					<c:forEach var="advertisement" items="${advertisementList }">
						<tr>
							<td style="border-color: white">
							<img alt="#" src="${advertisement.advertisementImg }" style="width:150px">
							</td>
							<td style="border-color: white">
								<span>${advertisement.advertisementName }</span>
							</td>
							<td style="border-color: white">
								<a href="${advertisement.advertisementUrl }">${advertisement.advertisementUrl }</a>
							</td>
							
							<td style="border-color: white"><a href="${pageContext.request.contextPath }/advertisementUpdata?advertisementName=${advertisement.advertisementName}"><button type="button" class="btn btn-warning ">修改</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath }/advertisementDelete?advertisementId=${advertisement.advertisementId}"><button type="button" class="btn btn-danger " >删除</button></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>

</html>