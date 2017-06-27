<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>栏目管理</title>
	</head>
	<body>
		<div class="headline">
		<br>
			<span style="text-align: center;"><h3>栏目管理</h3></span>
		</div>
		<div class="container">
			<div class="row">
			<div id="search">
				<form action="${pageContext.request.contextPath }/articleTypeShowAll"method="post" onSubmit=" return checkform('articleTypeName')">
					<input type="text" id="s_articleTypeName" name="s_articleTypeName"required="required" placeholder="请输入栏目名">
					<button type="submit" >查询</button>
					<a href="${pageContext.request.contextPath }/articleTypeAdd"><input type="button" value="添加栏目"></a>
				</form>
			</div>
				<br>
				<br>
				<table class="table table-bordered table-hover table-striped table-condensed " style="border: 3px solid white">
					<tr>
						<th style="border-color: white">栏目名称</th>
						<th style="border-color: white">栏目文章数</th>
						<th style="border-color: white">创建时间</th>
						<th style="border-color: white">操作</th>
					</tr>
					<c:forEach var="articleType" items="${articleTypeList }">
						<tr>
							<td style="border-color: white">${articleType.articleTypeName }</td>
							<td style="border-color: white">${articleType.articleNumber }</td>
							<td style="border-color: white">${articleType.createTime }</td>
							<td style="border-color: white">
								<a href="${pageContext.request.contextPath }/articleTypeDetele?articleTypeName=${articleType.articleTypeName }"><button type="button" class="btn btn-danger btn-sm" onclick="firm('${articleType.articleTypeName }')">删除</button></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath }/articleTypeNameUpdate?articleTypeName=${articleType.articleTypeName }"><button type="button" class="btn btn-warning btn-sm">修改</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<h2>${admin_articleType_search_msg }</h2>
			</div>
		</div>
	</body>
</html>