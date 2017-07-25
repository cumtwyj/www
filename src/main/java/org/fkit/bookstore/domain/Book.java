package org.fkit.bookstore.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private Integer bookID;//书籍ID
	private String bookname;//书籍名
	private String author;//作者
	private String publish;//出版社
	//书籍关联的类别ID
	private Integer sortID;//类别ID
	private Double price;//价格
	private String picture_s;//排列图
	private String picture_l;//详情图
	private Integer stock;//库存
	//无参数构造器
	public Book(){
		super();
	}
	//getter和setter方法
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
	public Integer getSortID() {
		return sortID;
	}
	public void setSortID(Integer sortID) {
		this.sortID = sortID;
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
	public String getPicture_l() {
		return picture_l;
	}
	public void setPicture_l(String picture_l) {
		this.picture_l = picture_l;
	}
	
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookname=" + bookname + ", author=" + author + ", publish=" + publish
				+ ", sortID=" + sortID + ", price=" + price + ", picture_s=" + picture_s + ", picture_l=" + picture_l
				+ ", stock=" + stock + "]";
	}
	
	
}
