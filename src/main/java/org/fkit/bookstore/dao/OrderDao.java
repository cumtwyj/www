package org.fkit.bookstore.dao;


import static org.fkit.bookstore.util.common.BookstoreConstants.BOOKTABLE;
import static org.fkit.bookstore.util.common.BookstoreConstants.DETAILTABLE;
import static org.fkit.bookstore.util.common.BookstoreConstants.ORDERTABLE;
import static org.fkit.bookstore.util.common.BookstoreConstants.USERTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.domain.Detail;
import org.fkit.bookstore.domain.Order;
import org.fkit.bookstore.domain.User;

public interface OrderDao {
	/**
	 * 查询选择输送订单详情
	 * @retuen  传送订单对象集合
	 */
	@Select(" select * from "+ ORDERTABLE+" where orderID = #{orderID}" )
	Order findOrderDetail(Integer orderID);
	/**
	 * 查询所有订单
	 * @return 订单对象集合          后台用
	 */
	@Select(" select * from "+ ORDERTABLE )
	List<Order> findAllOrder();
	/**
	 * 查询待付款订单
	 * @return 订单对象集合          后台用
	 */
	@Select(" select * from "+ ORDERTABLE+" where status='待付款'" )
	List<Order> findAllOrderDFK();
	/**
	 * 查询待发货订单
	 * @return 订单对象集合          后台用
	 */
	@Select(" select * from "+ ORDERTABLE+" where status='待发货'" )
	List<Order> findAllOrderDFH();
	/**
	 * 查询待收货订单
	 * @return 订单对象集合          后台用
	 */
	@Select(" select * from "+ ORDERTABLE+" where status='待收货'" )
	List<Order> findAllOrderDSH();
	/**
	 * 查询待评论订单
	 * @return 订单对象集合          后台用
	 */
	@Select(" select * from "+ ORDERTABLE+" where status='待评论'" )
	List<Order> findAllOrderDPL();
	/**
	 * 查询订单完成订单
	 * @return 订单对象集合          后台用
	 */
	@Select(" select * from "+ ORDERTABLE+" where status='订单完成'" )
	List<Order> findAllOrderDDWC();
	
	/**
	 * 通过userID查询所有订单细节
	 * @return 订单细节对象集合
	 */
	@Select(" select * from "+ ORDERTABLE +" where userID=#{userID}")
	List<Order> findAllOrderByUserID(@Param("userID")Integer userID);
	//添加订单
	@Insert("insert into tb_order(userID,username,date,phonenumber,address,email,pay,status) values(#{userID},#{username},#{date},#{phonenumber},#{address},#{email},#{pay},#{status})")
	void addOrder(Order order);
	//删除订单
	@Delete("delete from "+ ORDERTABLE+" where orderID=#{orderID}")
	void removeOrder(@Param("orderID")Integer orderID);
	//根据orderID修改密码为“待发货”
    @Update("update "+ORDERTABLE+" set status='待发货' where orderID=#{orderID}")
	void payoff(Integer orderID);
	//根据orderID修改密码为“待收货”
    @Update("update "+ORDERTABLE+" set status='待收货' where orderID=#{orderID}")
	void delivery(Integer orderID);
    //根据orderID修改密码为“待评论”
    @Update("update "+ORDERTABLE+" set status='待评论' where orderID=#{orderID}")
	void received(Integer orderID);
    //根据orderID修改密码为“待评论”
    @Update("update "+ORDERTABLE+" set status='订单完成' where orderID=#{orderID}")
	void achieve(Integer orderID);
    //根据用户名和电子邮件查询用户
  	@Select("select * from "+ ORDERTABLE +" where orderID=#{orderID} and email=#{email}")
  	Order selectByOrderIDAndEmail(
  			@Param("orderID")Integer orderID,
  			@Param("email")String email);
}
