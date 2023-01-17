package com.saffy.startcamp;

import java.util.Arrays;
import java.util.Random;

public class test08_rotto {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(lotto4()));
	}
	
	static int[] lotto2() {
		Random r = new Random();
		int[] lotto_num = new int[6];
		boolean[] used = new boolean[46];
		

		
		
		for(int i = 0; i<6; i++) {
			int num = r.nextInt(45) + 1;
			
			if(used[num]) {i--;continue;}
				
			used[num] = true;
			lotto_num[i] = num;
		}
		
		return lotto_num;
	}
	
	
	static int[] lotto3() {
		Random r = new Random();
		int[] lotto_num = new int[6];
		int[] numbers = new int[46];
		
		boolean[] used = new boolean[46];
		for(int i = 1; i<numbers.length;i++) {
			numbers[i] = i;
		}

		for(int i = 0; i<1000;i++) {
			int n = r.nextInt(45) + 1;
			int tmp = numbers[1];
			numbers[1] = n;
			numbers[n] = tmp;
		}
		
		for(int i = 0 ; i<6;i++) {
			lotto_num[i] = numbers[i];
			
		}
		
		
		return lotto_num;
	}
	static int[] lotto4() {
		Random r = new Random();
		int[] lotto_num = new int[6];
		int[] numbers = new int[46];
		
		for(int i = 1; i<numbers.length;i++) {
			numbers[i] = i;
		}

		for(int i = 0 ; i<6;i++) {
			int n = r.nextInt(45-i) + 1;
			lotto_num[i] = n;
			int tmp = numbers[45-i];
			numbers[45-i] = n;
			numbers[n] = tmp;
			
		}
		
		return lotto_num;
		
		
	}
	
}
