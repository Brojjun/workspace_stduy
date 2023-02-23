package com.ssfay.live13Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjListTest2 {
	static ArrayList<Integer>[] adjList;
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new ArrayList[V]; // head가 모두 null인 상태
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		
		for(int i = 0; i < E; i++) {//모두 0으로 초기화된 상태
			from = sc.nextInt();
			to = sc.nextInt();
			//무향그래프
			adjList[from].add(to);
			adjList[to].add(from);
			
			
		}
		print();
	}
	private static void print() {
		for(ArrayList<Integer> list : adjList) {//node : 각 정점의 인접리스트의 head
			System.out.println(list);
		}
		
	}
}
