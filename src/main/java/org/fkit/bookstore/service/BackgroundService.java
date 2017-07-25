package org.fkit.bookstore.service;

import java.util.List;


import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.domain.Discuss;
import org.fkit.bookstore.domain.Order;
import org.fkit.bookstore.domain.User;

public interface BackgroundService {
	/**
	 * 用户登录
	 * @Param loginname
	 * @Param password
	 * @return User 对象
	 * */
	User loginbackground(String loginname,String password);
	/**
	 * 查找所有用户
	 * @return User用户对象集合
	 */
	List<User> getAllUser();
	/**
	 * 查找管理员用户
	 * @return User用户对象集合
	 */
	List<User> getAllAdmin();
	/**
	 * 查找用户
	 * @return User用户对象集合
	 */
	List<User> getAllOrdinary();
	/**
	 * 根据userID查找用户详情
	 * @Param userID
	 * */
	User getUserDetail(Integer userID);
	/**
	 * 修改用户权限
	 * @return 用户对象
	 * */
	void changeIdentity(User user);
	
	
	
	
	
	/**
	 * 查找所有图书
	 * @return Book小说对象集合
	 */
	List<Book> getAllBook();
	/**
	 * 删除书籍
	 **/
	void removeBook(Integer bookID);
	/**
	 * 添加书籍
	 **/
	void addBook(Book book);
	/**
	 * 修改书籍
	 **/
	void changeBook(Integer bookID,String bookname,String author,String publish,Integer sortID,Double price,Integer stock);
	
	
	
	
	
	
	/**
	 * 根据orderID查找用户详情
	 * @Param orderID
	 * */
	Order getOrderDetail(Integer orderID);
	/**
	 * 查找所有订单
	 * @return Order订单对象集合
	 */
	List<Order> getAllOrder();
	/**
	 * 查询待付款订单
	 * @return 订单对象集合          
	 */
	List<Order> getAllOrderDFK();
	/**
	 * 查询待发货订单
	 * @return 订单对象集合          后台用
	 */
	List<Order> getAllOrderDFH();
	/**
	 * 查询待收货订单
	 * @return 订单对象集合          后台用
	 */
	List<Order> getAllOrderDSH();
	/**
	 * 查询待评论订单
	 * @return 订单对象集合          后台用
	 */
	List<Order> getAllOrderDPL();
	/**
	 * 查询订单完成订单
	 * @return 订单对象集合          后台用
	 */
	List<Order> getAllOrderDDWC();
	/**
	 * 修改订单状态为发货
	 * @return 订单对象
	 * */
	void delivery(Integer orderID);
	/**
	 * 查询订单
	 * @Param email
	 * @return Order 对象
	 * */
	Order notice(Integer orderID,String email);
	
	
	
	
	/**
	 * 查找所有评论
	 * @return Discuss评论对象集合
	 */
	List<Discuss> getAllDiscuss();
	
}
