package com.ssafy.paging.model;

public class Page {
	private int pageNo;
	private int listSize;
	
	public Page() {this.pageNo = 1; this.listSize = 10;}
	public Page(int pageNo) {this.pageNo = pageNo; this.listSize = 10;}
	public Page(int pageNo, int listSize) {this.pageNo = pageNo; this.listSize = listSize;}
	
	public int getBegin() {
		return (pageNo - 1) * listSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	
	
	
}