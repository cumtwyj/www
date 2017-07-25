package org.fkit.bookstore.domain;

public class Discuss {
	private Integer ID;//评论编号
	private Integer orderID;//订单编号
	private String logistics;//物流评分
	private String quality;//质量评分
	private String serve;//服务评分
	private String photo;//图片评论
	private String word;//文字评论
	//无参数构造器
	public Discuss(){
		super();
	}
	//getter和setter方法
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public String getLogistics() {
		return logistics;
	}
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getServe() {
		return serve;
	}
	public void setServe(String serve) {
		this.serve = serve;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "Discuss [ID=" + ID + ", orderID=" + orderID + ", logistics=" + logistics + ", quality=" + quality
				+ ", serve=" + serve + ", photo=" + photo + ", word=" + word + "]";
	}
	
}
