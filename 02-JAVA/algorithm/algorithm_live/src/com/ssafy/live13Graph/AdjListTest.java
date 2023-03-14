package com.ssafy.live13Graph;

import java.util.Arrays;
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V]; // head가 모두 null인 상태
		int from, to;
		
		for(int i = 0; i < E; i++) {//모두 0으로 초기화된 상태
			from = sc.nextInt();
			to = sc.nextInt();
			//무향그래프
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
			
			
		}
		print();
	}
	private static void print() {
		for(Node node: adjList) {//node : 각 정점의 인접리스트의 head
			System.out.println(node);
		}
		
	}
}
