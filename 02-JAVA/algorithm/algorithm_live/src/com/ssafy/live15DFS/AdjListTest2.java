package com.ssafy.live15DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class AdjListTest2 {
	static ArrayList<Integer>[] adjList;
	static int V;
	static int E;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		adjList = new ArrayList[V]; // head가 모두 null인 상태
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		int from, to;

		for (int i = 0; i < E; i++) {// 모두 0으로 초기화된 상태
			from = sc.nextInt();
			to = sc.nextInt();
			// 무향그래프
			adjList[from].add(to);
			adjList[to].add(from);

		}
		// bfs(0);
		dfs(0, new boolean[V]);
		//print();

	}

	private static void dfs(int current, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[current] = true;
		System.out.println((char) (current + 65));
		// 인접행렬확인
		for (int vertex : adjList[current]) {
			if (!visited[vertex]) {
				dfs(vertex, visited);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] visit = new boolean[V];

		que.offer(start);
		while (!que.isEmpty()) {
			int current = que.poll();
			System.out.println((char) (current + 65));

			for (int vertex : adjList[current]) {
				if (!visit[vertex]) {
					que.offer(vertex);
					visit[vertex] = true;
				}
			}
		}

	}

	private static void print() {
		for (ArrayList<Integer> list : adjList) {// node : 각 정점의 인접리스트의 head
			System.out.println(list);
		}

	}
}
