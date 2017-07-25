package org.fkit.bookstore.domain;

import java.io.Serializable;

public class Sort implements Serializable{
	private Integer sortID;//类别ID
	private String sortname;//类别名称
	//无参数构造器
	public Sort(){
		super();
	}
	//getter和setter方法
	public Integer getSortID() {
		return sortID;
	}
	public void setSortID(Integer sortID) {
		this.sortID = sortID;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	
}
