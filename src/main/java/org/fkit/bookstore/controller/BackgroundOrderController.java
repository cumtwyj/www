package org.fkit.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.fkit.bookstore.domain.Order;
import org.fkit.bookstore.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackgroundOrderController {
	/**
	 * 自动注入BackgroundService
	 */
	@Autowired
	@Qualifier("backgroundService")
	private BackgroundService backgroundService;
	/**
	 * 处理/allOrder请求
	 */
	@RequestMapping(value="/allOrder")
	public String allorder(Model model){
		//获得所有订单集合
		List<Order> order_list = backgroundService.getAllOrder();
		//将订单集合添加到model当中
		model.addAttribute("order_list", order_list);
		//跳转到order_list页面
		return "order_list";
	}
	/**
	 * 处理/dfkOrder请求
	 */
	@RequestMapping(value="/dfkOrder")
	public String dfkorder(Model model){
		//获得所有待付款订单集合
		List<Order> order_list = backgroundService.getAllOrderDFK();
		//将待付款订单集合添加到model当中
		model.addAttribute("order_list", order_list);
		//跳转到order_list页面
		return "order_list";
	}
	/**
	 * 处理/dfhOrder请求
	 */
	@RequestMapping(value="/dfhOrder")
	public String dfhorder(Model model){
		//获得待发货所有订单集合
		List<Order> order_list = backgroundService.getAllOrderDFH();
		//将待发货订单集合添加到model当中
		model.addAttribute("order_list", order_list);
		//跳转到order_list页面
		return "order_list";
	}
	/**
	 * 处理/dshOrder请求
	 */
	@RequestMapping(value="/dshOrder")
	public String dshorder(Model model){
		//获得待收货所有订单集合
		List<Order> order_list = backgroundService.getAllOrderDSH();
		//将待收货订单集合添加到model当中
		model.addAttribute("order_list", order_list);
		//跳转到order_list页面
		return "order_list";
	}
	/**
	 * 处理/dplOrder请求
	 */
	@RequestMapping(value="/dplOrder")
	public String dplorder(Model model){
		//获得所有待评论订单集合
		List<Order> order_list = backgroundService.getAllOrderDPL();
		//将待评论订单集合添加到model当中
		model.addAttribute("order_list", order_list);
		//跳转到order_list页面
		return "order_list";
	}
	/**
	 * 处理/ddwcOrder请求
	 */
	@RequestMapping(value="/ddwcOrder")
	public String ddwcorder(Model model){
		//获得所有完成订单集合
		List<Order> order_list = backgroundService.getAllOrderDDWC();
		//将完成订单集合添加到model当中
		model.addAttribute("order_list", order_list);
		//跳转到order_list页面
		return "order_list";
	}
	/**
	 * 处理/checkOrder
	 */
	@RequestMapping(value="/checkOrder")
	public ModelAndView detail(@RequestParam("orderID") Integer orderID, Model model,ModelAndView mv){
		Order order = backgroundService.getOrderDetail(orderID);
		mv.addObject("order",order);
		mv.setViewName("forward:/order_detail");
		return mv;
	}
	/**
	 * 处理/delivery请求
	 */
	@RequestMapping(value="/delivery")
	public String add(@RequestParam("orderID")Integer orderID,
			@RequestParam("status")String status,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Order order){
		if(status.equals("待发货")){
			backgroundService.delivery(orderID);
			return "bgsuccess";
		}else{
			return "bgfailure";
		}
	}
	/**
	 * 处理notice请求		
	 * @param loginname
	 * @param phonenumbers
	 * @param email
	 * @param mv
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/notice")
	public ModelAndView notice( @RequestParam("orderID")Integer orderID,
			@RequestParam("email")String email,
			HttpSession session,
			HttpServletResponse response,
			ModelAndView mv)throws Exception{
		//调用业务逻辑组件判断用户是否找回密码
		Order order = backgroundService.notice(orderID, email);
		
		if(order != null){
			StringBuffer url=new StringBuffer();
			StringBuilder builder=new StringBuilder();
			builder.append("");
			url.append("您的订单"+order.getStatus()+"，请注意查收！");
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
				sendemail.setSubject("订单发货通知");
				sendemail.setMsg(builder.toString());
				sendemail.send();
				System.out.println("发送成功");
			}catch(EmailException e){
				e.printStackTrace();
				System.out.print("抛出异常");
			}
			mv.setViewName("bgsuccess");
		}else{
			//设置找回失败失败提示信息
			response.getWriter().println("请重新发送通知");
		}
		return mv;
	}
	
}
