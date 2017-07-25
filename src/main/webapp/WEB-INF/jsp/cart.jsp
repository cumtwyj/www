<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="now" class="java.util.Date" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>购物车</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-4">
						</div>
						<div class="col-md-4">
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-8">
							<ul class="nav nav-pills">
								<li class="active">
									<a href="home">首页</a>
								</li>
								<li>
									<a href="novel">小说</a>
								</li>
								<li >
									<a href="literature">文学</a>
								</li>
								<li >
									<a href="history">历史</a>
								</li>
								<li >
									<a href="science">科技</a>
								</li>
								<li class="dropdown pull-right">
									 <a href="#" data-toggle="dropdown" class="dropdown-toggle">其他<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="background">管理员后台</a>
										</li>
										<li>
											<a href="resigter">注册</a>
										</li>
										<li>
											<a href="loginForm">用户切换</a>
										</li>
										
									</ul>
								</li>
								<li class="dropdown pull-right">
									 <a href="#" data-toggle="dropdown" class="dropdown-toggle">我的<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li >
											<a href="cart?userID= ${sessionScope.user_session.userID }">购物车</a>
										</li>
										<li >
											<a href="collect?userID= ${sessionScope.user_session.userID }">我的收藏</a>
										</li>
										<li >
											<a href="order?userID= ${sessionScope.user_session.userID }">我的订单</a>
										</li>
										<li>
											<a href="change">修改密码</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
						<div class="col-md-4">
							 
							<address>
								<strong>${sessionScope.user_session.identity } ${sessionScope.user_session.username }</strong><br> 欢迎您的光临！<br> 当前在线人数是：<c:out value="${applicationScope.number }"></c:out>
							</address>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="panel-group" id="panel-970909">
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title" data-toggle="collapse" data-parent="#panel-970909" href="#panel-element-272487">分类</a>
					</div>
					<div id="panel-element-272487" class="panel-collapse collapse in">
						<div class="panel-body">
							<a href="home">首页</a><br>
							<a href="novel">小说</a><br>
							<a href="literature">文学</a><br>
							<a href="history">历史</a><br>
							<a href="science">科技</a>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						 <a class="panel-title" data-toggle="collapse" data-parent="#panel-970909" href="#panel-element-389560">我的</a>
					</div>
					<div id="panel-element-389560" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="cart?userID= ${sessionScope.user_session.userID }">购物车</a><br>
							<a href="collect?userID= ${sessionScope.user_session.userID }">我的收藏</a><br>
							<a href="order?userID= ${sessionScope.user_session.userID }">我的订单</a><br>
							<a href="change">修改密码</a>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<a class="panel-title"  data-toggle="collapse" data-parent="#panel-970909" href="#panel-element-189130">其他</a>
					</div>
				<div id="panel-element-189130" class="panel-collapse collapse in">
					<div class="panel-body">
						<a href="resigter">注册</a><br>
						<a href="background">管理员后台</a><br>
						<a href="loginForm">用户切换</a><br>
					</div>
				</div>
</div>
			</div>
		</div>
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
					
						<div class="col-md-2">
						</div>
						<div class="col-md-8">
							<h3>
								购物车
							</h3>
							
							<table class="table">
								<thead>
									<tr>
										<th>
											序号
										</th>
										<th>
											书号
										</th>
										<th>
											书籍名称
										</th>
										<th>
											作者
										</th>
										<th>
											价格
										</th>
										<th>
											数量
										</th>
										<th>
											操作
										</th>
									</tr>
								</thead>
								<c:forEach items="${requestScope.detail_list }" var="detail">
								<form action="remove" method="post">
								<tbody>
									<tr>
										<td>
											${detail.ID }
										</td>
										<td>
											${detail.bookID }
										</td>
										<td>
											${detail.bookname }
										</td>
										<td>
											${detail.author }
										</td>
										<td>
											${detail.price }
										</td>
										<td>
											${detail.count }
											<c:set value="${detail.price*detail.count+sum}" var="sum"></c:set>
										</td>
										<td>
											<button type="submit" >删除</button>
											<input type="hidden" name="userID" id="userID" value="${sessionScope.user_session.userID }"   >
											<input type="hidden" name="bookID" id="bookID" value="${detail.bookID }"   >
											<button type="button" ><a href="add?userID= ${sessionScope.user_session.userID }&bookID=${detail.bookID }">+</a></button>
											<button type="button" ><a href="reduce?userID= ${sessionScope.user_session.userID}&bookID= ${detail.bookID }">—</a></button>
										</td>
									</tr>
								</tbody>
								</form>
								</c:forEach>
								<tfoot>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td>
											<font size="4">总计：</font>
										</td>
										<td>
											<font size="5" color="red"><strong>${sum }</strong></font>
										</td>
									</tr>
								</tfoot>
							</table>
							
						</div>
						<div class="col-md-2">
						</div>
					
					</div>
					<div class="row">
						<div class="col-md-9">
						</div>
						<div class="col-md-3">
							<form  action="addOrder" method="post">
				 				<input type="hidden" name="userID" id="userID" value="${sessionScope.user_session.userID }"   >
								<input type="hidden" name="username" id="username" value="${sessionScope.user_session.username }"   >
								<input type="hidden" name="date" id="date" value="2017-${sessionScope.now.month+1}-${sessionScope.now.date}"   >
								<input type="hidden" name="phonenumber" id="phonenumber" value="${sessionScope.user_session.phonenumber }"   >
								<input type="hidden" name="address" id="address" value="${sessionScope.user_session.address }"   >
								<input type="hidden" name="email" id="email" value="${sessionScope.user_session.email }"   >
								<input type="hidden" name="pay" id="pay" value="${sum }"   >
								<input type="hidden" name="status" id="status" value="待付款"   >
								<input type="submit" class="btn btn-danger btn-lg  active" value="确认清算" />
							</form> 
							<button type="button" class="btn btn-danger btn-lg active">
								<a href="">确认购买</a>
							</button><br>
							<button type="button" class="btn  btn-lg active">
								<a href="clear?userID= ${sessionScope.user_session.userID }">清空购物车</a>
							</button>
						</div>
					</div>
				</div>
			</div>
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