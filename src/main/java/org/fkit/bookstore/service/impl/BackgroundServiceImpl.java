package org.fkit.bookstore.service.impl;

import java.util.List;

import org.fkit.bookstore.dao.*;
import org.fkit.bookstore.domain.*;
import org.fkit.bookstore.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//声明这个service的所有方法都需要事务管理
@Transactional (propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("backgroundService")
public class BackgroundServiceImpl implements BackgroundService {
	/**
	 * 自动注入持久层Dao对象
	 */
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private DiscussDao discussDao;
	
	
	/**
	 * BookstoreServiceImpl接口login方法实现
	 * @see { BookstoreService }
	 */
	//zhuruyigekeduwenjian
	@Transactional(readOnly=true)
	@Override
	public User loginbackground(String loginname, String password) {
		// TODO Auto-generated method stub
		System.out.println("BookstoreImpl loginbackground -- >>");
		return userDao.selectAdminByUsernameAndPassword(loginname, password);
	}
	/**
	 * BookstoreServiceImpl接口getAllBook方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}
	/**
	 * BookstoreServiceImpl接口getAllAdmin方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public List<User> getAllAdmin() {
		// TODO Auto-generated method stub
		return userDao.findAllAdmin();
	}
	/**
	 * BookstoreServiceImpl接口getAllOrdinary方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public List<User> getAllOrdinary() {
		// TODO Auto-generated method stub
		return userDao.findAllOrdinary();
	}
	/**
	 * BookstoreServiceImpl接口getAllOrdinary方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public User getUserDetail(Integer userID) {
		// TODO Auto-generated method stub
		return userDao.findUserDetail(userID);
	}
	
	/**
	 * BookstoreServiceImpl接口getAllOrdinary方法实现
	 * @see { BookstoreService }
	 */@Override
	public void changeIdentity(User user) {
		// TODO Auto-generated method stub
		userDao.changeIdentity(user);
	}
	
	
	
	
	
	
	/**
	 * BookstoreServiceImpl接口getAllBook方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookDao.findAllBook();
	}
	/**
	 * BookstoreService接口removeBook方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void removeBook(Integer bookID) {
		// TODO Auto-generated method stub
		bookDao.removeBook(bookID);
	}
	/**
	 * BookstoreService接口addBook方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.addBook(book);
	}
	/**
	 * BookstoreService接口changeBook方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void changeBook(Integer bookID, String bookname, String author, String publish, Integer sortID,
			Double price,Integer stock) {
		// TODO Auto-generated method stub
		bookDao.changeBook(bookID, bookname, author, publish, sortID, price,stock);
	}
	
	
	
	
	
	/**
	 * BookstoreService接口getAllOrder方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderDao.findAllOrder();
	}
	/**
	 * BookstoreService接口getAllOrderDFK方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Order> getAllOrderDFK() {
		// TODO Auto-generated method stub
		return orderDao.findAllOrderDFK();
	}
	/**
	 * BookstoreService接口getAllOrderDFH方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Order> getAllOrderDFH() {
		// TODO Auto-generated method stub
		return orderDao.findAllOrderDFH();
	}
	/**
	 * BookstoreService接口getAllOrderDSH方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Order> getAllOrderDSH() {
		// TODO Auto-generated method stub
		return orderDao.findAllOrderDSH();
	}
	/**
	 * BookstoreService接口getAllOrderDPL方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Order> getAllOrderDPL() {
		// TODO Auto-generated method stub
		return orderDao.findAllOrderDPL();
	}
	/**
	 * BookstoreService接口getAllOrderDDWC方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Order> getAllOrderDDWC() {
		// TODO Auto-generated method stub
		return orderDao.findAllOrderDDWC();
	}
	/**
	 * BookstoreService接口getOrderDetail方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public Order getOrderDetail(Integer orderID) {
		// TODO Auto-generated method stub
		return orderDao.findOrderDetail(orderID);
	}
	/**
	 * BookstoreService接口delivery方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void delivery(Integer orderID) {
		// TODO Auto-generated method stub
		orderDao.delivery(orderID);
	}
	/**
	 * BookstoreService接口notice方法实现
	 * @see {BookstoreService}
	 */
	@Transactional(readOnly=true)
	@Override
	public Order notice(Integer orderID, String email) {
		// TODO Auto-generated method stub
		System.out.println("BookstoreImpl notice -- >>");
		return orderDao.selectByOrderIDAndEmail(orderID, email);
	}
	
	
	
	
	
	/**
	 * BookstoreService接口getAllDiscuss方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Discuss> getAllDiscuss() {
		// TODO Auto-generated method stub
		return discussDao.findAllDiscuss();
	}
	
	
	
	
	
}
