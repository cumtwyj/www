package org.fkit.bookstore.controller;

import java.util.List;

import org.fkit.bookstore.domain.Discuss;
import org.fkit.bookstore.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackgroundDiscussController {
	/**
	 * 自动注入BackgroundService
	 */
	@Autowired
	@Qualifier("backgroundService")
	private BackgroundService backgroundService;
	/**
	 * 处理/allDiscuss请求
	 */
	@RequestMapping(value="/allDiscuss")
	public String allorder(Model model){
		//获得所有订单集合
		List<Discuss> discuss_list = backgroundService.getAllDiscuss();
		//将订单集合添加到model当中
		model.addAttribute("discuss_list", discuss_list);
		//跳转到order_list页面
		return "order_discuss";
	}
}
