package com.ssafy.off15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
	int y;
	int x;
	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
	
}

public class BOJ10026_적록색약 {
	static int bn;
	static int nomal = 0, NRG = 0;
	static String map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bn = Integer.parseInt(br.readLine());
		map = new String[bn][bn];
		for(int i = 0 ; i < bn; i++) {
			map[i] = br.readLine().split("");
		}


		nomal = bfs();
		
		for(int i = 0 ; i < bn; i++) {
			for(int j = 0 ; j < bn; j++) {
				if(map[i][j].equals("R"))map[i][j] = "G";
			}
		}
		
		NRG = bfs();
		System.out.println(nomal +" "+ NRG);
	}

	static private int bfs() {
		int cnt = 0;
		int []dx = {1,-1,0,0};
		int []dy = {0,0,1,-1};
		boolean[][] visit = new boolean[bn][bn];
		for(int y = 0 ; y < bn; y++) {
			for(int x = 0; x < bn; x++) {
				if(visit[y][x])continue;
				cnt++;
				String now = map[y][x];
				Queue<Point> que = new LinkedList<Point>();
				que.add(new Point(y,x));
				
				while(!que.isEmpty()) {
					int yy = que.peek().y;
					int xx = que.poll().x;
					
					for(int i = 0 ; i < 4; i++) {
						int ny = yy + dy[i];
						int nx = xx + dx[i];
						if(ny < 0 || nx < 0 || ny >= bn || nx >= bn)continue;
						if(visit[ny][nx] || !map[ny][nx].equals(now))continue;
						visit[ny][nx]=true;
						que.add(new Point(ny,nx));
					}
				}
			}
		}
		return cnt;
	}

}
