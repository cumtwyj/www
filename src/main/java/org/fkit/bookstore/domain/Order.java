package org.fkit.bookstore.domain;

import java.io.Serializable;

public class Order implements Serializable{
	private Integer orderID;//订单编号
	private Integer userID;//用户编号
	private String username;//收件人
	private String date;//下单日期
	private String phonenumber;//电话号码
	private String address;//地址
	private String email;//电子邮件
	private String pay;//金额
	private String status;//状态
	//无参数构造器
	public Order(){
		super();
	}
	//getter和setter方法
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", userID=" + userID + ", username=" + username + ", date=" + date
				+ ", phonenumber=" + phonenumber + ", address=" + address + ", email=" + email + ", pay=" + pay
				+ ", status=" + status + "]";
	}
	
	
	
}
