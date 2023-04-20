package com.ssafy.todomvc.model;

public class Todo {
	private int no;
	private String content;

	public Todo() {
	}
	
	public Todo(int no, String content) {
		this.no = no;
		this.content = content;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
