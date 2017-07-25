package org.fkit.bookstore.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.service.BackgroundService;
import org.fkit.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackgroundBookController {
	/**
	 * 自动注入BackgroundService
	 */
	@Autowired
	@Qualifier("backgroundService")
	private BackgroundService backgroundService;
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	/**
	 * 处理/allbook请求
	 */
	@RequestMapping(value="/allBook")
	public String allbook(Model model){
		//获得所有图书集合
		List<Book> book_list = backgroundService.getAllBook();
		//将图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到product_list页面
		return "product_list";
	}
	/**
	 * 处理/novelBook请求
	 */
	@RequestMapping(value="/novelBook")
	public String novelbook(Model model){
		//获得所有图书集合
		List<Book> book_list = bookstoreService.getAllOneBook();
		//将小说集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到product_list页面
		return "product_list";
	}	
	/**
	* 处理/literatureBook请求
	*/
	@RequestMapping(value="/literatureBook")
	public String literaturebook(Model model){
		//获得所有图书集合
		List<Book> book_list = bookstoreService.getAllTwoBook();
		//将文学图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到product_list页面
		return "product_list";
	}
	/**
	* 处理/historyBook请求
	*/
	@RequestMapping(value="/historyBook")
	public String historybook(Model model){
		//获得所有图书集合
		List<Book> book_list = bookstoreService.getAllThreeBook();
		//将历史图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到product_list页面
		return "product_list";
	}
	/**
	* 处理/scienceBook请求
	*/
	@RequestMapping(value="/scienceBook")
	public String sciencebook(Model model){
		//获得所有图书集合
		List<Book> book_list = bookstoreService.getAllFourBook();
		//将科普图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到product_list页面
		return "product_list";
	}
	/**
	 * 处理/removebook请求
	 */
	@RequestMapping(value="/removebook")
	public String removebook(Integer bookID,
			Model model){
		backgroundService.removeBook(bookID);
		//获得所有图书集合
		List<Book> book_list = backgroundService.getAllBook();
		//将图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到product_list页面
		return "product_list";
	}
	/**
	 * 处理/bookchange
	 */
	@RequestMapping(value="/bookchange")
	public ModelAndView detail(@RequestParam("bookID") Integer bookID, Model model,ModelAndView mv){
		Book book = bookstoreService.getBookDetail(bookID);
		mv.addObject("book",book);
		mv.setViewName("forward:/product_change");
		return mv;
	}
	
	/**
	 * 处理/changeBook请求
	 */
	@RequestMapping(value="/changeBook")
	public String changebook(@RequestParam("bookID")Integer bookID,
			@RequestParam("bookname")String bookname,
			@RequestParam("author")String author,
			@RequestParam("publish")String publish,
			@RequestParam("sortID")Integer sortID,
			@RequestParam("price")Double price,
			@RequestParam("stock")Integer stock,
			Model model){
		backgroundService.changeBook(bookID, bookname, author, publish, sortID, price,stock);
		//获得所有图书集合
		List<Book> book_list = backgroundService.getAllBook();
		//将图书集合添加到model当中
		model.addAttribute("book_list", book_list);
		//跳转到bgsuccess页面
		return "bgsuccess";
	}
	
	/**
	 * 添加书籍
	 */
	//上传文件会自动绑定到MultipartFile中
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public String saveBook(HttpServletRequest request,
			@ModelAttribute Book book,Model model,
			@RequestParam(value="file",required=false) MultipartFile[] file)throws Exception{
		int count=-1;
		String fn[]=new String[2];
		for(MultipartFile mf:file){
			count=count+1;
		//如果文件不为空，写入上传路径
			if(!mf.isEmpty()){
				//上传文件路径
				String path = request.getServletContext().getRealPath("/images/");
				//上传文件名
				String filename = mf.getOriginalFilename();
				fn[count]=filename;
				File filepath = new File(path,filename);
				//判断路径是否存在，如果不存在就创建一个
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			//将上传的文件保存到一个目标文件当中
				mf.transferTo(new File("C:\\Users\\GRSTAR\\Documents\\Java大作业\\BookShop\\src\\main\\webapp\\images\\"+ filename));
			}
		}
			book.setPicture_s(fn[0]);
			book.setPicture_l(fn[1]);
			backgroundService.addBook(book);
			return "bgsuccess";
	}
}
