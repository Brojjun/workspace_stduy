package com.ssafy.live14BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjmatrixTest {
	static int V;
	static int E;
	
	static int[][] adjmatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjmatrix = new int[V][V];
		int from, to;
		
		for(int i = 0; i < E; i++) {//모두 0으로 초기화된 상태
			from = sc.nextInt();
			to = sc.nextInt();
			adjmatrix[from][to] = 1;
			adjmatrix[to][from] = 1;
		}
		bfs(0);
		print();
		
	}
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[]visit = new boolean[V];
		
		que.offer(start);
		while(!que.isEmpty()) {
			int current = que.poll();
			System.out.println((char)(current+65));
			for(int i = 0; i < V; i++) {
				if(adjmatrix[current][i] != 0 && !visit[i]) {
					que.offer(i);
					visit[i] = true;
				}
			}
		}
		
		
	}
	private static void print() {
		for(int[] am : adjmatrix) {
			System.out.println(Arrays.toString(am));
		}
		
	}
	
	
}
