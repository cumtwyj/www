package org.fkit.bookstore.dao;

import static org.fkit.bookstore.util.common.BookstoreConstants.DETAILTABLE;
import static org.fkit.bookstore.util.common.BookstoreConstants.USERTABLE;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.domain.Detail;
import org.fkit.bookstore.domain.User;

public interface DetailDao {
	//添加到购物车
	@Insert("insert into tb_detail(userID,loginname,bookID,bookname,author,price,count) values(#{userID},#{loginname},#{bookID},#{bookname},#{author},#{price},#{count})")
	void saveCart(Detail detail);
	
	/**
	 * 查询所有购物车细节
	 * @return 购物车细节对象集合
	 */
	@Select(" select * from "+ DETAILTABLE +" where userID=#{userID}")
	List<Detail> findAllDetailByUserID(@Param("userID")Integer userID);
	/**
	 * 通过书籍bookID和userID查询书籍
	 */
	@Select(" select * from "+ DETAILTABLE +" where userID=#{userID} AND bookID=#{bookID}")
	Detail findCart(@Param("userID")Integer userID,
			@Param("bookID")Integer bookID);
	//清空购物车
	@Delete("delete from "+ DETAILTABLE+" where userID=#{userID}")
	void clearCart(@Param("userID")Integer userID);
	//删除商品
	@Delete("delete from "+ DETAILTABLE+" where userID=#{userID} AND bookID=#{bookID}")
	void removeCart(@Param("userID")Integer userID,
			@Param("bookID")Integer bookID);
	//根据userID和bookID增加数量
    @Update("update "+DETAILTABLE+" set count=count+1 where userID=#{userID} AND bookID=#{bookID}")
	void addCount(Detail detail);
	//根据userID和bookID减少数量
	@Update("update "+DETAILTABLE+" set count=count-1 where userID=#{userID} AND bookID=#{bookID}")
	void reduceCount(Detail detail);
}
