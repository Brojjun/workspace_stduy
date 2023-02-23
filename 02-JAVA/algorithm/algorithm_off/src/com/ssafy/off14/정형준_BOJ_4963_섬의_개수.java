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
import java.util.StringTokenizer;



class Point {
	int y;
	int x;
	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}
public class 정형준_BOJ_4963_섬의_개수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dx[] = { 0, 1,1,1,0,-1,-1,-1};
		int dy[] = {-1,-1,0,1,1, 1, 0, 1};
		StringBuffer sb = new StringBuffer();
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x == 0 && y == 0)break;
			int map[][] = new int[y][x];
			boolean visit[][] = new boolean[y][x];
			
			for(int i = 0; i < y; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < x; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < y; i++) {
				for(int j = 0; j < x; j++) {
					if(visit[i][j])continue;
					if(map[i][j] == 0)continue;
					cnt++;
					Queue<Point> que = new LinkedList<>();
					que.add(new Point(i,j));
					
					while(!que.isEmpty()) {
						int xx = que.peek().x;
						int yy = que.poll().y;
						for(int d = 0; d < 8; d++) {
							int nx = xx + dx[d];
							int ny = yy + dy[d];
							if(nx < 0 || ny < 0 || nx >= x || ny >= y)continue;
							if(visit[ny][nx]) continue;
							if(map[ny][nx] == 0)continue;
							visit[ny][nx] = true;
							que.add(new Point(ny,nx));
						}
					}
					
				}
			}
			sb.append(cnt + "\n");
			
			
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb.toString());
	}
	

}
