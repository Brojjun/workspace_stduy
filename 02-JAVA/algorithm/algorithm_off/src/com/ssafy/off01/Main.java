package com.ssafy.off01;

import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		int N = 5;
		int M = 3;
		
		for(int i = 0; i < (1 << N); i++) {
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) == 0)continue;
				System.out.print(j+ " ");;
			}
			System.out.println();
		}
	}
		
	
	
}
