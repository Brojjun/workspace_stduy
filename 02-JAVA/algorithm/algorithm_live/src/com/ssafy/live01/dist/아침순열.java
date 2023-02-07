package com.ssafy.live01.dist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 아침순열 {
	
	static int N, R;
	static List <Integer> numbers;
	static List <Integer> arr;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		visited = new boolean[N+2];
		numbers = new ArrayList<>();
		arr = new ArrayList<>();
		for(int i = 0; i < N; i++)arr.add(sc.nextInt());
		
		makeNum();
	}


	private static void makeNum() {
		if(numbers.size() == R) {
			System.out.println(numbers.toString());
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			numbers.add(i);
			visited[i]=true;
			makeNum();
			visited[i]=false;
			numbers.remove(numbers.size()-1);
		}
		
	}


	
	
	
}
