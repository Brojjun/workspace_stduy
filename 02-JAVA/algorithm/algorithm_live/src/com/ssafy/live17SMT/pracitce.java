package com.ssafy.live17SMT;

import java.util.Arrays;
import java.util.Scanner;


class Edge{
	int from,to,weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	
}
public class pracitce {
	static int[] number;
	static Edge[] edges;
	static int V,E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		edges = new Edge[E];
		for(int i = 0 ; i < E; i++)edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		Arrays.sort(edges);
		
		make_num();
		
		
	}

	private static int find(int data) {
		if(data == number[data])return data;
		return number[data] = find(number[data]);
	}
	private static void make_num() {
		number = new int[V];
		for(int i = 0 ; i < V; i++)number[i] = i;
		
	}
}
