package com.ssafy.live09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class permutation {
	static int[] numbers, input;
	static boolean[] visited;
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		input = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
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
