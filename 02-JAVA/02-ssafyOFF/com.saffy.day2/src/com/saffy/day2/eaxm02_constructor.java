package com.saffy.day2;
/*
 * -생성자는 객체가 생성될 때만 호출
 * -일반 메서드(인스턴스 메서드)와의 차이
 *  : 일반 메서드 : 객체가 생성된 이후에 호출된다.  / 생성자 메서드는 생성시 한번만 호출이 가능하다.
 *  
 *  타입 a = new 타입(); (=우측이 생성자) -> new는 객체를 생성한다는 뜻 -> 생성자의 특징 : 클래스의 이름과 같아야한다.
 *   
 * 생성자의 특징
 * 1. 이름이 클래스와 동일하다.
 * 2. 반환타입이 없다.(void x)
 * 3. 디포트 생성자
 * 		형태 : 클래스접근제한자 클래스명() - 매게변수 없는 형태
 * 		조건 : 클래스에 정의된 생성자가 존재하지 않을 때
 * 4. 생성자는 오버로딩을 지원한다.
 * 5. 다른 생성자 호출은 this 사용!!@!@!@!@!@!
 * 5-1. this.  (this.변수 , this.메서드())-->맴버변수와 메소드 사용
 * 5-2. this()  (자기자신(생성자))
 *->this의 제약사항 => this.변수 또는 메소드의 호출은 static영역에서는 사용 불가능하다.
 *->this() 생성자 호출은 일반메서드에서 사용 불가능 // 무조건 생성자 안에서 첫번째 구문으로만 호출 가능
 * 
 * JVM (Run Time Area)
 */
public class eaxm02_constructor {
	//static에서 instance 변수를 사용하면?? ㅈ됨
	int val = 100;
	static int val2 = 1000;
public static void main(String[] args) {
	Dog d1 = new Dog("이이ㅣ");
	//System.out.println(val); -> 불가능
	eaxm02_constructor exam = new eaxm02_constructor();
	System.out.println(exam.val);
	System.out.println(eaxm02_constructor.val2);
	//d1.call();
}
}
