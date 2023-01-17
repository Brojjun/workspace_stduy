package com.saffy.day2;

/*
 * 오버로딩 ( 매개변수의 갯수 or 타입이 다름 ) vs 오버라이딩 ( 상속관계에서 발생 )
 * 
 * 객체지향의 특징 : 다형성
 * -> 이름이 동일한데, 하는 일이 다른 것
 * 
 * 공통점 : 메소드의 이름이 같은 것
 * 
 * overloading
 * - 메소드 이름이 같다.
 * - 매개변수의 개수 또는 타입이 달라야 한다.
 * - 반환타입은 상관없다.
 * 
 * 
 */

public class exam01_overloading {
	

	
	static void printArray(int[] arr) {
		printArray(arr,0,arr.length);
	}
	
	static void printArray(int[] arr, int begin) {
		print(arr,begin,arr.length);
	}
	
	static void printArray(int[] arr, int begin, int end) {
		for(int i = begin; i < Math.min(end,arr.length); i++)
			System.out.println(arr[i]);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	public static void main(String[] args) {
		printArray(new int[] {4,3,3,4});
		printArray(new int[] {4,3,3,4},2);	
		printArray(new int[] {4,3,3,4},2,3);	
		
		/*
		int season = 10;
		switch (season) {
		case 12:
		case 1:
		case 2:
			System.out.println("season은 겨울입니다.");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("season은 봄입니다.");
			break;
			
		}
		 */
		
		/*
		 * object는 모든 객체의 부모 클래스 
		println(Object e){
			
		}
		*/
		
	}
}
