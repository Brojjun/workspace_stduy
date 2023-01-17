package com.saffy.day2;

public class Dog {
	//void를 붙이면 생성자로 인식하지 못함. -> 반환타입을 주면 일반 메소드로 인식
	//생성자가 아닌 일반 메서드로 인식된다. (생성자는 반환타입 자체가 없어야 한다.)
	String name = "으으으으으";
	int age = 0;
	Dog(){
		this("noName",-1);
	} 
	Dog(String name) {
		this(name,-1);
	}
	Dog(String name, int age) {
		System.out.println("Dog 생성자 호출");
		this.name = name;
		this.age = age;
		System.out.println(name+" : "+age);
		
	}
	static void alarm() {
		//System.out.println(this);
		
	}
}
