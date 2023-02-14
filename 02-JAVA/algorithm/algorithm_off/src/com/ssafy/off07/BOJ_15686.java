package com.ssafy.off07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Point{
	int y;
	int x;
	int store[] = new int[101];
	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	

}

public class BOJ_15686 {
	
	static int map[][];
	static Point[] chick = new Point[14];
	static Point[] home = new Point[101];
	static int N;
	static int M;
	static int homecnt = 0;
	static int chickencnt = 0;
	static boolean[] visited;
	static ArrayList<Point> dfs = new ArrayList<>();
	static int min_data = Integer.MAX_VALUE;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static void input() throws NumberFormatException, IOException {
		StringTokenizer nm = new StringTokenizer(br.readLine());
		N = Integer.parseInt(nm.nextToken());
		M = Integer.parseInt(nm.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//System.out.print(map[i][j]+ " ");
				if(map[i][j] == 1) home[homecnt++] = new Point(i,j);
				else if(map[i][j] == 2) chick[chickencnt++] = new Point(i,j); 
			}
			//System.out.println();
		}
		
		visited = new boolean[chickencnt];
	}
	
	static void distance() {
		for(int i = 0; i < chickencnt; i++) {
			Point im = chick[i];
			for(int j = 0; j < homecnt; j++) {
				im.store[j] = Math.abs(im.y - home[j].y) + Math.abs(im.x - home[j].x);
				//System.out.print(im.store[j]+ " ");
			}
			chick[i] = im;
			
		}
	}
	
	
	static void dfs(int start) {
		if(dfs.size() == M) {
			//for(int i = 0; i <M;i++)System.out.print(dfs.get(i).y + "," + dfs.get(i).x + "   ");
			//System.out.println();
			int min_v = 0;
			
			for(int i = 0; i < homecnt; i++) {
				int data = Integer.MAX_VALUE;
				for(int j = 0; j < M; j++) {
					
					data = Math.min(data, dfs.get(j).store[i]);
				}
				min_v += data;
				
			}
			min_data = Math.min(min_data,min_v);
			return;
		}
		
		for(int i = start; i < chickencnt; i++) {
			if(visited[i])continue;
			visited[i] = true;
			dfs.add(chick[i]);
			dfs(i+1);
			dfs.remove(dfs.size()-1);
			visited[i] = false;
		}
	};
	public static void main(String[] args) throws IOException {
			input();
			distance();
			dfs(0);
			System.out.println(min_data);
	}
}
