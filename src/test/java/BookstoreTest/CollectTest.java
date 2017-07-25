package BookstoreTest;

import java.util.List;

import org.fkit.bookstore.domain.Collect;
import org.fkit.bookstore.service.BookstoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CollectTest extends BaseJunit{
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	
	//测试saveCollect
	@Test
	public void saveCollectTest(){
		Collect collect=new Collect();
		collect.setUserID(2);
		collect.setLoginname("HH");
		collect.setBookID(3);
		collect.setBookname("见字如面");
		collect.setAuthor("关正文");
		collect.setPublish("江苏凤凰文艺出版社");
		collect.setPrice(39.8);
		collect.setPicture_s("见字如面s.jpg");
		bookstoreService.saveCollect(collect);
		System.out.println("已添加收藏信息");
	}
	
	//测试getAllCollectByUserID
	@Test
	public void getAllCollectByUserIDTest(){
		Integer userID=1;
		List<Collect> collectList = bookstoreService.getAllCollectByUserID(userID);
		System.out.println("根据userID显示收藏内容");
		System.out.println(collectList);
	}
	
	//测试findCollect
	@Test
	public void findCollectTest(){
		Integer userID=1;
		Integer bookID=8;
		Collect collectFindCollect=bookstoreService.findCollect(userID, bookID);
		System.out.println(collectFindCollect);
	}
}
