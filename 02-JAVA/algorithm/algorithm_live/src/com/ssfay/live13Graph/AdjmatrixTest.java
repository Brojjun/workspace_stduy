package com.ssfay.live13Graph;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjmatrixTest {
	
	static int[][] adjmatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjmatrix = new int[V][V];
		int from, to;
		
		for(int i = 0; i < E; i++) {//모두 0으로 초기화된 상태
			from = sc.nextInt();
			to = sc.nextInt();
			adjmatrix[from][to] = 1;
			adjmatrix[to][from] = 1;
		}
		print();
	}
	private static void print() {
		for(int[] am : adjmatrix) {
			System.out.println(Arrays.toString(am));
		}
		
	}
}
