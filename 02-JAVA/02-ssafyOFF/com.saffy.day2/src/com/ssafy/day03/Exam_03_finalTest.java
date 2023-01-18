package com.ssafy.day03;

//인터페이스의 default 접근제한자는 public
interface A{
	public void print();
}

class Parent{
	public final void call() {
		
	}
	
}

class Child extends Parent implements A{
	final int val;
	Child(int val){
		this.val = val;
	}
	
	//Cannot reduce the visibility of the inherited method from A
	public void print() {
		System.out.println(Exam_03_finalTest.SERVER_IP);
		
	}
	public void call() {
	System.out.println("오버라이딩 했다.");
	}
	
}
// 접근제한자 : public, default package
// 활용관련 : final, abstract
public class Exam_03_finalTest {
	public static final String SERVER_IP = "192.168.0.1"; //상수
	Child c = new Child();
	
	/*
	 *
	 * final 키워드 :
	 * 변수 : 변수의 값을 더이상 못바꿈 (선언때 초기화로 고정하면 끝~) -> 선언 시 값이 없으면 생성자를 통해 가능
	 * 메서드 : overriding 금지, 더이상 메서드의 내용을 변경하는 것을 금지
	 * 클래스 : 더이상 자식 class 생성 불가능 ( 상속 불가능 ) -> 마지막 자손
	 */
	
	// 내부 클래스는 접근제한자 : 4가지 가능 ( public, protected, private ,default package ) 다 가능
	class Inner {
		
	}
	/*
	 * 접근제한자 : 4가지 가능 ( public, protected, private ,default package )  
	 * 활용제한자 : final, abstarct, static, synchronized
	 */
	public void call() {
		System.out.println();
		
		
	}
	public static void main(String[] args) {
	}
}
