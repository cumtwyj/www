package org.fkit.bookstore.dao;

import static org.fkit.bookstore.util.common.BookstoreConstants.DISCUSSTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.fkit.bookstore.domain.Discuss;


public interface DiscussDao {
	//添加评论
	@Insert("insert into tb_discuss(orderID,logistics,quality,serve,photo,word) values(#{orderID},#{logistics},#{quality},#{serve},#{photo},#{word})")
	void addDiscuss(Discuss discuss);
	/**
	 * 查询所有评论
	 * @return 评论对象集合          后台用
	 */
	@Select(" select * from "+ DISCUSSTABLE )
	List<Discuss> findAllDiscuss();
}
