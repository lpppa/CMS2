<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目修改</title>
<script type="text/javascript">
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
	 <form action="${pageContext.request.contextPath }/articleTypeNameUpdate?articleTypeId=${articleType.articleTypeId }" method="post" onsubmit="return checkform('${articleType.articleTypeId },${articleType.articleTypeName }')">
		<input type="text" id="articleTypeName" name="articleTypeName"  value="${articleType.articleTypeName }" required="required" placeholder=${msg }><br>
		<input type="submit" value="确认修改" ><a href="${pageContext.request.contextPath }/articleTypeShowAll"><input type ="button" value="返回上一页"></a>
	</form>
	</div>
</body>
</html>