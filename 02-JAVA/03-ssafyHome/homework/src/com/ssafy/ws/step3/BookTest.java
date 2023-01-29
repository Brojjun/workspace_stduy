package com.ssafy.ws.step3;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		//코드를 작성해주세요. 
		
		
		Book b1 = new Book("21424", "java pro", "김하나", "jaen.kr", 15000, "java 기본 문법", 100);

		Book b2 = new Book("35351", "분설계", "소", "jan.kr", 3000, "sw 모델링", 100);

		Book b3 = new Book("35352", "분석계", "무", "jen.kr", 300, "sw 모링", 100);

		Book b4 = new Book("35353", "분계", "소나", "jaen.r", 30, "sw 링", 100);

		Book b5 = new Book("35354", "분", "소무", "jaenkr", 300090, "sw 모", 100);

		Book b6 = new Book("35355", "분석설계", "나무", "jn.kr", 307000, "sw ", 100);
		
		IBookManager bookmanager = BookManagerImpl.getInstance();
		bookmanager.add(b1);
		bookmanager.add(b2);
		bookmanager.add(b3);
		bookmanager.add(b4);
		bookmanager.add(b5);
		bookmanager.add(b6);
		
		bookmanager.saveData();
		bookmanager.loadData();
		System.out.println(bookmanager.getTotalPrice());
	}
}
