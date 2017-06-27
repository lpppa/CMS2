<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function pass(){
		if(confirm('确定通过该篇文章的审核吗？')){
			return true;
		}else{
			return false;
		}
	}
	function del(){
		if(confirm('确定删除该篇文章吗？')){
			return true;
		}else{
			return false;
		}
	}

</script>
<title>文章审核</title>
</head>
<body id="review_body">
<jsp:include page="${articleReportPage }"></jsp:include>

</body>
</html>