package com.ssafy.ws.step3;

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("21424", "java pro", "김하나", "jaen.kr", 15000, "java 기본 문법");

		Book b2 = new Book("35351", "분설계", "소", "jan.kr", 3000, "sw 모델링");

		Book b3 = new Book("35352", "분석계", "무", "jen.kr", 300, "sw 모링");

		Book b4 = new Book("35353", "분계", "소나", "jaen.r", 30, "sw 링");

		Book b5 = new Book("35354", "분", "소무", "jaenkr", 300090, "sw 모");

		Book b6 = new Book("35355", "분석설계", "나무", "jn.kr", 307000, "sw ");

		BookManager bookmanager = new BookManager();
		bookmanager.add(b1);
		bookmanager.add(b2);
		bookmanager.add(b3);
		bookmanager.add(b4);
		bookmanager.add(b5);
		bookmanager.add(b6);
		
		Book[] books = bookmanager.getList();
		
		System.out.println("등록 후");
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) continue;
			System.out.println(books[i].toString());
			}
		
		
		System.out.println("삭제 후");
		bookmanager.remove("21424");
		books = bookmanager.getList();
		
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) continue;
			System.out.println(books[i].toString());
		}
		
		System.out.println("조회 : ");
		System.out.println(bookmanager.searchByisbn("35352").toString());
		
	}
}
