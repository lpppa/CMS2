<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap-3.3.7-dist\css\bootstrap.css"/>
<script src="${pageContext.request.contextPath }/jquery-3.2.1\jquery-3.2.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath }/bootstrap-3.3.7-dist\js\bootstrap.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/homePage.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/myAjax.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/articleRead.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/userInfo.css" />

<title>adminPage</title>
</head>
<body>
	<div class="main" style="height:1200px;overflow:auto;" id="main">
		
		<div class="container-fluid child" style='height:1300px' >
			<div class="homePage_nav row">
				<div class="nav_logo col-xs-2 col-sm-2 col-md-2">
					<!-- <img src="../img/logo.png" /> -->
				</div>
				<div class="nav_center col-xs-7 col-sm-7 col-md-7">
					<span class="nav_zhuye">
						<a href="${pageContext.request.contextPath }/mainPage">
	  						<span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页
	  						</a>
	  					</span>
					<form class="search_form form-inline" action="${pageContext.request.contextPath }/articleShow" method="post">
						<div class="form-group">
							<input type="text" class="homePage_search form-control" id="exampleInputName2" name="articleTitle" placeholder="请输入要搜索的...">
							<button type="submit" class="homePage_search btn btn-default">搜索</button>
						</div>
					</form>
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<span class="nav_login"><a href="${pageContext.request.contextPath }/User/userLogin.jsp">登录</a></span>
				</div>
			</div>
			<div class="page_content row">
				<div class="col-xs-1 col-sm-1 col-md-1"></div>
				<div class="col-xs-1 col-sm-1 col-md-1">
					<div class="content_list btn-group-vertical btn-block" role="group" aria-label="...">
						<ul id="articleTypeList">
							<c:forEach var="articleType" items="${articleTypeList }">
								<li><a href="${pageContext.request.contextPath }/searchByArticleType?articleTypeId=${articleType.articleTypeId }"><input type="button" class="btn btn-default" value="${articleType.articleTypeName }"></a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="homePage_top col-xs-7 col-sm-7 col-md-7 ">
				
				<div class="content_carofusel">
				
					<jsp:include page="${slideShowPage }"></jsp:include>
				</div>
				<div>
						<jsp:include page="${articlePage }"></jsp:include>
				</div>
			</div>
				<div class="col-xs-2 col-sm-2 col-md-2">
					<div class="guanggao">
							<jsp:include page="${loginPage }"></jsp:include>
					</div>
					<div class="guanggao">
						<c:forEach var="advertisement" items="${advertisementList }">
							<a href="${advertisement.advertisementUrl }"><img src="${advertisement.advertisementImg }" style="width:200px;height:50px"></a>
						</c:forEach>
					</div>
					<div class="guanggao">

					</div>
				</div>
				<div class="col-xs-1 col-sm-1 col-md-1"></div>
			</div>
			</div> 
			</div>
<script type="text/javascript">	
	$(document).ready(function(){  
    $(".main").unbind("scroll").bind("scroll", function(e){  
        var sum = this.scrollHeight;  
        if (sum <= $(this).scrollTop() + $(this).height()) {
            var req=getXMLHttpRequest();
            req.onreadystatechange=function(){
		        if (req.readyState==4 && req.status==200){
		        	var List = eval('(' + req.responseText + ')');
					for (var i = 0; i < List.length; i++) {
						var p=document.createElement("div");
						p.setAttribute("id","div"+i);
						var p1 = '<div class="articleBox"><div class="articlePiece"><div class="articleContent"><div class="articlePicture"><a href="${pageContext.request.contextPath }/articleShow?articleId='+List[i].articleId+'"><img class="picture" src='+List[i].articlepicture+' /></a></div><div class="articleTitle"><a href="${pageContext.request.contextPath }/articleShow?articleId='+List[i].articleId+'>'+List[i].articleTitle+'</a></div><div class="articleText">'+List[i].articleContent+'</div><div class="articleInfo"><span><img class="userPicture" src="#" alt="" /></span><span class="userName">@用户名'+List[i].userAccountId+'</span><div class="rightShift"><span class="likeNumber"><span class="glyphicon glyphicon-thumbs-up"></span><span>'+List[i].likeNumber+'</span></span><span class="reportNumber"><span class="glyphicon glyphicon-earphone"></span><span>'+List[i].reportNumber+'</span></span><span class="hits"><span class="glyphicon glyphicon-eye-open"></span><span>'+List[i].hits+'</span></span></div></div></div></div></div>';
						$("#i").html(p1);
						$("#hi").append(p1);
					};   	
		        };
            };
            req.open("post","${pageContext.request.contextPath }/articleMore");
            req.send(null);
        };  
    });  
}); 
</script>
</body>
</html>