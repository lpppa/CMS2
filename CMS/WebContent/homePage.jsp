<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/homePage.css" />
		<title>主页</title>
	</head>
	<body>
		<div class="container-fluid">
			//head
			<div class="homePage_nav row">
				<div class="nav_logo col-xs-2 col-sm-2 col-md-2">
					<img src="../img/logo.png" />
				</div>
				<div class="nav_center col-xs-7 col-sm-7 col-md-7">
					<span class="nav_zhuye">
	  						<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
	  						主页
	  				</span>
					<form class="search_form form-inline">
						<div class="form-group">
							<input type="text" class="homePage_search form-control" id="exampleInputName2" placeholder="请输入要搜索的...">
							<button type="submit" class="homePage_search btn btn-default">搜索</button>
						</div>
					</form>
				</div>
				<div class="col-xs-3 col-sm-3 col-md-3">
					<span class="nav_login">登录</span>
				</div>
			</div>
			//文章类别
			<div class="page_content row">
				<div class="col-xs-1 col-sm-1 col-md-1"></div>
				<div class="col-xs-1 col-sm-1 col-md-1">
					<div class="content_list btn-group-vertical btn-block" role="group" aria-label="...">
						<button type="button" class="btn btn_blue">文章类别</button>
						<button type="button" class="btn btn-default">热点</button>
						<button type="button" class="btn btn-default">视频</button>
						<button type="button" class="btn btn-default">图片</button>
						<button type="button" class="btn btn-default">段子</button>
						<button type="button" class="btn btn-default">社会</button>
						<button type="button" class="btn btn-default">娱乐</button>
						<button type="button" class="btn btn-default">科技</button>
						<button type="button" class="btn btn-default">体育</button>
						<button type="button" class="btn btn-default">汽车</button>
						<button type="button" class="btn btn-default">财经</button>
						<button type="button" class="btn btn-default">搞笑</button>
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">更多</button>
					</div>
				</div>
				
				//文章显示
				<div class="homePage_top col-xs-7 col-sm-7 col-md-7">
					<div class="content_carofusel"></div>
						<div class="articleBox">
							<div class="articlePiece">
								<div class="articlePicture">
									<a href="${pageContext.request.contextPath }/articleShow?articleId=${article.articleId}"><img class="picture" src="${article.articlepicture }" /></a>
								</div>
								<div class="articleContent">
									<div class="articleTitle">
										<a href="${pageContext.request.contextPath }/articleShow?articleId=${article.articleId}">${article.articleTitle }</a>
									</div>
									<div class="articleText">
										${article.articlecontent }
									</div>
									<div class="articleInfo">
										<span><img class="userPicture" src="../img/01.jpg" alt="" /></span>
										<span class="userName">@用户名${article.userAccountId }</span>
										<span class="createTime">${article.releaseTime }</span>
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
				</div>
				
				</div>
				//右边栏
				<div class="col-xs-2 col-sm-2 col-md-2">
					<div class="guanggao">

					</div>
					<div class="guanggao">

					</div>
					<div class="guanggao">

					</div>
				</div>
				<div class="col-xs-1 col-sm-1 col-md-1"></div>
			</div>

		</div>
	</body>

</html>