package com.ssafy.c_inheritance.person;

public class Person {
	String name;
	public Person() {}
	public Person(String nema) {
		this.name = name;
	}
	
	void eat() {
		System.out.println("냠냠");
	}
	
	void eat(String tool) {
		System.out.print(tool + "을 이용해서");
		eat();
	}
	
	void jump() {
		System.out.println("폴짝");
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
