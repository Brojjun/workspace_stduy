package com.ssafy.c_inheritance.person;

public class SpiderManTest {
	public static void main(String[] args) {
		
	
	SpiderMan sman = new SpiderMan("aa");
	

	sman.name = "피터파카";
	sman.eat();
	sman.jump();
	sman.isSpider = true;
	sman.fireWeb();
	sman.eat("숟가락");
	
	System.out.println(sman.toString());
	
	String s1 = new String("1123");
	String s2 = new String("1123");
	System.out.println(s1==s2);
	System.out.println(s1.equals(s2));
	}
	
	
}
