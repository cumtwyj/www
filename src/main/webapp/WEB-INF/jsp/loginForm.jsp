<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>登录页面</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
		if($.cookie("rmbUser")=="true"){
			$("#checkbox").attr("checked",true);
			$("#loginname").val($.cookie("name"));
			$("#password").val($.cookie("pwd"));
		}
	})
	
	function Save(){
		if($("#checkbox:checked").length==1){
			var str_loginname=$("#loginname").val();
			var str_password=$("#password").val();
			$.cookie("rmbUser","true",{expires:7});
			$.cookie("name",str_loginname,{expires:7});
			$.cookie("pwd",str_password,{expires:7});
		}else{
			$.cookie("rmbUser","false",{expires:-1});
			$.cookie("name","",{expires:-1});
			$.cookie("pwd","",{expires:-1});
		}
	}</script>
</head>
<body>
<div class="container-fluid">
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-4">
						</div>
						<div class="col-md-4">
							
						</div>
						<div class="col-md-4">
						</div>
					</div>
				</div>
		<div class="col-md-8">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-3">
				</div>
				<div class="col-md-3">
				
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			
			<form class="form-horizontal" role="form" action="login" method="post">
				<font color="red">${requestScope.message }</font>
				<div class="form-group">
					 
					<label for="inputEmail3" class="col-sm-2 control-label">
						用户名
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="loginname" name="loginname" placeholder="请输入您的用户名">
					</div>
				</div>
				<div class="form-group">
					 
					<label for="inputPassword3" class="col-sm-2 control-label">
						密码
					</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password" name="password" placeholder="请输入您的密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 
							<label>
								<input type="checkbox" name="remenber_password" id="checkbox"/> 
									记住我
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 
						<button type="submit" class="btn btn-default" onclick="Save()">
							登录
						</button>
						<button type="button" class="btn btn-default">
							<a href="resigter">注册</a>
						</button>
						<button type="button" class="btn btn-default">
							<a href="forget">忘记密码</a>
						</button>
						<button type="button" class="btn btn-default">
							<a href="background">管理员后台</a>
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		
		</div>
	</div>
</div>

    
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    
</body>
</html>