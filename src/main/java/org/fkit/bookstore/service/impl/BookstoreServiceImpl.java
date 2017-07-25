package org.fkit.bookstore.service.impl;


import java.util.List;




import org.fkit.bookstore.dao.*;
import org.fkit.bookstore.domain.*;

import org.fkit.bookstore.service.BookstoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;


//shengmingzhege service desuoyoufangfadouxuyaoshiwuguanli
@Transactional (propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
//相当于当前类注释为一个Spring的类zhushiyigelei
@Service("bookstoreService")
public class BookstoreServiceImpl implements BookstoreService {
	/**
	 * zidongzhuruchijiuceng Dao duixiang
	 */
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private DetailDao detailDao;
	@Autowired
	private CollectDao collectDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private DiscussDao discussDao;
	
	
	
	
	/**********************用户服务接口实现****************************/
	/**
	 * BookstoreServiceImpl接口login方法实现
	 * @see { BookstoreService }
	 */
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password) {
		// TODO Auto-generated method stub
		System.out.println("BookstoreImpl login -- >>");
		return userDao.selectByUsernameAndPassword(loginname, password);
	}
	
	/**
	 * BookstoreServiceImpl接口login方法实现
	 * @see { BookstoreService }
	 */
	@Transactional(readOnly=true)
	@Override
	public User forget(String loginname, String email) {
		// TODO Auto-generated method stub
		System.out.println("BookstoreImpl forget -- >>");
		return userDao.selectByLoginnameAndEmail(loginname, email);
	}
	
	/**
	 * BookstoreServiceImpl接口confirm方法实现
	 * @see { BookstoreService }
	 */
	@Transactional(readOnly=true)
	@Override
	public User confirm(String loginname, String password) {
		// TODO Auto-generated method stub
		System.out.println("BookstoreImpl confirm -- >>");
		return userDao.selectByUsernameAndPassword(loginname, password);
	}
	
	/**
	 * BookstoreServiceImpl接口changePwd方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public void changePwd(User user) {
		// TODO Auto-generated method stub
		userDao.changePwd(user);
	}
	
	/**
	 * BookstoreServiceImpl接口findUserByUserID方法实现
	 * @see { BookstoreService }
	 */
	@Transactional(readOnly=true)
	@Override
	public User findUserByUserID(Integer userID) {
		// TODO Auto-generated method stub
		System.out.println("BookstoreImpl findUserByUserID -- >>");
		return userDao.selectByUserID(userID);
	}
	
	/**
	 * BookstoreServiceImpl接口removeUserByUserID方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public void removeUserByUserID(Integer userID) {
		// TODO Auto-generated method stub
		userDao.deleteByUserID(userID);
	}
	
	/**
	 * BookstoreServiceImpl接口addUser方法实现
	 * @see { BookstoreService }
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}
	
	
	
	
	
	/*************************书籍服务接口实现***************************/
	/**
	 * BookstoreService接口getAllOneBook方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Book> getAllOneBook(){
		return bookDao.findAllOneBook();
	}
	
	/**
	 * BookstoreService接口getAllTwoBook方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Book> getAllTwoBook(){
		return bookDao.findAllTwoBook();
	}
	
	/**
	 * BookstoreService接口getAllThreeBook方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Book> getAllThreeBook(){
		return bookDao.findAllThreeBook();
	}
	
	/**
	 * BookstoreService接口getAllFourBook方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Book> getAllFourBook(){
		return bookDao.findAllFourBook();
	}
	
	/**
	 * BookstoreService接口getBookDetail方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public Book getBookDetail(Integer bookID) {
		// TODO Auto-generated method stub
		return bookDao.findBookDetail(bookID);
	}
	
	
	
	
	
	
	
	/*************************购物车服务接口实现***************************/
	/**
	 * BookstoreService接口insertDetail方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void saveCart(Detail detail) {
		// TODO Auto-generated method stub
		 detailDao.saveCart(detail);
	}
	
	/**
	 * BookstoreService接口getAllDetailByLoginname方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Detail> getAllDetailByUserID(Integer userID) {
		// TODO Auto-generated method stub
		return detailDao.findAllDetailByUserID(userID);
	}
	
	/**
	 * BookstoreService接口clearCart方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void clearCart(Integer userID) {
		// TODO Auto-generated method stub
		detailDao.clearCart(userID);
	}
	
	/**
	 * BookstoreService接口findCart方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public Detail findCart(Integer userID, Integer bookID) {
		// TODO Auto-generated method stub
		return detailDao.findCart(userID, bookID);
	}
	
	/**
	 * BookstoreService接口removeCart方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public Detail removeCart(Integer userID, Integer bookID) {
		// TODO Auto-generated method stub
		detailDao.removeCart(userID, bookID);
		return detailDao.findCart(userID, bookID);
	}
	
	/**
	 * BookstoreService接口addCount方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void addCount(Detail detail) {
		// TODO Auto-generated method stub
		detailDao.addCount(detail);
	}
	
	/**
	 * BookstoreService接口reduceCount方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void reduceCount(Detail detail) {
		// TODO Auto-generated method stub
		detailDao.reduceCount(detail);
	}
	
	
	
	
	
	
	/*************************收藏服务接口实现***************************/
	/**
	 * BookstoreService接口saveCollect方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void saveCollect(Collect collect) {
		// TODO Auto-generated method stub
		collectDao.saveCollect(collect);
	}
	
	/**
	 * BookstoreService接口getAllCollectByUserID方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Collect> getAllCollectByUserID(Integer userID) {
		// TODO Auto-generated method stub
		return collectDao.findAllCollectByUserID(userID);
	}
	
	/**
	 * BookstoreService接口clearCollect方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void clearCollect(Integer userID) {
		// TODO Auto-generated method stub
		collectDao.clearCollect(userID);
	}
	
	/**
	 * BookstoreService接口findCollect方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public Collect findCollect(Integer userID, Integer bookID) {
		// TODO Auto-generated method stub
		return collectDao.findCollect(userID, bookID);
	}
	
	/**
	 * BookstoreService接口removeCollect方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public Collect removeCollect(Integer userID, Integer bookID) {
		// TODO Auto-generated method stub
		collectDao.removeCollect(userID, bookID);
		return collectDao.findCollect(userID, bookID);
	}
	
	
	
	
	
	
	
	
	/*************************订单服务接口实现***************************/
	/**
	 * BookstoreService接口addOrder方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.addOrder(order);
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
	 * BookstoreService接口getAllOrderByUserID方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public List<Order> getAllOrderByUserID(Integer userID) {
		// TODO Auto-generated method stub
		return orderDao.findAllOrderByUserID(userID);
	}
	
	/**
	 * BookstoreService接口removeOrder方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void removeOrder(Integer orderID) {
		// TODO Auto-generated method stub
		orderDao.removeOrder(orderID);
	}
	
	/**
	 * BookstoreService接口received方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void received(Integer orderID) {
		// TODO Auto-generated method stub
		orderDao.received(orderID);
	}
	
	/**
	 * BookstoreService接口achieve方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void achieve(Integer orderID) {
		// TODO Auto-generated method stub
		orderDao.achieve(orderID);
	}
	
	/**
	 * BookstoreService接口payoff方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void payoff(Integer orderID) {
		// TODO Auto-generated method stub
		orderDao.payoff(orderID);
	}
	
	
	
	
	
	
	/*************************评论服务接口实现***************************/
	/**
	 * BookstoreService接口addDiscuss方法实现
	 * @see {BookstoreService}
	 */
	@Override
	public void addDiscuss(Discuss discuss) {
		// TODO Auto-generated method stub
		discussDao.addDiscuss(discuss);
	}
	
	
	
	

	
}
