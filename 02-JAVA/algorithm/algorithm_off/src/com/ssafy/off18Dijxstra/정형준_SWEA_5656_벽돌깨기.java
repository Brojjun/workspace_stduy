package com.ssafy.off18Dijxstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 정형준_SWEA_5656_벽돌깨기 {
	static int minCnt;
	static int bn,by,bx;
	static int[][] map;
	static int[][] vmap;
	static int[] number;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			//input
			minCnt = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			bn = Integer.parseInt(st.nextToken());
			bx = Integer.parseInt(st.nextToken());
			by = Integer.parseInt(st.nextToken());
			map = new int[by+1][bx+1];
			number = new int[bn];
			
			for(int i = 0 ; i < by; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < bx; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//순열 생성
			dfs(0);


			System.out.println("#"+test+" "+ minCnt);
		}
		
	}
	
	
	private static void dfs(int cnt) {
		if(cnt == bn) {
			vmap = new int[by+1][bx+1];
			for(int i = 0 ; i <= by; i++)vmap[i] = map[i].clone();
			//생성한 순열로 게임 start
			gamePlay();
			return;
		}
		for(int i = 0 ; i < bx; i++) {
			number[cnt] = i;
			dfs(cnt+1);
		}
		
	}


	private static void gamePlay() {
		for(int i = 0 ; i < bn; i++) {
			boolean flag = false;
			int nx = number[i];
			int ny = 0;
			for(int j = 0 ; j < by; j++) {
				if(vmap[ny][nx] == 0) {ny++;}
				else {flag = true;break;}
			}
			if(flag) {
				gravity();
				boom(ny,nx);
				gravity();
			}
		}
		count();
	}

	private static void count() {
		int cnt = 0;
		for(int i = 0; i < by; i++) {
			for(int j = 0; j < bx; j++) {
				if(vmap[i][j] != 0)cnt++;
			}
		}

		minCnt = Math.min(minCnt, cnt);
	}


	private static void gravity() {
		for(int x = 0; x < bx; x++) {
			ArrayList<Integer> imm = new ArrayList<>();
			for(int y = by-1; y >= 0; y--) {
				if(vmap[y][x] != 0)imm.add(vmap[y][x]);
			}
			int cnt = 0;
			for(int y = by-1; y >= 0; y--) {
				if(cnt >= imm.size())vmap[y][x] = 0;
				else vmap[y][x] = imm.get(cnt++);
			}
			
		}
		
	}

	static int[] dy = {-1,0,0,1};
	static int[] dx = {0,-1,1,0};
	
	private static void boom(int y, int x) {
		if(y < 0 || x < 0 || y >= by || x >= bx) return;
		int range = vmap[y][x] - 1;
		vmap[y][x] = 0;
		if(range <= 0) return;
		
		for(int d = 0; d < 4; d++) {
			int ny = y;
			int nx = x;
			for(int i = 0 ; i < range; i++) {
				ny += dy[d];
				nx += dx[d];
				if(ny < 0 || nx < 0 || ny >= by || nx >= bx)break;
				boom(ny,nx);
			}
			
		}
		
	}
}
