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

    <title>我的订单</title>

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
								我的订单
							</h3>
						
							
							<table class="table">
								<thead>
									<tr>
										<th>
											订单编号
										</th>
										<th>
											收货人
										</th>
										<th>
											发起日期
										</th>
										<th>
											电话
										</th>
										<th>
											地址
										</th>
										<th>
											邮箱
										</th>
										<th>
											金额
										</th>
										<th>
											订单状态
										</th>
										<th>
											操作
										</th>
									</tr>
								</thead>
								<c:forEach items="${requestScope.order_list }" var="order">
								<tbody>
								<form action="removeorder" method="post">
									<tr>
										<td>
											${order.orderID }
										</td>
										<td>
											${order.username }
										</td>
										<td>
											${order.date }
										</td>
										<td>
											${order.phonenumber }
										</td>
										<td>
											${order.address }
										</td>
										<td>
											${order.email }
										</td>
										<td>
											${order.pay }
										</td>
										<td>
											${order.status }
										</td>
										<td>
											<input type="hidden" name="orderID" id="orderID" value="${order.orderID }"   >
											<input type="hidden" name="status" id="status" value="${order.status }"   >
											<button type="submit" >删除</button>
											
											<button type="button" ><a href="payoff?orderID=${order.orderID }&status=${order.status }">付款</a></button>
											<button type="button" ><a href="received?orderID=${order.orderID }&status=${order.status }">收货</a></button>
											<button type="button" ><a href="startdiscuss?orderID=${order.orderID }&status=${order.status }">评论</a></button>
										</td>
									</tr>
								</form>
								</tbody>
								</c:forEach>
							</table>
							
						</div>
						<div class="col-md-2">
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