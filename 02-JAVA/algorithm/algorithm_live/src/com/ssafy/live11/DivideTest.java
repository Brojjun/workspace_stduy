package com.ssafy.live11;

import java.util.Scanner;

public class DivideTest {

	public static int cnt1,cnt2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(exp1(x,n));
		System.out.println(cnt1);
		System.out.println(exp2(x,n));
		System.out.println(cnt2);
	}

	private static long exp1(int x, int n) {
		cnt1++;
		if(n == 1) return x;
		return x * exp1(x, n	-1);
	}
	
	private static long exp2(int x, int n) {
		cnt2++;
		if(n==1)return x;
		long y = exp2(x, n / 2);

		return n % 2 == 0 ? y * y : y * y * x;
	}
}
