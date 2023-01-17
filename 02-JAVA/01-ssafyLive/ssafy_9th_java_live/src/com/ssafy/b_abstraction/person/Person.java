package com.ssafy.b_abstraction.person;

public class Person {
	//속성
	static String org ="kepco";
	String name;
	int age;
	boolean isHungry;
	
	//메소드
	void work() {
		isHungry = true;
	}
	void eat() {
		isHungry = false;
	}
	
	void printInfo() {
		System.out.println(name + " : " + age + " : " + isHungry );
	}
}
