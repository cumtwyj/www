package BookstoreTest;

import java.util.List;

import org.fkit.bookstore.domain.Detail;
import org.fkit.bookstore.service.BookstoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DetailTest extends BaseJunit{
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	
	//测试saveCart
	@Test
	public void saveCartTest(){
		Detail detail=new Detail();
		detail.setUserID(1);
		detail.setLoginname("wyj");
		detail.setBookID(8);
		detail.setBookname("SPSS分析");
		detail.setAuthor("武松");
		detail.setPrice(20.9);
		detail.setCount(5);
		bookstoreService.saveCart(detail);
		System.out.println("已添加购物车信息");
	}
	
	//测试getAllDetailByUserID
	@Test
	public void getAllDetailByUserIDTest(){
		Integer userID=1;
		List<Detail> detailList = bookstoreService.getAllDetailByUserID(userID);
		System.out.println("根据userID显示购物车内容");
		System.out.println(detailList);
	}
	
	//测试removeCart
	@Test
	public void removeCartTest(){
		Integer userID=1;
		Integer bookID=2;
		bookstoreService.removeCart(userID, bookID);
		System.out.println("根据userIDbookID删除购物车记录");
	}
	
}
