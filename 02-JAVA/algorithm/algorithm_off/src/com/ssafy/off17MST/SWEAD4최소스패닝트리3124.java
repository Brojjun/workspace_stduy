package com.ssafy.off17MST;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEAD4최소스패닝트리3124 {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}
	
	static int V,E,T;
	static Edge[] edges;
	static int[] numbers;
	
	private static void make_num() {
		numbers = new int[V+1];
		for(int i = 0 ; i <= V; i++)numbers[i] = i;
	}
	private static int find(int data) {
		if(data == numbers[data])return data;
		return numbers[data] = find(numbers[data]);
	}
	private static boolean union(int head, int tail) {
		int headRoot = find(head);
		int tailRoot = find(tail);
		if(headRoot == tailRoot)return false;
		numbers[tailRoot] = headRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int test = 1; test <= T; test++) 
		{
			V = sc.nextInt();
			E = sc.nextInt();
			edges = new Edge[E];
			for(int i = 0 ; i < E; i++)edges[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
			
			Arrays.sort(edges);

			make_num();
			long ans = 0;
			int cnt = 0;
			for(Edge edge : edges) {
				if(union(edge.from,edge.to)) {
					ans += edge.weight;
					if(++cnt == V-1)break;
				}
			}
			System.out.println("#" + test+" " + ans);
		}
	}
}
