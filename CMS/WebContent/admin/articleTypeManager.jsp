<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
			function firm(articleTypeName) {
				if (confirm("你确定要删除该栏目！")) {
					window.location ="${pageContext.request.contextPath }/articlearticletypedetele?articleTypeName="+articleTypeName;
				} else {
					alert("已经取消该操作！");
				}
			}
			function checkform(articleTypeName){
			var articleTypeName=document.getElementById('articleTypeName').value;
			if(articleTypeName.match(" ")){
				alert("请输入正确的栏目名格式!注意栏目名前面是否有空格!");
				 return false
			}else{
				return true;
			}
		}
</script>
    </head>
    <body>
    	<div>
		<form action="${pageContext.request.contextPath }/articleTypeShowAll"method="post" onSubmit=" return checkform('articleTypeName')">
			<input type="text" id="s_articleTypeName" name="s_articleTypeName"required="required" placeholder="请输入栏目名">
			<button type="submit" >查询</button>
			<a href="${pageContext.request.contextPath }/articleTypeAdd"><input type="button" value="添加栏目"></a>
		</form>
		<jsp:include page="${articleTypePage }"></jsp:include>
			${msg }
	</div>
 	</body>
</html>