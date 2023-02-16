package com.ssafy.off08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class 정형준_BOJ_2563_색종이 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		boolean[][] map = new boolean[101][101];
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//System.out.println(y+" "+x);
			for(int ny = y; ny < y+10; ny++) {
				for(int nx = x; nx < x+10; nx++) {
					map[100-ny][nx] = true;
				}
			}
			
		}
		
//		for(int ny = 1; ny <= 100; ny++) {
//			for(int nx = 1; nx <= 100; nx++) {
//				if(map[ny][nx])System.out.print("X");
//				else System.out.print("O");
//			}
//		System.out.println();
//		}
				
		int cnt = 0;
		for(int ny = 1; ny <= 100; ny++) 
			for(int nx = 1; nx <= 100; nx++) 
				if(map[ny][nx])cnt++;
		
		System.out.println(cnt);
	}
}
