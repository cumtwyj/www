<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>注册页面</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
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
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<form role="form" action="addUser" method="post">
				<div class="form-group">
					 
					<label for="exampleInputEmail1">
						用户名
					</label>
					<input type="text" class="form-control" id="loginname" name="loginname" placeholder="请输入您的用户名（长度不超过15）">
				</div>
				<div class="form-group">
					 
					<label for="exampleInputEmail1">
						昵称
					</label>
					<input type="text" class="form-control" id="username" name="username" placeholder="请输入您的昵称（长度不超过15）">
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						密码
					</label>
					<input type="password" class="form-control" id="password" name="password" placeholder="请输入您的密码（长度不超过10）">
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						账号类型
					</label>
					<input type="text" class="form-control" id="identity" name="identity" placeholder="管理员或用户">
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						手机号码
					</label>
					<input type="text" class="form-control" id="phonenumber" name="phonenumber" placeholder="请输入您的手机号码">
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						地址
					</label>
					<input type="text" class="form-control" id="address" name="address" placeholder="请输入您的常住地址">
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						邮箱
					</label>
					<input type="text" class="form-control" id="email" name="email" placeholder="请输入您的邮箱">
				</div>
				<button type="submit" class="btn btn-default">
					提交
				</button>
				<button type="button" class="btn btn-default">
					<a href="loginForm">返回登录</a>
				</button>
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

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>