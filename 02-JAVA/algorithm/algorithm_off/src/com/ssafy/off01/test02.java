package com.ssafy.off01;

public class test02 {

	public static void main(String[] args) {
		System.out.println("반복");
		int number = 10;
		solve1(number, number);
		System.out.println();
		System.out.println("재귀");
		solve2(number);
	}

	private static void solve2(int num) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= num; i++)
			System.out.printf(i + " ");
	}

	private static void solve1(int start, int num) {
		// TODO Auto-generated method stub
		if(num <= 0)
			return;
		System.out.printf(start - num +1 + " ");
		solve1(start, num-1);
	}
}
