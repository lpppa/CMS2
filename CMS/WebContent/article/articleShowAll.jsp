<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-3.2.1/jquery-3.2.1.js"></script>
<style type="text/css"> 
	img{
		width:150px;
	}
	li{
		list-style: none;
	}
</style>
<script  type="text/javascript">  
$(document).ready(function(){  
    $(".main").unbind("scroll").bind("scroll", function(e){  
        var sum = this.scrollHeight;  
        if (sum <= $(this).scrollTop() + $(this).height()) {
            var req=getXMLHttpRequest();
            req.onreadystatechange=function(){
		        if (req.readyState==4 && req.status==200){
		        	var List = eval('(' + req.responseText + ')');
					for (var i = 0; i < List.length; i++) {
						alert(List[i].articlepicture);
						var p=document.createElement("div");
						p.setAttribute("id","div"+i);
						var p1 = '<div class="articleBox"><div class="articlePiece"><div class="articleContent"><div class="articlePicture"><a href="${pageContext.request.contextPath }/articleShow?articleId='+List[i].articleId+'"><img class="picture" src='+List[i].articlepicture+' /></a></div><div class="articleTitle"><a href="${pageContext.request.contextPath }/articleShow?articleId='+List[i].articleId+'>'+List[i].articleTitle+'</a></div><div class="articleText">'+List[i].articleContent+'</div><div class="articleInfo"><span><img class="userPicture" src="#" alt="" /></span><a href="${pageContext.request.contextPath}/s_userMessageMainPage?userId=${article.userAccountId }"><span class="userName">@用户名'+List[i].userAccountId+'</span></a></span><div class="rightShift"><span class="likeNumber"><span class="glyphicon glyphicon-thumbs-up"></span><span>'+List[i].likeNumber+'</span></span><span class="reportNumber"><span class="glyphicon glyphicon-earphone"></span><span>'+List[i].reportNumber+'</span></span><span class="hits"><span class="glyphicon glyphicon-eye-open"></span><span>'+List[i].hits+'</span></span></div></div></div></div></div>';
						$("#i").html(p1);
						$("#main").append(p1);
					};   	
		        };
            };
            req.open("post","${pageContext.request.contextPath }/articleMore");
            req.send(null);
        };  
    });  
});
</script>
</head>
<body>
	<div id="hi">
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
						<span class="userName">@用户名${article.userAccountId }</span>
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
	</div>
</body>
</html>