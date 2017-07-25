package org.fkit.bookstore.domain;

import java.io.Serializable;

public class Collect implements Serializable{
	private Integer ID;//收藏ID
	private Integer userID;//用户ID
	private String loginname;//用户名
	private Integer bookID;//书号
	private String bookname;//书名
	private String author;//作者
	private String publish;//出版社
	private Double price;//价格
	private String picture_s;//介绍图
	//无参数构造器
	public Collect(){
		super();
	}
	//setter和getter方法
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	
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
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPicture_s() {
		return picture_s;
	}
	public void setPicture_s(String picture_s) {
		this.picture_s = picture_s;
	}
	@Override
	public String toString() {
		return "Collect [ID=" + ID + ", userID=" + userID + ", loginname=" + loginname + ", bookID=" + bookID
				+ ", bookname=" + bookname + ", author=" + author + ", publish=" + publish + ", price=" + price
				+ ", picture_s=" + picture_s + "]";
	}
	
	
}
