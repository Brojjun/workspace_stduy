package com.ssafy.off18StudyA;
import java.io.*;
import java.util.*;

public class BJG5토마토7576 {
	static class Point{
		int h,y,x,day;

		public Point(int h, int y, int x, int day) {
			super();
			this.h = h;
			this.y = y;
			this.x = x;
			this.day = day;
		}
		
		
	}
	static int by,bx,bh, lastDay;
	static int[][][] map;
	static int[][][] vmap;
	static Queue<Point> pq = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bx = Integer.parseInt(st.nextToken());
		by = Integer.parseInt(st.nextToken());
		bh = Integer.parseInt(st.nextToken());
		map = new int[bh][by][bx];
		vmap = new int[bh][by][bx];
		
		for(int h = 0 ; h < bh; h++) {
			for(int y = 0; y < by; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0; x < bx; x++) {
					map[h][y][x] = Integer.parseInt(st.nextToken());
					if(map[h][y][x] == 1)pq.add(new Point(h,y,x,0));
				}
			}
		}
		
		Gobfs();
		System.out.println(check()?lastDay:-1);
		
	}
	
	private static boolean check() {
		for(int h = 0 ; h < bh; h++) {
			for(int y = 0; y < by; y++) {
				for(int x = 0; x < bx; x++) {
					if(map[h][y][x] == 0) return false;
				}
			}
		}
		return true;
	}

	static int dx[] = {0,0,0,0,1,-1};
	static int dy[] = {0,0,1,-1,0,0};
	static int dh[] = {1,-1,0,0,0,0};
	private static void Gobfs() {

		while(!pq.isEmpty()) {
			int h = pq.peek().h;
			int y = pq.peek().y;
			int x = pq.peek().x;
			int day = pq.poll().day;
			for(int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(nh < 0 || nx < 0 || ny < 0 || nh >= bh || ny >= by || nx >= bx) continue;
				if(map[nh][ny][nx] == 1 || map[nh][ny][nx] == -1 || vmap[nh][ny][nx] != 0)continue;
				pq.add(new Point(nh,ny,nx,day+1));
				vmap[nh][ny][nx] = day+1;
				map[nh][ny][nx] = 1;
				lastDay = Math.max(day+1, lastDay);
			}
		}
		
	}
}
