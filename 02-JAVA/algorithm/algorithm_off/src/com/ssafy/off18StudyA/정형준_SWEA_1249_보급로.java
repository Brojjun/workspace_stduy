package com.ssafy.off18StudyA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 정형준_SWEA_1249_보급로 {
	static class Point implements Comparable<Point>{
		int y,x,num;

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.num - o.num;
		}

		public Point(int y, int x, int num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}
		
	}
	static int bn;
	static int[][] map;
	static int[][] vmap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			bn = Integer.parseInt(br.readLine());
			map = new int[bn+1][bn+1];
			String[][] imm = new String[bn+1][bn+1];
			vmap = new int[bn+1][bn+1];
			for(int i = 0 ; i < bn ;i++)
				Arrays.fill(vmap[i], Integer.MAX_VALUE);
			
			for(int i = 0 ; i < bn; i++) {
				imm[i] = br.readLine().split("");
				for(int j = 0; j < bn; j++)
					map[i][j] = Integer.parseInt(imm[i][j]);
			}
			
			dijkstra();
			System.out.println("#" + test+" "+vmap[bn-1][bn-1]);
		}
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	private static void dijkstra() {
		PriorityQueue<Point>pq = new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		
		while(!pq.isEmpty()) {
			int yy = pq.peek().y;
			int xx = pq.peek().x;
			int now = pq.poll().num;
			
			for(int i = 0; i < 4; i++) {
				int ny = yy + dy[i];
				int nx = xx + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= bn || nx >= bn)continue;
				int next = now + map[ny][nx];
				if(vmap[ny][nx] > next || vmap[ny][nx] == Integer.MAX_VALUE) {
					vmap[ny][nx] = next;
					
					pq.add(new Point(ny,nx,next));
				}
			}
		}	
		
	}
}
