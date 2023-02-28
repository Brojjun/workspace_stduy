package com.ssafy.live16UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Node{
	int data;
	Node next;
	Node represent;
	
	public Node(int data, Node next, Node represent) {
		super();
		this.data = data;
		this.next = next;
		this.represent = represent;
	}
	
	
}
public class UnionFind {
	static int N;
	static int[] P;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = new int[N];
		
		//make - 집합 생성
		makeSet();
		System.out.println(Arrays.toString(P));
		
		//union - 집합 합치기
		
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(P));
		System.out.println(union(1,3));
		System.out.println(Arrays.toString(P));
		System.out.println(union(1,4));
		System.out.println(Arrays.toString(P));
		System.out.println(union(1,5));
		System.out.println(Arrays.toString(P));
	}

	private static boolean union(int head, int tail) {
		int headRoot = find(head);
		int tailRoot = find(tail);
		if(headRoot==tailRoot)return false;
		P[tailRoot] = headRoot;
		return true;
	}

	private static int find(int data) {
		if(data == P[data]) return data;
		else return P[data] = find(data);
	}

	private static void makeSet() {
	for(int i = 0 ; i < N; i++)P[i] = i;
}
}
