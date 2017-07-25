package org.fkit.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fkit.bookstore.domain.Collect;
import org.fkit.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CollectController {
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	/**
	 * 添加收藏
	 */
	@RequestMapping(value="/addCollect")	
	public String save(@RequestParam("userID")Integer userID,
			@RequestParam("bookID")Integer bookID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Collect collect){
		 Collect collect1 = bookstoreService.findCollect(userID, bookID);
		 //System.out.println(bookID);
		if(collect1 != null){
			
		}else{
			bookstoreService.saveCollect(collect);
		}
		//获得所有图书集合
		List<Collect> collect_list = bookstoreService.getAllCollectByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		//跳转到success页面
		return "success";
	}
	/**
	 * 处理/cart请求
	 */
	@RequestMapping(value="/collect")
	public String collect(Integer userID,
			Model model){
		//获得所有图书集合
		List<Collect> collect_list = bookstoreService.getAllCollectByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		//跳转到collect页面
		return "collect";
	}
	/**
	 * 处理/clearcollect请求
	 */
	@RequestMapping(value="/clearcollect")
	public String clear(Integer userID,
			Model model){
		bookstoreService.clearCollect(userID);
		//获得所有图书集合
		List<Collect> collect_list = bookstoreService.getAllCollectByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		//跳转到collect页面
		return "collect";
	}
	/**
	 * 处理/removecollect请求
	 */
	@RequestMapping(value="/removecollect")
	public String remove(@RequestParam("userID")Integer userID,
			@RequestParam("bookID")Integer bookID,
			HttpServletRequest request,
			Model model,
			@ModelAttribute Collect collect){
		bookstoreService.removeCollect(userID, bookID);
		//获得所有图书集合
		List<Collect> collect_list = bookstoreService.getAllCollectByUserID(userID);
		//将图书集合添加到model当中
		model.addAttribute("collect_list", collect_list);
		//跳转到collect页面
		return "collect";
	}
}
