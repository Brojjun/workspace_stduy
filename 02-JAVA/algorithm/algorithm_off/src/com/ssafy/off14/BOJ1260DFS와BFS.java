package com.ssafy.off14;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class BOJ1260DFS와BFS {
	
	static int bv, bl, start;
	static boolean svisit[],bvisit[];
	static ArrayList<Integer>[] sarr,barr;
	static StringBuffer sbst = new StringBuffer();
	static StringBuffer bbst = new StringBuffer();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		bv = Integer.parseInt(st.nextToken());
		bl = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		sarr = new ArrayList[bv+1];
		barr = new ArrayList[bv+1];
		
		svisit = new boolean[bv+1];
		bvisit = new boolean[bv+1];
		for(int i = 0; i < bv+1; i++) {
			barr[i] = new ArrayList<>();
			sarr[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < bl; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			sarr[from].add(to);
			sarr[to].add(from);
			barr[from].add(to);
			barr[to].add(from);
		}
		for(int i = 0; i < bv+1; i++) {
			Collections.sort(barr[i]);
			Collections.sort(sarr[i]);

		}
		
		dfs(start);
		
		StringBuffer bbst = new StringBuffer();
		//bfs
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(bvisit[now])continue;
			bvisit[now] = true;
			bbst.append(now + " ");
			for(int i = 0; i < barr[now].size(); i++) {
				int imm = barr[now].get(i);
				if(!bvisit[imm])
					queue.add(imm);
				
			}
			
		}
		System.out.println(sbst.toString());
		System.out.println(bbst.toString());
		
		
	}

	private static void dfs(int now) {
		sbst.append(now + " ");
		svisit[now] = true;
		for(int i = 0; i < sarr[now].size(); i++) {
			if(!svisit[sarr[now].get(i)])
				dfs(sarr[now].get(i));
		}
		
	}
	

}
