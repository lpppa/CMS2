<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目管理</title>

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
		<form action="${pageContext.request.contextPath }/articleShowAll"
			method="post" onSubmit=" return checkform('articleTypeName')">
			<input type="text" id="articleTypeName" name="articleTypeName"
				required="required" placeholder="请输入栏目名">
			<button type="submit" >查询</button>
			<a href="${pageContext.request.contextPath }/articleShowAll"><input
				type="button" value="重置"></a><a href="${pageContext.request.contextPath }/admin/maintemp.jsp"><input type ="button" value="返回上一层"></a>
		</form>
		<table>
			<tr>
				<td>栏目名称</td>
				<td>栏目文章数</td>
				<td>创建时间</td>
				<td><a
					href="${pageContext.request.contextPath }/articleType/articleTypeAdd.jsp"><input
						type="button" value="添加栏目"></a></td>
			</tr>
			<c:forEach var="articleType" items="${articleTypeList }">
				<tr>
					<td>${articleType.articleTypeName }</td>
					<td>${articleType.articleNumber }</td>
					<td>${articleType.createTime }</td>
					<td>
							<a href="#"><input type="button" value="删除" onclick="firm('${articleType.articleTypeName }')"></a>
							</td>
					<td><a
						href="${pageContext.request.contextPath }/articlearticletypesearch?articleTypeId=${articleType.articleTypeId }"><input type="button" value="修改"></a></td>
				</tr>
			</c:forEach>
		</table> 
		${msg }
	</div>
</body>
</html>