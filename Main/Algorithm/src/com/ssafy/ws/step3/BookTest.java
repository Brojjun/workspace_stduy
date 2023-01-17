package com.ssafy.ws.step3;

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		Book b = new Book("21424", "java pro", "김하나", "jaen.kr", 15000, "java 기본 문법");

		Book c = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "sw 모델링");

		System.out.println(b.toString());
		System.out.println(c.toString());

	}
}
