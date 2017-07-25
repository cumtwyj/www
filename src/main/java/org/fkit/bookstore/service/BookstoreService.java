package org.fkit.bookstore.service;

import java.util.List;

import org.fkit.bookstore.domain.*;
//import org.fkit.bookstore.util.tag.PageModel;

public interface BookstoreService {
	
	/*************************用户服务接口***************************/
	/**
	 * 用户登录
	 * @Param loginname
	 * @Param password
	 * @return User 对象
	 * */
	User login(String loginname,String password);
	/**
	 * 用户找回密码
	 * @Param email
	 * @return User 对象
	 * */
	User forget(String loginname,String email);
	/**
	 * 用户修改密码中比对密码用户名
	 * @Param loginname
	 * @Param password
	 * @return User 对象
	 * */
	User confirm(String loginname,String password);
	/**
	 * 根据userID修改用户密码
	 * @Param userID
	 * @return 用户对象
	 * */
	void changePwd(User user);
	/**
	 * 根据userID查询用户
	 * @Param userID
	 * @return 用户对象
	 * */
	User findUserByUserID(Integer userID);
	/**
	 * 根据userID删除用户
	 * @Param userID
	 * */
	void removeUserByUserID(Integer userID);
	/**
	 * 添加用户
	 * @Param User 用户对象
	 * */
	void addUser(User user);
	
	
	
	
	
	
	
	
	/*************************书籍服务接口***************************/
	/**
	 * 查找小说图书
	 * @return Book小说对象集合
	 */
	List<Book> getAllOneBook();
	/**
	 * 查找文学图书
	 * @return Book文学对象集合
	 */
	List<Book> getAllTwoBook();
	/**
	 * 查找历史图书
	 * @return Book对象历史集合
	 */
	List<Book> getAllThreeBook();
	/**
	 * 查找科普图书
	 * @return Book科普对象集合
	 */
	List<Book> getAllFourBook();
	/**
	 * 根据bookID查找书籍细节
	 * @Param bookID
	 * */
	Book getBookDetail(Integer bookID);
	
	
	
	
	
	
	
	/*************************购物车服务接口***************************/
	/**
	 * 输入订单细节,加入购物车
	 **/
	void saveCart(Detail detail);
	/**
	 * 查找购物车
	 * @return Detail小说对象集合
	 */
	List<Detail> getAllDetailByUserID(Integer userID);
	 
	/**
	 * 清空购物车
	 **/
	void clearCart(Integer userID);
	/**
	 * 通过书籍bookID和userID查询书籍
	 **/
	Detail findCart(Integer userID,Integer bookID);
	/**
	 * 删除商品
	 **/
	Detail removeCart(Integer userID,Integer bookID);
	/**
	 * 增加数量
	 **/
	void addCount(Detail detail);
	/**
	 * 减少数量
	 **/
	void reduceCount(Detail detail);
	
	
	
	
	
	
	
	
	
	/*************************收藏服务接口***************************/
	/**
	 * 输入收藏
	 **/
	void saveCollect(Collect collect);
	/**
	 * 查找收藏细节
	 * @return Collect小说对象集合
	 */
	List<Collect> getAllCollectByUserID(Integer userID);
	 
	/**
	 * 清空收藏
	 **/
	void clearCollect(Integer userID);
	/**
	 * 通过书籍bookID和userID查询收藏书籍
	 **/
	Collect findCollect(Integer userID,Integer bookID);
	/**
	 * 删除收藏
	 **/
	Collect removeCollect(Integer userID,Integer bookID);
	
	
	
	
	
	
	
	
	
	
	/*************************订单服务接口***************************/
	/**
	 * 添加订单
	 **/
	void addOrder(Order order);
	/**
	 * 查找所有订单
	 * @return Order订单对象集合
	 */
	List<Order> getAllOrder();
	/**
	 * 查找订单
	 * @return Detail小说对象集合
	 */
	List<Order> getAllOrderByUserID(Integer userID);
	/**
	 * 删除订单
	 **/
	void removeOrder(Integer orderID);
	/**
	 * 修改订单状态为待评论
	 * @return 订单对象
	 * */
	void received(Integer orderID);
	/**
	 * 修改订单状态为待发货
	 * @return 订单对象
	 * */
	void payoff(Integer orderID);
	/**
	 * 修改订单状态为待评论
	 * @return 订单对象
	 * */
	void achieve(Integer orderID);
	
	
	
	
	
	
	
	
	/*************************评论服务接口***************************/
	/**
	 * 添加评论
	 **/
	void addDiscuss(Discuss discuss);
}
