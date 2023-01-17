package com.saffy.startcamp;

import java.util.Scanner;

public class algorithm {
	public static int[][] memo = new int[25][1000];
	public static int bn=0;
	public static int bc=0;
	public static int max = 0;
	public static int[] score = new int[25];
	public static int[] calori = new int[25];
	
	public static void input() {
		Scanner in = new Scanner(System.in);
		bn = in.nextInt();
		bc = in.nextInt();
		for(int i = 0; i <bn; i++) {
			score[i] = in.nextInt();
			calori[i] = in.nextInt();
		}
	}
	
	public static void clear() {
		bn = 0;
		max = 0;
		for(int i = 0; i <bn; i++) {
			score[i] = 0;
			calori[i] = 0;
		}
		
		for(int i = 0; i <1000; i++) 
			for(int j = 0 ; j<1000;j++)
				memo[i][j] = 0;
	}
	
	//브루트포스로 다 조진다. dp 할줄 모름 ㅠㅠ
	//n은 칼로리, dfs를 위한 다음 순번
	public static void bf(int n, int i) {
		//if로 최대 칼로리 max()처리
		
		//재귀로 순열방식으로 햄버거 부품 호출
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int time = in.nextInt();
			
		for(int t = 1; t<=time;t++) 
		{
			input();			
			bf(0,0);
			clear();
		}
		
	}
}
