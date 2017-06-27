<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<script src="jquery-3.2.1/jquery-3.2.1.js" type="text/javascript"></script>  
<script type="text/javascript" src="js/myAjax.js"></script>
</head>  
<body>  
    <div>下拉加载更多</div>  
    <div class="main" style="height:1200px;overflow:auto;" id="main">  
        <div class="child" style='border:1px solid red;margin-top:20px;color:grey;height:1300px' ></div>  
    </div>  
</body>  
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
						var p=document.createElement("div");
						p.setAttribute("id","div"+i);
						var p1 = '<div class="articleBox"><div class="articlePiece"><div class="articleContent"><div class="articlePicture"><a href="${pageContext.request.contextPath }/articleShow?articleId='+List[i].articleId+'"><img class="picture" src='+List[i].articlepicture+' /></a></div><div class="articleTitle"><a href="${pageContext.request.contextPath }/articleShow?articleId='+List[i].articleId+'>'+List[i].articleTitle+'</a></div><div class="articleText">'+List[i].articleContent+'</div><div class="articleInfo"><span><img class="userPicture" src="#" alt="" /></span><span class="userName">@用户名'+List[i].userAccountId+'</span><span class="createTime">${article.releaseTime }</span><div class="rightShift"><span class="likeNumber"><span class="glyphicon glyphicon-thumbs-up"></span><span>'+List[i].likeNumber+'</span></span><span class="reportNumber"><span class="glyphicon glyphicon-earphone"></span><span>'+List[i].reportNumber+'</span></span><span class="hits"><span class="glyphicon glyphicon-eye-open"></span><span>'+List[i].hits+'</span></span></div></div></div></div></div>';
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
</body>  
</html>
