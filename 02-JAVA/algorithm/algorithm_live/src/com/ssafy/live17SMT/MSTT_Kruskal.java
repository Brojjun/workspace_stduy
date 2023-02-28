package com.ssafy.live17SMT;

import java.util.Arrays;
import java.util.Scanner;

public class MSTT_Kruskal {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
		
	}
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	static void makeSet() {
		parents = new int[V];
		for(int i = 0 ; i < V; i++)parents[i]=i;
	}
	
	static int findSet(int data) {
		if(data == parents[data]) return data;
		return parents[data] = findSet(parents[data]);
		
	}
	
	static boolean union(int head, int tail) {
		int headRoot = findSet(head);
		int tailRoot = findSet(tail);
		
		if(headRoot == tailRoot)return false;
		parents[tail] = headRoot;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		edgeList = new Edge[E];
		for(int i = 0 ; i < E; i++) edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		Arrays.sort(edgeList);
		
		makeSet();
		int result = 0, count = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V -1)break;
			}
		}
		System.out.println(result);
		
		
	}
}
