package com.ssafy.day05;

class Box01 {
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}

public class Box01Test {
	public static void main(String[] args) {
		Box01 box = new Box01();
		box.setData("깔깔깔");
		//box.setData(100);
		
	}
}