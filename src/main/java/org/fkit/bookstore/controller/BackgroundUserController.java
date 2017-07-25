package org.fkit.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.fkit.bookstore.domain.User;
import org.fkit.bookstore.service.BackgroundService;
import org.fkit.bookstore.util.common.BookstoreConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackgroundUserController {
	/**
	 * 自动注入BackgroundService
	 */
	@Autowired
	@Qualifier("backgroundService")
	private BackgroundService backgroundService;
	/**
	 * 处理登录请求
	 * @param String loginname 登录名
	 * @param String password 密码
	 * @return 跳转的视图
	 */
	@RequestMapping(value="/loginbackground")
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			HttpSession session,
			ModelAndView mv){
		//调用业务逻辑组件判断用户是否可以登录
		User user = backgroundService.loginbackground(loginname, password);
		if(user != null){
			//将用户保存到HttpSession当中
			session.setAttribute(BookstoreConstants.USER_SESSION, user);
			//客户端跳转到index页面
			mv.setViewName("forward:/index");
		}else{
			//设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误或您不为管理员！请重新输入");
			//服务期内不跳转，到后台登录页面
			mv.setViewName("forward:/background");
		}
		return mv;
	}
	/**
	 * 处理/allUser请求
	 */
	@RequestMapping(value="/allUser")
	public String alluser(Model model){
		//获得所有用户集合
		List<User> user_list = backgroundService.getAllUser();
		//将所有用户集合添加到model当中
		model.addAttribute("user_list", user_list);
		//跳转到user_list页面
		return "user_list";
	}
	/**
	 * 处理/allAdmin请求
	 */
	@RequestMapping(value="/allAdmin")
	public String alladmin(Model model){
		//获得管理员用户集合
		List<User> user_list = backgroundService.getAllAdmin();
		//将管理员集合添加到model当中
		model.addAttribute("user_list", user_list);
		//跳转到user_list页面
		return "user_list";
	}
	/**
	 * 处理/allOrdinary请求
	 */
	@RequestMapping(value="/allOrdinary")
	public String allordinary(Model model){
		//获得用户集合
		List<User> user_list = backgroundService.getAllOrdinary();
		//将用户集合添加到model当中
		model.addAttribute("user_list", user_list);
		//跳转到user_list页面
		return "user_list";
	}
	/**
	 * 处理/UserRankChange
	 */
	@RequestMapping(value="/UserRankChange")
	public ModelAndView userRankchange(@RequestParam("userID") Integer userID, Model model,ModelAndView mv){
		User user = backgroundService.getUserDetail(userID);
		mv.addObject("user",user);
		mv.setViewName("forward:/user_detail");
		return mv;
		
	}
	/**
	 * 处理修改权限请求
	 * @param Integer userID 用户ID
	 * @return 跳转的视图
	 */
	@RequestMapping(value="/changeidentity")
	public String changeidentity(@RequestParam("userID")Integer userID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute User user){
		backgroundService.changeIdentity(user);
		//跳转到bgsuccess页面
		return "bgsuccess";
	}
}
