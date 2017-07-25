package BackgroundTest;

import java.util.List;

import org.fkit.bookstore.domain.Order;
import org.fkit.bookstore.domain.User;
import org.fkit.bookstore.service.BackgroundService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import BookstoreTest.BaseJunit;

public class UserTest extends BaseJunit{
	/**
	 * 自动注入BackgroundService
	 */
	@Autowired
	@Qualifier("backgroundService")
	private BackgroundService backgroundService;
	
	//测试loginbackground
	@Test
	public void loginbackgroundTest(){
		String loginname="wyj";
		String password="654321";
		User userLoginbackground=backgroundService.loginbackground(loginname, password);
		System.out.println(userLoginbackground);
	}
	
	//测试getAllUser
	@Test
	public void getAllUserTest(){
		List<User> userList = backgroundService.getAllUser();
		System.out.println("显示所有用户");
		System.out.println(userList);
	}
	//测试getAllAdmin
	@Test
	public void getAllAdminTest(){
		List<User> userList = backgroundService.getAllAdmin();
		System.out.println("显示所有管理员");
		System.out.println(userList);
	}

	//测试getAllOrdinary
	@Test
	public void getAllOrdinaryTest(){
		List<User> userList = backgroundService.getAllOrdinary();
		System.out.println("显示用户");
		System.out.println(userList);
	}
	
	//测试getUserDetail
	@Test
	public void getUserDetailTest(){
		Integer userID=1;
		User userGetUserDetail=backgroundService.getUserDetail(userID);
		System.out.println(userGetUserDetail);
	}
}
