package com.ssafy.off13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int y;
	int x;

	public Point(int x, int y) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class SWEA1247최적경로 {

	static ArrayList<Point> arr = new ArrayList<>();
	static Point me, home;
	static int min_dis, N;
	static boolean visit[];
	static int number[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			//input
			min_dis = Integer.MAX_VALUE;
			arr = new ArrayList<>();
			for(int i = 0; i < N+2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(i==0)me = new Point(x,y);
				else if(i==1)home = new Point(x,y);
				else arr.add(new Point(x,y));
			}
			visit = new boolean[N];
			number = new int[N];
			dfs(0);
			System.out.println("#" + test+ " " + min_dis);
//			//완탐 고객 처리
//				while(!arr.isEmpty()) {
//					int at = -1;
//					int min_dis = Integer.MAX_VALUE;
//					for(int i = 0; i < arr.size(); i++) {
//						int dis = Math.abs(me.x - arr.get(i).x) + Math.abs(me.y - arr.get(i).y);
//						if(min_dis > dis) {
//							min_dis = dis;
//							at = i;
//						}
//					}
//					cnt += min_dis;
//					me.x = arr.get(at).x;
//					me.y = arr.get(at).y;
//					arr.remove(at);
//					
//				}
//				
//				//집가자
//				cnt += Math.abs(me.x - home.x) + Math.abs(me.y - home.y);
				
				
			}
			
		}
	private static void dfs(int cnt) {
		if(cnt == N) {
			Point move = new Point(me.x,me.y);
			int movedis = 0;
			for(int i = 0; i < N; i++) {
				int at = number[i];
				movedis += (Math.abs(move.y - arr.get(at).y) + Math.abs(move.x - arr.get(at).x));
				move.x = arr.get(at).x;
				move.y = arr.get(at).y;
			}
			movedis += (Math.abs(move.y - home.y) + Math.abs(move.x - home.x));
			min_dis = Math.min(min_dis, movedis);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visit[i])continue;
			visit[i] = true;
			number[cnt] = i;
			dfs(cnt+1);
			number[cnt] = 0;
			visit[i] = false;
		}
		
	}

}
