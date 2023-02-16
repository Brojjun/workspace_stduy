package com.ssafy.off08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Point{
	int y;
	int x;
	int num;
	int time;
	
	public Point(int y, int x, int time, int num) {
		super();
		this.y = y;
		this.x = x;
		this.time = time;
		this.num = num;
	}
}
public class SWEA1861 {
	static int N;
	static int at = -1;
	static int map[][];

	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		
	
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			input();
			
			
			int dab = bfs();
			System.out.println("#"+t+" "+at+" "+dab);
		
		
	}


	}

	private static int bfs() {
		int cnt = 0;
	
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				Queue<Point> que = new LinkedList<Point>();
				que.add(new Point(i,j,1,map[i][j]));
				
				while(!que.isEmpty()) {
					int y = que.peek().y;
					int x = que.peek().x;
					int nt = que.peek().time+1;
					int number = que.peek().num;
					que.poll();
					for(int d = 0 ; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
						
						if(map[ny][nx] != number+1) continue;
						
						if(cnt <= nt) {
							if(cnt == nt) {
								at = Math.min(at,map[i][j]);
							}
							else {
								at = map[i][j];
								cnt = nt;
							}
						}
						cnt = Math.max(cnt, nt);
						
						que.add(new Point(ny,nx,nt,map[ny][nx]));					
					}
				}
			}
		}
		
		return cnt;
	}

	private static void input() throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	

}