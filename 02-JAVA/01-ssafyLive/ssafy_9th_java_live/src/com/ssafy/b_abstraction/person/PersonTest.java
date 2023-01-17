package com.ssafy.b_abstraction.person;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Person.org);
		
		Person p = new Person();
		p.org = "kepco222";
		p.name = "홍길동";
		p.isHungry = true;
		p.eat();
		
		p.printInfo();
		
		Person p2 = new Person();
		p2.name = "자기장";
		p2.work();
		p2.printInfo();
		
		System.out.println(p2.org);
		
	}

}
