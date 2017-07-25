<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>评论页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="css/star.css" type="text/css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta name="description" content="Source code generated using layoutit.com" />
<meta name="author" content="LayoutIt!">
<meta name="keywords" content="" />
<meta name="owner" content="" />
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />

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
						 <a class="panel-title" data-toggle="collapse" data-parent="#panel-970909" href="#panel-element-272487">书海拾珠</a>
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
					<div class="container">



	<div class="row clearfix">
		<div class="col-md-3 column">
		</div>
		<div class="col-md-6 column">
<form action="enddiscuss" method="post" enctype="multipart/form-data">
<div class="form-group">
<font size="4"><strong>订单编号：</strong></font><font size="4" color="red">${order.orderID }</font>
</div>
<div class="form-group">
<label for="inputfile">星级评分</label>
	<div class="shop-rating">
		<span class="title">物流评分：</span>
			<ul class="rating-level" id="stars1">
				<li><a class="one-star" star:value="1" href="#">1</a></li>
				<li><a class="two-stars" star:value="2" href="#">2</a></li>
				<li><a class="three-stars" star:value="3" href="#">3</a></li>
				<li><a class="four-stars" star:value="4" href="#">4</a></li>
				<li><a class="five-stars" star:value="5" href="#">5</a></li>
			</ul>
		<span class="result" id="stars1-tips"></span>
		<input type="hidden" id="stars1-input" name="logistics" value="" size="2" />
	</div>

<!--
	# 星级评分
	# star:value = 分数
-->
<div class="shop-rating">
	<span class="title">质量评分：</span>
	<ul class="rating-level" id="stars2">
		<li><a class="one-star" star:value="1" href="#">1</a></li>
		<li><a class="two-stars" star:value="2" href="#">2</a></li>
		<li><a class="three-stars" star:value="3" href="#">3</a></li>
		<li><a class="four-stars" star:value="4" href="#">4</a></li>
		<li><a class="five-stars" star:value="5" href="#">5</a></li>
	</ul>
	<span class="result" id="stars2-tips"></span>
	<input type="hidden" id="stars2-input" name="quality" value="" size="2" />
</div>
<div class="shop-rating">
	<span class="title">服务评分：</span>
	<ul class="rating-level" id="stars3">
		<li><a class="one-star" star:value="1" href="#">1</a></li>
		<li><a class="two-stars" star:value="2" href="#">2</a></li>
		<li><a class="three-stars" star:value="3" href="#">3</a></li>
		<li><a class="four-stars" star:value="4" href="#">4</a></li>
		<li><a class="five-stars" star:value="5" href="#">5</a></li>
	</ul>
	<span class="result" id="stars3-tips"></span>
	<input type="hidden" id="stars3-input" name="serve" value="" size="2" />
</div>
<!-- END 星级评分 -->

</div>
<div class="form-group">
	<label for="inputfile">图片评论</label>
	<input type="file" id="inputfile" name="file">
</div>
	<div class="form-group">
		<label for="name">文字评论</label>
		<textarea class="form-control" rows="3" name="word"></textarea>
	 </div>
	 <input type="hidden" id="orderID" name="orderID" value="${order.orderID }">
	 <input type="hidden" id="status" name="status" value="${order.status }">
	<button type="submit" class="btn btn-default">提交</button>
</form>
		</div>
		<div class="col-md-3 column">
		</div>
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

<script type="text/javascript">
var Class = {
	create: function() {
		return function() { this.initialize.apply(this, arguments); }
	}
}
var Extend = function(destination, source) {
	for (var property in source) {
		destination[property] = source[property];
	}
}
function stopDefault( e ) {
	 if ( e && e.preventDefault ){
		e.preventDefault();
	}else{
		window.event.returnValue = false;
	}
	return false;
} 
/**
 * 星星打分组件
 *
 * @author	Yunsd
 * @date		2010-7-5
 */
var Stars = Class.create();
Stars.prototype = {
	initialize: function(star,options) {
		this.SetOptions(options); //默认属性
		var flag = 999; //定义全局指针
		var isIE = (document.all) ? true : false; //IE?
		var starlist = document.getElementById(star).getElementsByTagName('a'); //星星列表
		var input = document.getElementById(this.options.Input) || document.getElementById(star+"-input"); // 输出结果
		var tips = document.getElementById(this.options.Tips) || document.getElementById(star+"-tips"); // 打印提示
		var nowClass = " " + this.options.nowClass; // 定义选中星星样式名
		var tipsTxt = this.options.tipsTxt; // 定义提示文案
		var len = starlist.length; //星星数量
		

		for(i=0;i<len;i++){ // 绑定事件 点击 鼠标滑过
			starlist[i].value = i;
			starlist[i].onclick = function(e){
				stopDefault(e);
				this.className = this.className + nowClass;
				flag = this.value;
				input.value = this.getAttribute("star:value");
				tips.innerHTML = tipsTxt[this.value]
			}
			starlist[i].onmouseover = function(){
				if (flag< 999){
					var reg = RegExp(nowClass,"g");
					starlist[flag].className = starlist[flag].className.replace(reg,"")
				}
			}
			starlist[i].onmouseout = function(){
				if (flag< 999){
					starlist[flag].className = starlist[flag].className + nowClass;
				}
			}
		};
		if (isIE){ //FIX IE下样式错误
			var li = document.getElementById(star).getElementsByTagName('li');
			for (var i = 0, len = li.length; i < len; i++) {
				var c = li[i];
				if (c) {
					c.className = c.getElementsByTagName('a')[0].className;
				}
			}
		}
	},
	//设置默认属性
	SetOptions: function(options) {
		this.options = {//默认值
			Input:			"",//设置触保存分数的INPUT
			Tips:			"",//设置提示文案容器
			nowClass:	"current-rating",//选中的样式名
			tipsTxt:		["1分-严重不合格","2分-不合格","3分-合格","4分-优秀","5分-完美"]//提示文案
		};
		Extend(this.options, options || {});
	}
}

var Stars1 = new Stars("stars1")
var Stars2 = new Stars("stars2")
var Stars3 = new Stars("stars3")
</script>
</body>
</html>