package com.ssafy.live15DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjListTest {
	
	static class Node{
		int vertex;
		Node link;
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
	static Node[] adjList;
	static int V;
	static int E;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new Node[V]; // head가 모두 null인 상태
		int from, to;
		
		for(int i = 0; i < E; i++) {//모두 0으로 초기화된 상태
			from = sc.nextInt();
			to = sc.nextInt();
			//무향그래프
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
			
			
		}
		//bfs(0);
		dfs(0, new boolean[V]);
		print();
		
	}
	
	
	private static void dfs(int current, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[current] = true;
		System.out.println((char)(current+65));
		//인접행렬확인
		for(Node temp = adjList[current]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex,visited);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[]visit = new boolean[V];
		
		que.offer(start);
		while(!que.isEmpty()) {
			int current = que.poll();
			System.out.println((char)(current+65));
			for(Node temp = adjList[current]; temp != null; temp = temp.link){
				if(!visit[temp.vertex]) {
					que.offer(temp.vertex);
					visit[temp.vertex] = true;
				}
			}
		}
		
	}
	private static void print() {
		for(Node node: adjList) {//node : 각 정점의 인접리스트의 head
			System.out.println(node);
		}
		
	}
}
