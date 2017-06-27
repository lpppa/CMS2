<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/afterLogin.css" />
        <title>JSP Page</title>
    </head>
    <body>
    	<div class="guanggao" id="info_border">
			<div id="avatar">
				<a href="${pageContext.request.contextPath }/s_userMessageMainPage?userId=${currentUser.userId }"><img id="avatar_img" src="../img/13.jpg" /></a>
			</div>
			<div id="userName">
				<a href="${pageContext.request.contextPath }/s_userMessageMainPage?userId=${currentUser.userId }">${currentUser.userName }</a>
			</div>
		</div>
 	</body>
</html>