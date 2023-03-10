package com.ssafy.ws.step3;

/**
 * 잡지 정보를 나타내는 클래스
 */

public class Magazine extends Book {
	//코드를 작성해주세요. 
	private int year;
	private int month;
	
	public Magazine() {
		super();
	}

	public Magazine(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + "]";
	}
	
}
