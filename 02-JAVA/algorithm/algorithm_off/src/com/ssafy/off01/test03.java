package com.ssafy.off01;

public class test03 {
	public static void main(String[] args) {
		
		
		System.out.println("반복 : " + solve1(10) );
		
		System.out.println("재귀 : " + solve2(10,0));
	}

	private static int solve1(int num) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			System.out.printf(i +" + ");
			sum += i;
			
		}
		return sum;
	}
	
	private static int solve2(int num, int sum) {
		// TODO Auto-generated method stub
		if(num < 1) return sum;
		System.out.printf(num + " + ");
		return solve2(num-1, sum+num);
	}


}
