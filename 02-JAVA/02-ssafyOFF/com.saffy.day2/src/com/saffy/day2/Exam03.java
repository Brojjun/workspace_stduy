/*
 * static 블럭
 * -클래스 정보가 로딩할 때 실행
 * -형태 : static {}
 * static은 클래스정보를 로딩할때 class에 생성
 * 이는 static변수 참조할때나, 생성할때 등 class 정보가 필요할 때
 * 
 */
package com.saffy.day2;

//import com.ssafy.board.step01.BoardUI;
class StaticSub{
	StaticSub(){
		System.out.println("1. 생성생성");
	}
	static int v= 100;
	static {
		System.out.println("2. 클래스 로딩");
		
	}
}
public class Exam03 {
	public static void main(String[] args) {
		System.out.println("3. main 실행");
		StaticSub s = new StaticSub();
		StaticSub ss = new StaticSub();
		System.out.println(StaticSub.v);
	}

}
