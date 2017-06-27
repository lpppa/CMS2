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

<div class="headline">
		<br>
			<span style="text-align: center;"><h3>文章审核</h3></span>
		</div>
<div class="container">
			<div class="row">
				<table class="table table-bordered table-hover table-striped table-condensed " style="border: 3px solid white">
					<tr>
						<th style="border-color: white">用户名</th>
						<th style="border-color: white">文章名</th>
						<th style="border-color: white">类别</th>
						<th style="border-color: white">举报数</th>
						<th style="border-color: white">操作</th>
					</tr>
					<c:forEach var="article" items="${articleReportlist }">
						<tr>
							<td style="border-color: white">${article.userName }</td>
							<td style="border-color: white">${article.articleTitle }</td>
							<td style="border-color: white">${article.articleTypeName }</td>
							<td style="border-color: white">${article.reportNumber }</td>
							<td style="border-color: white">
								<a onclick="return pass()"  href="${pageContext.request.contextPath }/articleReportManager?articleId=${article.articleId}&action=pass"><button class="btn btn-success btn-xs">通过</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="return del()"  href="${pageContext.request.contextPath }/articleReportManager?articleId=${article.articleId}&action=delete"><button class="btn btn-danger btn-xs">删除</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath }/Servlet3?id=${article.articleId }"><button class="btn btn-primary btn-xs">查看</button></a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<h2>${admin_articleType_search_msg }</h2>
			</div>
		</div>

</body>
</html>