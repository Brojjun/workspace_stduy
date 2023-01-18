package com.ssafy.day03;

import java.util.Random;

class MyRandom extends Random{
	public int nextInt(int num) {
		return super.nextInt(num - 1) + 1;
	}
}

public class Exam04_FinalTest2 {
	public static void main(String[] args) {
		//객체의 형변환  -> 상속관계가 있을때만 가능
		//자식클래스 생성시 부모클래스를 참조하기 때문에 가능 ( 동일하게 object 객체도 참조 )
		Random ran1 = new MyRandom();
		MyRandom ran2 = (MyRandom) ran1;
		
		Random r = new MyRandom(); 
		MyRandom r2 = new MyRandom();
		Object r3 = new MyRandom();
		
		int num = r.nextInt(10) + 1;
		long num2 = 
	}
}
