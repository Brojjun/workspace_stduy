package com.ssafy.off08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Point{
	int y;
	int x;
	int time = 0;
	public Point(int y, int x,int time) {
		super();
		this.y = y;
		this.x = x;
		this.time = time;
	}
}

public class BOJ2178 {
	static int by;
	static int bx;
	static boolean visited[][];
	static char map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer yx = new StringTokenizer(br.readLine());
		
		by = Integer.parseInt(yx.nextToken());
		bx = Integer.parseInt(yx.nextToken());
		map = new char[by][bx];
		visited = new boolean[by][bx];
		
		for(int y = 0; y < by; y++) {
			String im = br.readLine();
			for(int x = 0; x < bx; x++) {
				map[y][x] = im.charAt(x);
			}
		}
		
		
		go();
	}

	private static void go() {
		Queue<Point> arr = new LinkedList<Point>();
		arr.add(new Point(0,0,1));
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		int dir = 0;
		
		while(!arr.isEmpty()) {
			int y = arr.peek().y;
			int x = arr.peek().x;
			int nt = arr.peek().time;
			arr.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny < 0 || nx < 0 || ny >= by || nx >= bx)continue;
				else if(visited[ny][nx] || map[ny][nx]=='0')continue;
				if(ny == by-1 && nx == bx-1) {
					System.out.println(nt+1);
					return;
				}
				visited[ny][nx] = true;
				arr.add(new Point(ny,nx,nt+1));
			}
		}
		
	}
}
