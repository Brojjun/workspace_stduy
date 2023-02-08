package com.ssafy.live01.dist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 아침순열 {
	static int[] numbers;
	static boolean[] visited;
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		visited = new boolean[N];
		
		makeNum(0,0);
	}

	private static void makeNum(int cnt,int start) {
		// TODO Auto-generated method stub
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = start; i < N; i++) {
			if(visited[i])continue;
			//visited[i] = true;
			numbers[cnt] = i;
			makeNum(cnt+1,i+1);
			numbers[cnt] = 0;
			//visited[i] = false;
		}
		
	}

}
