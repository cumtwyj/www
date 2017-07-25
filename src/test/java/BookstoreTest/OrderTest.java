package BookstoreTest;

import java.util.List;

import org.fkit.bookstore.domain.Order;
import org.fkit.bookstore.service.BookstoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrderTest extends BaseJunit{
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	
	//测试addOrder
	@Test
	public void addOrderTest(){
		Order order=new Order();
		order.setUserID(6);
		order.setUsername("WWW");
		order.setDate("2017-07-24 13:19:26");
		order.setPhonenumber("13750000000");
		order.setAddress("内蒙古");
		order.setEmail("7299334824@qq.com");
		bookstoreService.addOrder(order);
		System.out.println("已添加订单信息");
	}
	
	//测试getAllOrder
	@Test
	public void getAllOrderTest(){
		List<Order> orderList = bookstoreService.getAllOrder();
		System.out.println("显示所有订单");
		System.out.println(orderList);
	}
	
	//测试getAllOrderByUserID
	@Test
	public void getAllOrderByUserIDTest(){
		Integer userID=1;
		List<Order> orderList = bookstoreService.getAllOrderByUserID(userID);
		System.out.println("根据userID显示订单");
		System.out.println(orderList);
	}
	
}
