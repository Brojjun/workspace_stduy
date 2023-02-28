package com.ssafy.off17MST;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 정형준_SWEA_1238_Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test = 1; test <= 10; test++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			
			for(int i = 0 ; i < 101; i++)arr.add(new ArrayList<Integer>());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				 arr.get(from).add(to);
			}
			
			Queue<Integer> que = new LinkedList<Integer>();
			boolean[] visit = new boolean[101];
			int big_num = 0;
			que.add(start);
			while(!que.isEmpty()) {
				big_num = -1;
				ArrayList<Integer> imm = new ArrayList<>();
				
				while(!que.isEmpty()) {
					int now = que.poll();
					visit[now] = true;
					imm.add(now);
				}
				
				for(int i = 0; i < imm.size(); i++) {
					int now = imm.get(i);
					big_num = Math.max(now, big_num);
					for(int j = 0; j < arr.get(now).size();j++) {
						if(visit[arr.get(now).get(j)])continue;
						que.add(arr.get(now).get(j));
					}
				}
				
			}
			
			System.out.println("#" + test + " "+ big_num);
			
			
		}
	}
	
	
}
