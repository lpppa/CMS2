<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户管理</title>
	</head>
	<body>
		<div class="headline">
		<br>
			<span style="text-align: center;"><h3>用户管理</h3></span>
		</div>
		<div class="container">
			<div class="row">
				<form action="${pageContext.request.contextPath }/userShow" method="post">
					<div id="search">
						<input type="text" id="s_adminUserName" name="s_adminUserName" class="input-medium search-query" placeholder="要查询头条号的帐号" />
						<input type="submit" value="查询" />
						<a href="${pageContext.request.contextPath }/userShow"><input type="button" value="查询所有用户" /></a>
					</div>
					<br />
					<br />
					<table class="table table-bordered table-hover table-striped table-condensed" style="border: 3px solid white">
						<tr>
							<th style="border-color: white">用户名</th>
							<th style="border-color: white">昵称</th>
							<th style="border-color: white">发表文章数</th>
							<th style="border-color: white">性别</th>
							<th style="border-color: white">点赞数</th>
							<th style="border-color: white">电话</th>
							<th style="border-color: white">地址</th>
							<th style="border-color: white">被举报数</th>
						</tr>
						<c:forEach var="myuser" items="${userList }">
							<tr>
								<td>${myuser.userAccount }</td>
								<td>${myuser.userName }</td>
								<td>发表文章数目</td>
								<td>${myuser.userSex }</td>
								<td>点赞数</td>
								<td>${myuser.userPhone }</td>
								<td>${myuser.userAddress }</td>	
								<td>被举报数目</td>
							</tr>
						</c:forEach>
					</table>
					<h2>${admin_user_search_msg }</h2>
				</form>
			</div>
		</div>
	</body>
</html>