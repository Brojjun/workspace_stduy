package com.ssafy.off01;

public class test06 {
	public static void main(String[] args) {
		System.out.println(factorial(5, 5));
		System.out.println(factorial2(5));
		
	}

	private static int factorial(int num, int at) {
		if(at > 0) return factorial(num,at-1) * at;
		return 1;
	}
	
	private static int factorial2(int num) {
		if(num == 1) return 1;
		return factorial2(num-1) * num;
	}
}
