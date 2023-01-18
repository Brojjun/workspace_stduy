package com.ssafy.ws.step3;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] light = new int[n+1];
		
		for(int i = 0; i < m; i++) {
			int next = in.nextInt();
			
			for(int j = next; j <= n; j += next) {
				light[j] = (light[j]+1) % 2;
			}
		}
		
		for(int i = 1; i <= n; i++)	System.out.print(light[i]+" ");
		
	}
}
