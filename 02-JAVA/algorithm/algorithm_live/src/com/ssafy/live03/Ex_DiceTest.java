package com.ssafy.live03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {
	static int N; 
	static int[] numbers;
	static int totcalCnt;
	
	private static void dice1(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			
			dice1(cnt+1);
			
			numbers[cnt] = 0;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		N = sc.nextInt();
		
		numbers = new int[N];
		
		switch (mode) {
		case 1:
			dice1(0);
			break;
		case 2:
			isSelected = new boolean[];
			break;
		}
	
	}
}
