package BookstoreTest;

import org.fkit.bookstore.domain.User;
import org.fkit.bookstore.service.BookstoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserTest extends BaseJunit{
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	
	//测试login
	@Test
	public void LoginTest(){
		String loginname="wyj";
		String password="654321";
		User userLogin=bookstoreService.login(loginname, password);
		System.out.println(userLogin);
	}
	
	//测试forget
	@Test
	public void ForgetTest(){
		String loginname="Grstar";
		String email="805477344@qq.com";
		User userForget=bookstoreService.forget(loginname, email);
		System.out.println(userForget);
	}
	
	//测试confirm
	@Test
	public void ConfirmTest(){
		String loginname="wyj";
		String password="654321";
		User userConfirm=bookstoreService.confirm(loginname, password);
		System.out.println(userConfirm);
	}
	
	//测试changePwd
	
	//测试findUserByUserID
	@Test
	public void findUserByUserIDTest(){
		Integer userID=1;
		User userFindUserByUserID=bookstoreService.findUserByUserID(userID);
		System.out.println(userFindUserByUserID);
	}
	
	//测试removeUserByUserID
	
	//测试addUser
	@Test
	public void AddUserTest(){
		User user=new User();
		user.setUsername("lalala");
		user.setLoginname("lalala");
		user.setPassword("0123");
		user.setIdentity("用户");
		user.setEmail("123456789@163.com");
		user.setAddress("China");
		user.setPhonenumber("18888888888");
		bookstoreService.addUser(user);
		System.out.println("已添加用户信息");
	}
}
