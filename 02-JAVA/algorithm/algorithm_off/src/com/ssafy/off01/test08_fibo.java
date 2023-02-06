package com.ssafy.off01;

public class test08_fibo {
	static long[] memo = new long[10000000];
	static int cnt = 0;	
	public static void main(String[] args) {

		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibo(5000));
		System.out.println(cnt);
	}

	private static long fibo(int num) {
		cnt++;
		if(memo[num] == 0 && num > 0) memo[num] = fibo(num-1) + fibo(num-2);
		return memo[num];
	}
}
