package org.fkit.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fkit.bookstore.domain.Detail;
import org.fkit.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailController {
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	/**
	 * 添加订单细节,添加到购物车
	 */
	@RequestMapping(value="/addDetail")	
	public String save(@RequestParam("userID")Integer userID,
			@RequestParam("bookID")Integer bookID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Detail detail){
		 Detail detail1 = bookstoreService.findCart(userID, bookID);
		 //System.out.println(bookID);
		if(detail1 != null){
			bookstoreService.addCount(detail);
		}else{
			bookstoreService.saveCart(detail);
		}
		//获得所有图书集合
		List<Detail> detail_list = bookstoreService.getAllDetailByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("detail_list", detail_list);
		//跳转到success页面
		return "success";
	}
	/**
	 * 处理/cart请求
	 */
	@RequestMapping(value="/cart")
	public String cart(Integer userID,
			Model model){
		//获得所有图书集合
		List<Detail> detail_list = bookstoreService.getAllDetailByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("detail_list", detail_list);
		//跳转到cart页面
		return "cart";
	}
	/**
	 * 处理/clear请求
	 */
	@RequestMapping(value="/clear")
	public String clear(Integer userID,
			Model model){
		bookstoreService.clearCart(userID);
		//获得所有图书集合
		List<Detail> detail_list = bookstoreService.getAllDetailByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("detail_list", detail_list);
		//跳转到cart页面
		return "cart";
	}
	/**
	 * 处理/remove请求
	 */
	@RequestMapping(value="/remove")
	public String remove(@RequestParam("userID")Integer userID,
			@RequestParam("bookID")Integer bookID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Detail detail){
		bookstoreService.removeCart(userID,bookID);
		//获得所有图书集合
		List<Detail> detail_list = bookstoreService.getAllDetailByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("detail_list", detail_list);
		//跳转到cart页面
		return "cart";
	}
	/**
	 * 处理/reduce请求
	 */
	@RequestMapping(value="/reduce")
	public String reduce(@RequestParam("userID")Integer userID,
			@RequestParam("bookID")Integer bookID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Detail detail){
		bookstoreService.reduceCount(detail);
		//获得所有图书集合
		List<Detail> detail_list = bookstoreService.getAllDetailByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("detail_list", detail_list);
		//跳转到cart页面
		return "cart";
	}
	/**
	 * 处理/add请求
	 */
	@RequestMapping(value="/add")
	public String add(@RequestParam("userID")Integer userID,
			@RequestParam("bookID")Integer bookID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Detail detail){
		bookstoreService.addCount(detail);
		//获得所有图书集合
		List<Detail> detail_list = bookstoreService.getAllDetailByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("detail_list", detail_list);
		//跳转到cart页面
		return "cart";
	}
}
