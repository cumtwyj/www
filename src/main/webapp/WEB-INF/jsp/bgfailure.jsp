<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/bgstyle.css">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
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
<!--header-->
<header>
 <h1><img src="images/Logol2.jpg"/></h1>
 <ul class="rt_nav">
  <li><a href="home" target="_blank" class="website_icon">首页</a></li>
  <li><a href="#" class="admin_icon">${sessionScope.user_session.username }</a></li>
  <li><a href="background" class="quit_icon">安全退出</a></li>
 </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>书籍管理</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="allBook" class="active">书籍列表</a></dd>
    <dd><a href="product_detail">书籍添加</a></dd>
    <dd><a href="product_change">书籍修改</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单管理</dt>
    <dd><a href="allOrder">订单列表</a></dd>
    <dd><a href="order_detail">订单详情</a></dd>
    <dd><a href="allDiscuss">订单评论</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>用户管理</dt>
    <dd><a href="allUser">用户列表</a></dd>
    <dd><a href="user_detail">权限修改</a></dd>
    <dd><a href="user_rank">权限说明</a></dd>
   </dl>
  </li>
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar"> 
 <div class="rt_content">
    操作失败
</div>
</section>
</body>
</html>