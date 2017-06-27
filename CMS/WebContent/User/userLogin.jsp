<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css" src="${pageContext.request.contextPath }/userLogin111.css"></style>
<script type="text/javascript">
			$(document).ready(function(){
			  $("form").submit(function(){
					var account=$("#account");
					var password=$("#password");
					if(account=="" && password==null){
						alert("帐号或密码不能为 空");
						return false;
					}else{
						return true;
					}
				});
			});
</script>
</head>
<body>

<div class="container-fluid">
			<div class="row">
				<div class="sbj">
					<h2 id="welcome">欢迎登录</h2>
					<form action="${pageContext.request.contextPath }/mainPage?login=true" method="post">
						 <div class="input-group">
						 	<span class="input-group-addon">
						 		<span class="glyphicon glyphicon-user"></span>
						 	</span>
							<input class="form-control" type="text" id="account" name="userAccount" placeholder="请输入用户名" /><br/>
						 </div>
						 <span style="color=red">${msg }</span>
						 <br />
						 <div class="input-group">
						 	<span class="input-group-addon">
						 		<span class="glyphicon glyphicon-lock"></span>
						 	</span>
							<input class="form-control" type="password" id="password" name="userPassword" placeholder="请输入密码" /><br/>
						 </div>
						<div class="checkbox">
							<label>
								<input type="checkbox" id="remember_account" name="remember_account">自动登录
							</label>
						</div>
						<input class="btn btn-info form-control" type="submit" value="登录" /><br /><br />
						<button class="btn btn-info form-control"><a id="register" href="${pageContext.request.contextPath }/User/userRegister.jsp">注册</a></button>
					</form>

				</div>
			</div>
		</div>
</body>
</html>