<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adminMainPage</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap-3.3.7-dist\css\bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/Manager.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/articleReport.css" />
    </head>
  
 	<body>
		<div class="navbar navbar-default navbar-fixed-top">
			<ul>
				<li><img src="${pageContext.request.contextPath }/img/houtaiguanli.png" style="margin-left: 49px;" /></li>
				<li style="float: right; margin-top: -35px;margin-right: 30px;"><a href="返回登录页面">退出</a></li>
			</ul>
		</div>
		<div class="row">
			<div id="left-border">
				<ul>
					<li>
						<a href="${pageContext.request.contextPath }/userShow" class="btn btn-info btn-lg buttonStyle "> <span class="glyphicon glyphicon-user"></span>&nbsp;用户管理</a>
					</li>
					<li><a href="${pageContext.request.contextPath }/articleTypeShowAll?page=admin" class="btn btn-info btn-lg buttonStyle"><span class="glyphicon glyphicon-th-list"></span>&nbsp;栏目管理</a></li>
					<li><a href="${pageContext.request.contextPath }/advertisementShow" class="btn btn-info btn-lg buttonStyle"><span class="glyphicon glyphicon-font"></span>&nbsp;广告管理</a></li>
					<li><a href="${pageContext.request.contextPath }/slideShow" class="btn btn-info btn-lg buttonStyle"><span class="glyphicon glyphicon-picture"></span>&nbsp;轮播图管理</a></li>
					<li><a href="${pageContext.request.contextPath }/articleReportShow" class="btn btn-info btn-lg buttonStyle"><span class="glyphicon glyphicon-ban-circle"></span>&nbsp;举报文章管理</a></li>
				</ul>
			</div>
			<div  id="right-border" >
				<div>
					<jsp:include page="${adminPage }"></jsp:include>
				</div>
			</div>
		</div>
		<div class="row">
		</div>
		<script src="${pageContext.request.contextPath }/jquery-3.2.1\jquery-3.2.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/bootstrap-3.3.7-dist\js\bootstrap.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>