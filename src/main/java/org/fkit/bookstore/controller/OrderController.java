package org.fkit.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.fkit.bookstore.domain.Order;
import org.fkit.bookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	/**
	 * 自动注入BackgroundService
	 */
	@Autowired
	@Qualifier("backgroundService")
	private BackgroundService backgroundService;
	/**
	 * 添加订单
	 */
	@RequestMapping(value="/addOrder")
	public ModelAndView addOrder(
			@ModelAttribute Order order,
			ModelAndView mv){
			bookstoreService.addOrder(order);
			//设置客户端跳转到首页
			mv.setViewName("success");
			//返回
			return mv;
	}
	/**
	 * 处理/order请求
	 */
	@RequestMapping(value="/order")
	public String cart(Integer userID,
			Model model){
		//获得所有图书集合
		List<Order> order_list = bookstoreService.getAllOrderByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("order_list", order_list);
		//跳转到order页面
		return "order";
	}
	/**
	 * 处理/removeOrder请求
	 */
	@RequestMapping(value="/removeorder")
	public String removeorder(Integer orderID,
			String status,
			Model model){
		if(status.equals("待付款")){
			bookstoreService.removeOrder(orderID);
			return "success";
		}else{
			return "failure";
		}
	}
	/**
	 * 处理/payoff请求
	 */
	@RequestMapping(value="/payoff")
	public String payoff(@RequestParam("orderID")Integer orderID,
			@RequestParam("status")String status,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Order order){
		if(status.equals("待付款")){
			bookstoreService.payoff(orderID);
			return "success";
		}else{
			return "failure";
		}
	}
	/**
	 * 处理/received请求
	 */
	@RequestMapping(value="/received")
	public String add(@RequestParam("orderID")Integer orderID,
			@RequestParam("status")String status,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Order order){
		if(status.equals("待收货")){
			bookstoreService.received(orderID);
			return "success";
		}else{
			return "failure";
		}
	}
	/**
	 * 处理/startdiscuss
	 */
	@RequestMapping(value="/startdiscuss")
	public ModelAndView startdiscuss(@RequestParam("orderID") Integer orderID, 
			@RequestParam("status")String status,
			Model model,
			ModelAndView mv){
		if(status.equals("待评论")){
			Order order = backgroundService.getOrderDetail(orderID);
			mv.addObject("order",order);
			mv.setViewName("forward:/discuss");
			return mv;
		}else{
			mv.setViewName("forward:/failure");
			return mv;
		}
		
	}
}
