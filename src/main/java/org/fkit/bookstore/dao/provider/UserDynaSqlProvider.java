package org.fkit.bookstore.dao.provider;

import static org.fkit.bookstore.util.common.BookstoreConstants.USERTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.bookstore.domain.User;

public class UserDynaSqlProvider {
	//分页动态查询
	public String selectWhitParam(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user =(User)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE("username LIKE CONCAT ('%',#{user.username},'%')");
					}
					if(user.getIdentity() !=null && !user.getIdentity().equals("")){
						WHERE("identity LIKE CONCAT ('%',#{user.identity},'%')");
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
	public String count (Map<String,Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if (params.get("user") != null){
					User user =(User)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE("username LIKE CONCAT ('%',#{user.username},'%')");
					}
					if(user.getIdentity() != null && !user.getIdentity().equals("")){
						WHERE("identity LIKE CONCAT ('%',#{user.identity},'%')");
					}
				}
			}
		}.toString();
	}
	//动态插入
	public String insertUser(User user){
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUsername() != null && !user.getUsername().equals("")){
					VALUES("username", "#{username}");
				}
				if(user.getIdentity() != null && !user.getIdentity().equals("")){
					VALUES("identity", "#{identity}");
				}
				if(user.getLoginname() != null && !user.getLoginname().equals("")){
					VALUES("loginname", "#{loginname}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
				if(user.getPhonenumber() != null && !user.getPhonenumber().equals("")){
					VALUES("phonenumber", "#{phonenumber}");
				}
				if(user.getAddress() != null && !user.getAddress().equals("")){
					VALUES("address", "#{address}");
				}
				if(user.getEmail() != null && !user.getEmail().equals("")){
					VALUES("email", "#{email}");
				}
			}
		}.toString();
	}
	//动态更新
	public String updateUser(User user){
		return new SQL(){
			{
				UPDATE(USERTABLE);
				if(user.getUsername() != null){
					SET(" username = #{username} ");
				}
				if(user.getLoginname() != null){
					SET(" loginname = #{loginname} ");
				}
				if(user.getPassword()!= null){
					SET(" password = #{password} ");
				}
				if(user.getIdentity()!= null){
					SET(" identity = #{identity} ");
				}
				if(user.getPhonenumber()!= null){
					SET(" phonenumber = #{phonenumber} ");
				}
				if(user.getAddress()!= null){
					SET(" address = #{address} ");
				}
				if(user.getEmail()!= null){
					SET(" email = #{email} ");
				}
				WHERE(" userID = #{userID} ");
			}
		}.toString();
	}
}
