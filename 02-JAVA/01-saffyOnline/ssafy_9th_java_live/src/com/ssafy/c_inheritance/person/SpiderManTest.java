// ##DELETE_FILE:
package com.ssafy.c_inheritance.person;

public class SpiderManTest {

	public static void main(String[] args) {
		SpiderMan sman = new SpiderMan();
		sman.eat();
		sman.fireWeb();
		sman.jump();
		sman.isSpider = true;
		sman.fireWeb();
		sman.jump();
	}
}
