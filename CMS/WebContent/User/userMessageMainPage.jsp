<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/userInfo.css" />

<style type="text/css">
	img{
		height:150px
	}
</style>
</head>
<body>
			<div class="container-fluid">
			<!--
            	以下是头部导航栏的代码
            -->
			<div class="row">
				<div class="col-xs-2 col-sm-2 col-md-2"></div>
				<div class="col-xs-8 col-sm-8 col-md-8">
					<div class="top">
						<div class="avatar">
							<img class="avatar_img" src="../img/13.jpg" alt="" />
							
						</div>
						<div class="userName">
							用户89757
						</div>
					</div>
					<div class="userInfo_nav">
						<span><a class="page_link" href="${pageContext.request.contextPath }/s_userMessageMainPage?userId=${user.userId }">我的主页</a></span>
						<span><a class="page_link" href="${pageContext.request.contextPath }/articleWrite">写文章</a></span>
					</div>
				</div>
				<div class="col-xs-2 col-sm-2 col-md-2"></div>
			</div>
			<!--
            	以下是用户基本信息的代码
            -->
			<div class="userInfo_box row">
				<div class="col-xs-2 col-sm-2 col-md-2"></div>
				<div class="col-xs-8 col-sm-8 col-md-8">
					<div class="userInfo_content">
						<!-------   内容标题         ------>
						<div class="title_box">
							<span class="info_title">基本信息</span>
						</div>
						<!-------   具体信息           ----->
						<div class="info_all">
							<div class="info_single">
								<div class="single_key">用户名</div>
								<div class="single_value">${user.userAccount }</div>
							</div>
							<div class="info_single">
								<div class="single_key">呢&nbsp;&nbsp;&nbsp;&nbsp;称</div>
								<div class="single_value">${user.userName }</div>
							</div>
							<div class="info_single">
								<div class="single_key">性&nbsp;&nbsp;&nbsp;&nbsp;别</div>
								<div class="single_value">${user.userSex }</div>
							</div>
							<div class="info_single">
								<div class="single_key">生&nbsp;&nbsp;&nbsp;&nbsp;日</div>
								<div class="single_value">${user.userBirthday }</div>
							</div>
							<div class="info_single">
								<div class="single_key">&nbsp;Email&nbsp;</div>
								<div class="single_value">${user.userEmail }</div>
							</div>
							<div class="info_single">
								<div class="single_key">手机号码</div>
								<div class="single_value">${user.userPhone }</div>
							</div>
							<div class="info_single">
								<div class="single_key">所在地</div>
								<div class="single_value">所在地</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-2 col-sm-2 col-md-2"></div>
			</div>
		</div>
	</body>
	<div>
		<ul>
			<c:forEach var="article" items="${articleList }">
		<div class="articleBox">
			<div class="articlePiece">
				<div class="articleContent">
					<div class="articlePicture">
						<a href="${pageContext.request.contextPath }/articleShow?articleId=${article.articleId}"><img class="picture" src="${article.articlepicture }" /></a>
					</div>
					<div class="articleTitle">
						<a href="${pageContext.request.contextPath }/articleShow?articleId=${article.articleId}">${article.articleTitle }</a>
					</div>
					<div class="articleText">
						${article.articleContent }
					</div>
					<div class="articleInfo">
						<span><img class="userPicture" src="#" alt="" /></span>
						<a href="${pageContext.request.contextPath }/s_userMessageMainPage?userId=${article.userAccountId }"><span class="userName">@用户名${article.userAccountId }</span></a>
						<div class="rightShift">
							<span class="likeNumber">
				<span class="glyphicon glyphicon-thumbs-up"></span>
							<span>${article.likeNumber }</span>
							</span>
							<span class="reportNumber">
				<span class="glyphicon glyphicon-earphone"></span>
							<span>${article.reportNumber }</span>
							</span>
							<span class="hits">
				<span class="glyphicon glyphicon-eye-open"></span>
							<span>${article.hits }</span>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
		</ul>
	</div>
</body>
</html>