package org.fkit.bookstore.domain;

import java.io.Serializable;

public class User implements Serializable{
	private Integer userID;//用户ID
	private String loginname;//登录名
	private String username;//用户名
	private String password;//密码
	private String identity;//身份
	private String phonenumber;//手机号码
	private String address;//地址
	private String email;//邮箱
	//无参数构造器
	public User(){
		super();
	}
	//setter和getter方法
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", loginname="
				+ loginname + ", password=" + password + ", identity=" + identity
				+ ", phonenumber=" + phonenumber + ", address=" + address 
				+ ", email=" + email + "]";
	}
}
