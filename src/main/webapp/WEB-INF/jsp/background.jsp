<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />

<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js"></script>
<script src="js/Particleground.js"></script>

</head>
<body>
<dl class="admin_login">
 <dt>
  <strong>后台管理系统</strong>
 </dt>
 <form class="form-horizontal" role="form" action="loginbackground" method="post">
 <font color="red">${requestScope.message }</font>
 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" id="loginname" name="loginname"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" id="password" name="password"/>
 </dd>
 <dd>
  <input type="submit" value="立即登录" class="submit_btn"/>
 </dd>
 <dd>
  <a href="home">返回购物页面</a>
 </dd>
 </form>
</dl>
</body>
</html>
>