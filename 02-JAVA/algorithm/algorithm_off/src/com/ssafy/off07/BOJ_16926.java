package com.ssafy.off07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ_16926 {
	

	static ArrayList<ArrayList<Integer>> arr;
	static int M;
	static int N;
	static int R;
	static int [][]map;
	static int [][]vmap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		
		map = new int[N][M];
		vmap = new int[N][M];
	
		for(int i = 0 ;i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		makeList(0,0,0);
		makeMap(0,0,0);
		for(int i = 0 ;i < N; i++) {
			
			for(int j = 0; j < M; j++) {
				System.out.print(vmap[i][j] + " ");
			}
			if(i == N-1)break;
			System.out.println();
		}
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	private static void makeList(int y, int x, int n) {
		if(M/2 <= n || N/2 <= n)return;
		int dir = 0;
		int ny = y;
		int nx = x;
		ArrayList<Integer> imm = new ArrayList<>();
		int cnt = 1;
		while(dir <= 3) {
			
			//vmap[ny][nx] = cnt++;
			imm.add(map[ny][nx]);
			if(ny+dy[dir] >= N-n || ny +dy[dir] < 0+n) { dir++;}
			else if(nx + dx[dir] >= M-n || nx + dx[dir] < 0+n) {dir++;}
			
			
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			if(ny == y && nx == x)break;
		}
		arr.add(imm);
		makeList(y+1,x+1,n+1);
	}
	
	private static void makeMap(int y, int x, int n) {
		ArrayList<Integer> imm = arr.get(n);

		
		if(M/2 <= n || N/2 <= n)return;
		int dir = 0;
		int ny = y;
		int nx = x;
	
		int cnt = R % imm.size();;
		while(dir <= 3) {
			
			//vmap[ny][nx] = cnt++;
			vmap[ny][nx] = imm.get(cnt++);
			if(cnt >= imm.size())cnt=0;
			imm.add(map[ny][nx]);
			if(ny+dy[dir] >= N-n || ny +dy[dir] < 0+n) { dir++;}
			else if(nx + dx[dir] >= M-n || nx + dx[dir] < 0+n) {dir++;}
			
			
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			if(ny == y && nx == x)break;
		}
		arr.add(imm);
		makeMap(y+1,x+1,n+1);
	}
}
