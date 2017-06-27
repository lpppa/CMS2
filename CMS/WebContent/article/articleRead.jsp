<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {

	//限制点赞次数
	$("#articleIdLike").click(function() {
			$("#articleIdLike").attr("disabled", "disabled");
			$("#articleIdLike").css("background-color", "red");
			});
	//限制举报次数
	$("#articleIdReport").click(function() {
			$("#articleIdReport").attr("disabled", "disabled");
			$("#articleIdReport").css("background-color", "red");
			});
	//显示浏览提示
	$("#articleIdHits").click(function() {
			/* $("#articleIdHits").attr("disabled", "disabled"); */
			$("#articleIdHits").css("background-color", " orange");
			});
	//点赞数自增
	$("#articleIdLike").click(function() {
			var likeMsg = document.getElementById("likeMsg");
			var xhr = getXMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4&& xhr.status == 200) {
						likeMsg.innerHTML = "<span>"+ xhr.responseText+ "</span>";
					}
				}
			xhr.open("get","${pageContext.request.contextPath }/articleLikeShow?articleId="+ $("#articleIdLike").val());
			xhr.send(null);
		});

	//举报数自增
	$("#articleIdReport").click(function(){
			var reportMsg = document.getElementById("reportMsg");
			var xhr = getXMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
						reportMsg.innerHTML = "<span>"+ xhr.responseText + "</span>";
					}
				}
			xhr.open("get","${pageContext.request.contextPath }/articleReport?articleId="+ $("#articleIdReport").val());
			xhr.send(null);
	});
	});

	
	</script>
</head>
<body>
	<div class="article_box">
			<!--          以下是文章标题及作者信息                              -->
			<div class="article_title">
				<span id="article_title">${article.articleTitle }</span>
			</div>
			<div class="artile_info">
				<span id="article_writer">作者：${article.userName }</span>
			</div>
			<!--          以下是正文内容              -->
			<div class="article_content">
				<div id="article_content">
					${article.articleContent }
				</div>
			</div>
			<!--          以下是文章底部内容，点赞和举报                          -->
			<div class="artile_bottom">
				<span id="likeMsg">${article.likeNumber }</span><span id="hit_like" class="glyphicon glyphicon-thumbs-up" aria-hidden="true"><button type="button" id="articleIdLike" name="articleId" value="1">点赞</button></span><br/>
				<span id="likeMsg">${article.likeNumber }</span><span id="hit_report" class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"><button type="button" id="articleIdReport" name="articleId" value="2">举报</button></span><br/>
			</div>
		</div>
</body>
</html>