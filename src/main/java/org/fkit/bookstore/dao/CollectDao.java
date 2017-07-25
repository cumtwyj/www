package org.fkit.bookstore.dao;

import static org.fkit.bookstore.util.common.BookstoreConstants.COLLECTTABLE;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.bookstore.domain.Collect;


public interface CollectDao {
	//添加到收藏
	@Insert("insert into tb_collect(userID,loginname,bookID,bookname,author,publish,price,picture_s) values(#{userID},#{loginname},#{bookID},#{bookname},#{author},#{publish},#{price},#{picture_s})")
	void saveCollect(Collect collect);
	/**
	 * 查询所有收藏
	 * @return 收藏对象集合
	 */
	@Select(" select * from "+ COLLECTTABLE +" where userID=#{userID}")
	List<Collect> findAllCollectByUserID(@Param("userID")Integer userID);
	/**
	 * 通过书籍bookID和userID查询书籍
	 */
	@Select(" select * from "+ COLLECTTABLE +" where userID=#{userID} AND bookID=#{bookID}")
	Collect findCollect(@Param("userID")Integer userID,
			@Param("bookID")Integer bookID);
	//清空收藏
	@Delete("delete from "+ COLLECTTABLE+" where userID=#{userID}")
	void clearCollect(@Param("userID")Integer userID);
	//删除收藏
	@Delete("delete from "+ COLLECTTABLE+" where userID=#{userID} AND bookID=#{bookID}")
	void removeCollect(@Param("userID")Integer userID,
			@Param("bookID")Integer bookID);
}
