package org.fkit.bookstore.dao.provider;

import static org.fkit.bookstore.util.common.BookstoreConstants.BOOKTABLE;
import static org.fkit.bookstore.util.common.BookstoreConstants.SORTTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.domain.Sort;

public class BookDynaSqlProvider {
	//分页动态查询
	public String selectWhitParam(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(BOOKTABLE);
				if(params.get("book") != null){
					Book book =(Book) params.get("book");
					if(book.getBookname() != null && !book.getBookname().equals("")){
						WHERE("BOOK_NAME LIKE CONCAT ('%',#{book.bookname},'%')");
					}
					if(book.getAuthor() != null && !book.getAuthor().equals("")){
						WHERE("AUTHOR LIKE CONCAT ('%',#{book.author},'%')");
					}
					if(book.getPublish() != null && !book.getPublish().equals("")){
						WHERE("PUBLISH LIKE CONCAT ('%',#{book.publish},'%')");
					}
					if(book.getPrice() != null && !book.getPrice().equals("")){
						WHERE("PRICE LIKE CONCAT ('%',#{book.price},'%')");
					}
					if(book.getPicture_s() != null && !book.getPicture_s().equals("")){
						WHERE("PICTURE_S LIKE CONCAT ('%',#{book.picture_s},'%')");
					}
					if(book.getPicture_l() != null && !book.getPicture_l().equals("")){
						WHERE("PICTURE_L LIKE CONCAT ('%',#{book.picture_l},'%')");
					}
					
				}
			}
		}.toString();
		if(params.get("pageModel") != null){
			sql += "limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}";
		}
		return sql;
	}
	//动态查询总数量
	public String count(Map<String,Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(BOOKTABLE);
				if (params.get("book") != null){
					Book book =(Book)params.get("book");
					if(book.getBookname() != null && !book.getBookname().equals("")){
						WHERE("BOOK_NAME LIKE CONCAT ('%',#{book.bookname},'%')");
					}
					if(book.getAuthor() != null && !book.getAuthor().equals("")){
						WHERE("AUTHOR LIKE CONCAT ('%',#{book.author},'%')");
					}
					if(book.getPublish() != null && !book.getPublish().equals("")){
						WHERE("PUBLISH LIKE CONCAT ('%',#{book.publish},'%')");
					}
					if(book.getPrice() != null && !book.getPrice().equals("")){
						WHERE("PRICE LIKE CONCAT ('%',#{book.price},'%')");
					}
					if(book.getPicture_s() != null && !book.getPicture_s().equals("")){
						WHERE("PICTURE_S LIKE CONCAT ('%',#{book.picture_s},'%')");
					}
					if(book.getPicture_l() != null && !book.getPicture_l().equals("")){
						WHERE("PICTURE_L LIKE CONCAT ('%',#{book.picture_l},'%')");
					}
					
				}
			}
		}.toString();
	}
	//动态插入
	public String insertBook(Book book){
		return new SQL(){
			{
				INSERT_INTO(BOOKTABLE);
				if(book.getBookname() != null){
					VALUES("bookname","#{bookname}");
				}
				if(book.getAuthor() != null){
					VALUES("author","#{author}");
				}
				if(book.getPublish() != null){
					VALUES("publish","#{publish}");
				}
				if(book.getPrice() != null){
					VALUES("price","#{price}");
				}
				if(book.getPicture_s() != null){
					VALUES("picture_s","#{picture_s}");
				}
				if(book.getPicture_l() != null){
					VALUES("picture_l","#{picture_l}");
				}
				if(book.getSortID() != null){
					VALUES("sortID","#{sortID}");
				}
			}
		}.toString();
	}
	//动态更新
	public String updateBook(Book book){
		return new SQL(){
			{
				UPDATE(BOOKTABLE);
				if(book.getBookname() != null){
					SET("bookname = #{bookname}");
				}
				if(book.getAuthor() != null){
					SET("author = #{author}");
				}
				if(book.getPublish() != null){
					SET("publish = #{publish}");
				}
				if(book.getPrice() != null){
					SET("price = #{price}");
				}
				if(book.getPicture_s() != null){
					SET("picture_s = #{picture_s}");
				}
				if(book.getPicture_l() != null){
					SET("picture_l = #{picture_l}");
				}
				if(book.getSortID() != null){
					SET("sortID = #{sortID}");
				}
			}
		}.toString();
	}
}
