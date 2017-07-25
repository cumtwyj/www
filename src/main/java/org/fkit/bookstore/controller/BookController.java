package org.fkit.bookstore.controller;

import java.util.List;

import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookController {
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	/**
	 * 处理/novel请求
	 */
	@RequestMapping(value="/novel")
	public String novel(Model model){
		//获得所有图书集合
		List<Book> book_list = bookstoreService.getAllOneBook();
		//将图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到novel页面
		return "novel";
	}
	/**
	 * 处理/literature请求
	 */
	@RequestMapping(value="/literature")
	public String literature(Model model){
		//获得文学图书集合
		List<Book> book_list = bookstoreService.getAllTwoBook();
		//将文学图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到literature页面
		return "literature";
	}
	/**
	 * 处理/history请求
	 */
	@RequestMapping(value="/history")
	public String history(Model model){
		//获得历史图书集合
		List<Book> book_list = bookstoreService.getAllThreeBook();
		//将历史图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到history页面
		return "history";
	}
	/**
	 * 处理/science请求
	 */
	@RequestMapping(value="/science")
	public String science(Model model){
		//获得科技图书集合
		List<Book> book_list = bookstoreService.getAllFourBook();
		//将科技图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到science页面
		return "science";
	}
	/**
	 * 处理/detail/{bookID}
	 */
	@RequestMapping(value="/book_detail")
	public ModelAndView detail(@RequestParam("bookID") Integer bookID, Model model,ModelAndView mv){
		Book book = bookstoreService.getBookDetail(bookID);
		mv.addObject("book",book);
		mv.setViewName("forward:/detail");
		return mv;
		
	}
}
