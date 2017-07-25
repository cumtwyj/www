package org.fkit.bookstore.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.fkit.bookstore.domain.Discuss;
import org.fkit.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DiscussController {
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	
	/**
	 * 添加评论
	 */
	//上传文件会自动绑定到MultipartFile中
	@RequestMapping(value="/enddiscuss",method=RequestMethod.POST)
	public String endDiscuss(HttpServletRequest request,
			@ModelAttribute Discuss discuss,
			@RequestParam("orderID") Integer orderID, 
			@RequestParam("status")String status,
			@RequestParam("file") MultipartFile file)throws Exception{
		if(status.equals("待评论")){
			bookstoreService.achieve(orderID);
			//如果文件不为空，写入上传路径
			if(!file.isEmpty()){
				//上传文件路径
				String path = request.getServletContext().getRealPath("/images/");
				//上传文件名
				String filename = file.getOriginalFilename();
				discuss.setPhoto(filename);
				File filepath = new File(path,filename);
				//判断路径是否存在，如果不存在就创建一个
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			//将上传的文件保存到一个目标文件当中
				file.transferTo(new File("C:\\Users\\GRSTAR\\Documents\\Java大作业\\BookShop\\src\\main\\webapp\\images\\"+ filename));
				bookstoreService.addDiscuss(discuss);
				return "success";
			}else{
				return "failure";
			}
		}else{
			return "failure";
		}
	}
}
