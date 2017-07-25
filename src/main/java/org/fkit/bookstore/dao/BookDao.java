package org.fkit.bookstore.dao;

import static org.fkit.bookstore.util.common.BookstoreConstants.BOOKTABLE;
import static org.fkit.bookstore.util.common.BookstoreConstants.DETAILTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.domain.Detail;


public interface BookDao {
	/**
	 * 查询所有书籍
	 * @return 书籍对象集合
	 */
	@Select(" select * from "+ BOOKTABLE )
	List<Book> findAllBook();
	/**
	 * 查询所有小说书籍
	 * @return 小说书籍对象集合
	 */
	@Select(" select * from "+ BOOKTABLE+" where sortID = 1" )
	List<Book> findAllOneBook();
	/**
	 * 查询所有文学书籍
	 * @return 文学书籍对象集合
	 */
	@Select(" select * from "+ BOOKTABLE+" where sortID = 2" )
	List<Book> findAllTwoBook();
	/**
	 * 查询所有历史书籍
	 * @return 历史书籍对象集合
	 */
	@Select(" select * from "+ BOOKTABLE+" where sortID = 3" )
	List<Book> findAllThreeBook();
	/**
	 * 查询所有科普书籍
	 * @return 科普书籍对象集合
	 */
	@Select(" select * from "+ BOOKTABLE+" where sortID = 4" )
	List<Book> findAllFourBook();
	/**
	 * 查询选择输送详情书籍
	 * @retuen  传送书籍对象集合
	 */
	@Select(" select * from "+ BOOKTABLE+" where bookID = #{bookID}" )
	Book findBookDetail(Integer bookID);
	//删除书籍
	@Delete("delete from "+ BOOKTABLE+" where bookID=#{bookID}")
	void removeBook(@Param("bookID")Integer bookID);
	//添加书籍
	@Insert("insert into tb_book(bookname,author,publish,sortID,price,picture_s,picture_l,stock) values(#{bookname},#{author},#{publish},#{sortID},#{price},#{picture_s},#{picture_l},#{stock})")
	void addBook(Book book);
	//修改书籍
    @Update("update "+BOOKTABLE+" set bookname=#{bookname},author=#{author},publish=#{publish},sortID=#{sortID},price=#{price},stock=#{stock} where bookID=#{bookID}")
	void changeBook(@Param("bookID")Integer bookID,
			@Param("bookname")String bookname,
			@Param("author")String author,
			@Param("publish")String publish,
			@Param("sortID")Integer sortID,
			@Param("price")Double price,
			@Param("stock")Integer stock);
}
