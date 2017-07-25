package org.fkit.bookstore.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.fkit.bookstore.dao.provider.UserDynaSqlProvider;
import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.domain.User;

import static org.fkit.bookstore.util.common.BookstoreConstants.BOOKTABLE;
import static org.fkit.bookstore.util.common.BookstoreConstants.USERTABLE;

public interface UserDao {
	//根据用户名和密码查询用户
	@Select("select * from "+ USERTABLE +" where loginname=#{loginname} and password=#{password}")
	User selectByUsernameAndPassword(
			@Param("loginname")String loginname,
			@Param("password")String password);
	//根据用户名、身份和密码查询管理员
	@Select("select * from "+ USERTABLE +" where loginname=#{loginname} and password=#{password} and identity='管理员'")
	User selectAdminByUsernameAndPassword(
			@Param("loginname")String loginname,
			@Param("password")String password);
	//根据用户名和电子邮件查询用户
	@Select("select * from "+ USERTABLE +" where loginname=#{loginname} and email=#{email}")
	User selectByLoginnameAndEmail(
			@Param("loginname")String loginname,
			@Param("email")String email);
	//根据userID查询用户
	@Select("select * from "+USERTABLE+" where userID=#{userID}")
	User selectByUserID(Integer userID);
	//根据userID删除用户
	@Delete("delete from"+USERTABLE+"where userID=#{userID}")
	User deleteByUserID(Integer userID);
	//根据userID修改密码
    @Update("update "+USERTABLE+" set password=#{password} where userID=#{userID}")
	void changePwd(User user);
    //根据userID修改权限
    @Update("update "+USERTABLE+" set identity=#{identity} where userID=#{userID}")
	void changeIdentity(User user);
	//动态插入用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(User user);
	/**
	 * 查询所有用户
	 * @return 书籍对象集合
	 */
	@Select(" select * from "+ USERTABLE )
	List<User> findAllUser();
	/**
	 * 查询所有用户
	 * @return 书籍对象集合
	 */
	@Select(" select * from "+ USERTABLE +" where identity='管理员'" )
	List<User> findAllAdmin();
	/**
	 * 查询所有用户
	 * @return 书籍对象集合
	 */
	@Select(" select * from "+ USERTABLE +" where identity='用户'" )
	List<User> findAllOrdinary();
	/**
	 * 查询选择输送用户详情
	 * @retuen  传送用户对象集合
	 */
	@Select(" select * from "+ USERTABLE+" where userID = #{userID}" )
	User findUserDetail(Integer userID);
}
