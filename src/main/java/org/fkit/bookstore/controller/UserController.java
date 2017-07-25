package org.fkit.bookstore.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.fkit.bookstore.domain.User;
import org.fkit.bookstore.service.BookstoreService;
import org.fkit.bookstore.util.common.BookstoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *处理用户请求控制器
 */
@Controller
public class UserController {
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	/**
	 * 处理登录请求
	 * @param String loginname 登录名
	 * @param String password 密码
	 * @return 跳转的视图
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			HttpSession session,
			ModelAndView mv){
		//调用业务逻辑组件判断用户是否可以登录
		User user = bookstoreService.login(loginname, password);
		if(user != null){
			//将用户保存到HttpSession当中
			session.setAttribute(BookstoreConstants.USER_SESSION, user);
			//客户端跳转到home页面
			mv.setViewName("forward:/home");
		}else{
			//设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误！请重新输入");
			//服务期内不跳转到登录页面
			mv.setViewName("forward:/loginForm");
		}
		return mv;
	}
	/**
	 * 处理forgetpwd请求		
	 * @param loginname
	 * @param phonenumbers
	 * @param email
	 * @param mv
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findpwd")
	public ModelAndView forget( @RequestParam("loginname")String loginname,
			@RequestParam("email")String email,
			HttpSession session,
			HttpServletResponse response,
			ModelAndView mv)throws Exception{
		//调用业务逻辑组件判断用户是否找回密码
		
		User user = bookstoreService.forget(loginname, email);
		
		if(user != null){
			StringBuffer url=new StringBuffer();
			StringBuilder builder=new StringBuilder();
			builder.append("");
			url.append("您的密码是："+user.getPassword()+"");
			builder.append("");
			builder.append(""+url+"");
			builder.append("");
			SimpleEmail sendemail=new SimpleEmail();
			sendemail.setHostName("smtp.163.com");
			sendemail.setAuthentication("m13758971462@163.com","gaoyaopan97");
			sendemail.setCharset("UTF-8");
			try{
				sendemail.setCharset("UTF-8");
				sendemail.addTo(email);
				sendemail.setFrom("m13758971462@163.com");
				sendemail.setSubject("找回密码");
				sendemail.setMsg(builder.toString());
				sendemail.send();
				System.out.println("发送成功");
			}catch(EmailException e){
				e.printStackTrace();
				System.out.print("抛出异常");
			}
			mv.setViewName("loginForm");
		}else{
			//设置找回失败失败提示信息
			response.getWriter().println("您填入的用户名或电话号码不正确，密码获取失败");
		}
		return mv;
	}
	/**
	 * 处理验证请求
	 * @param String loginname 登录名
	 * @param String password 密码
	 * @return 跳转的视图
	 */
	@RequestMapping(value="/confirm")
	public ModelAndView confirm(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			HttpSession session,
			ModelAndView mv){
		//调用业务逻辑组件判断用户是否可以修改
		User user = bookstoreService.confirm(loginname, password);
		if(user != null){
			//将用户保存到HttpSession当中
			session.setAttribute(BookstoreConstants.USER_SESSION, user);
			//客户端跳转到home页面
			mv.setViewName("forward:/newpassword");
		}else{
			//设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误！无法修改密码");
			//服务期内不跳转到登录页面
			mv.setViewName("forward:/change");
		}
		return mv;
	}
	/**
	 * 处理修改密码请求
	 * @param Integer userID 用户ID
	 * @return 跳转的视图
	 */
	@RequestMapping(value="/reset")
	public String changePwd(@RequestParam("userID")Integer userID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute User user){
		bookstoreService.changePwd(user);
		//跳转到loginForm页面
		return "loginForm";
	}
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param User user 要修改用户的对象
	 * @param ModelAndView mv 
	 */
	@RequestMapping(value="/addUser")
	public ModelAndView addUser(
			@ModelAttribute User user,
			ModelAndView mv){
			//执行添加操作
			bookstoreService.addUser(user);
			//设置客户端跳转到首页
			mv.setViewName("home");
		return mv;
	}
}
