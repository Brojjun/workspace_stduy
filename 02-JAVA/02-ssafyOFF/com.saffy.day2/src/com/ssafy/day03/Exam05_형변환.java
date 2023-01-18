package com.ssafy.day03;

class P {
	
}

class C extends P{
	
	
}
public class Exam05_형변환 {
	public static void main(String[] args) {
		P p = new P();
		C c = new C();
		
		//부모는 자식 타입을 받을 수 있다. 왜? 
		P p1 = new C();
		
		// 객체변수 instanceof 타입 -> ture of false
		// p instanceof P -> true
		// p instanceof Object -> true
		// p instanceof C -> false
		// c instanceof P -> true
		// c instanceof Object -> true
		
		System.out.println(p instanceof P);
		System.out.println(p instanceof Object);
		System.out.println(p instanceof C);
		System.out.println(c instanceof P);
		System.out.println(c instanceof Object);
	}
}
