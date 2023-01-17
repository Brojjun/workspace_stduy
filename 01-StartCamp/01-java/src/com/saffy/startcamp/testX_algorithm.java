package com.saffy.startcamp;

import java.util.Arrays;
import java.util.Scanner;

public class testX_algorithm {
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in); 
		
		
		int test_num = in.nextInt();
		
		outerLoop: for (int t = 1; t <= test_num; t++) 
		{
			
			int[][] map = new int[10][10];

			for (int i = 1; i <= 9; i++)
				for (int j = 1; j <= 9; j++)
					map[i][j] = in.nextInt();

			// 가로 체크
			for (int i = 1; i <= 9; i++) {
				boolean[] check = new boolean[10];
				for (int j = 1; j <= 9; j++) {
					int imm_num = map[i][j];
					if (check[imm_num]) {
						System.out.println("#"+test_num+" 1");
						continue outerLoop;
					} else {
						check[imm_num] = true;
					}
				}
			}
			
			//세로체크
			for (int i = 1; i <= 9; i++) {
				boolean[] check = new boolean[10];
				for (int j = 1; j <= 9; j++) {
					int imm_num = map[j][i];
					if (check[imm_num]) {
						System.out.println("#"+test_num+" 1");
						continue outerLoop;
					} else check[imm_num] = true;
					
				}
			}
			
			//칸 체크
			for (int i = 1; i <= 9; i+=3) {
				for (int j = 1; j <= 9; j+=3) {
					boolean[] check = new boolean[10];
					for(int y = i;y<=i+2;y++) {
						for(int x = j; x<=j+2;x++) {
							int imm_num = map[y][x];
							if (check[imm_num]) {
								System.out.println("#"+test_num+" 1");
								continue outerLoop;
							} 
							else check[imm_num] = true;
							
						}
					}
					
				}
				
			}
			
			System.out.println("#"+test_num+" 1");
		}
		
		
		
	}
}
