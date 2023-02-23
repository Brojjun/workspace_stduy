package com.ssafy.off13;
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

class Point implements Comparable<Point>{
	int y;
	int x;
	int dis;
	public Point(int x, int y, int dis) {
		super();
		this.y = y;
		this.x = x;
		this.dis = dis;
	}
	@Override
	public int compareTo(Point o) {
		if(o.dis == this.dis)
			return this.x - o.x;
		return this.dis - o.dis;
	}
}

public class BOJ17135캐슬파이트 {
	
	static int Y, X, D; // 격자 크기 + 사정거리
	static int max_kill;
	static boolean visit[];
	static int[] numbers = new int[3];
	static int[][] map;
	static int dx[] = {-1,0,0,1};
	static int dy[] = {0,1,-1,0};
	static int peopleNum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[Y+1][X];
		visit = new boolean[X];
		peopleNum = 0;
		
		for(int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < Y; i++)for(int j = 0; j < X; j++)if(map[i][j] == 1)peopleNum++;
		dfs(0,0);
		System.out.println(max_kill);
	}

	private static void dfs(int cnt, int start) {
		if(cnt == 3) {
			//System.out.println(Arrays.toString(numbers));
			playgame();
			return;
		}
		for(int i = start ; i < X; i++) {
			if(visit[i])continue;
			visit[i] = true;
			numbers[cnt] = i;
			dfs(cnt+1, i+1);
			visit[i] = false;
		}
	
	}

	private static void playgame() {
		int now_cnt = 0;
		int live = peopleNum;
		int[][] vmap = new int[Y+1][X];
		for(int i = 0; i < Y; i++) {
			for(int j = 0; j < X; j++) {
				vmap[i][j] = map[i][j];
			}
		}
		
		while(live > 0) {
			//죽이고
			ArrayList<Point> kxy = new ArrayList<>();
			outerloop:
			for(int i = 0; i < 3; i++) {
				PriorityQueue<Point> que = new PriorityQueue<>();
				que.add(new Point(numbers[i],Y,0));
				while(!que.isEmpty() && que.peek().dis <= D) {
					int xx = que.peek().x;
					int yy = que.peek().y;
					int distance = que.peek().dis;
					
					if(vmap[yy][xx] == 1) {
						kxy.add(new Point(xx,yy,0));
						continue outerloop;
					}
					
					if(distance > D)break;
					que.poll();
					for(int j = 0; j < 4; j++) {
						int nx = xx + dx[j];
						int ny = yy + dy[j];
						int nd = distance + 1;
						if(ny < 0 || nx < 0 || ny >= Y || nx >= X)continue;
						if(nd > D)break;

						que.add(new Point(nx,ny,nd));
					}
				}
			}
			
			Collections.sort(kxy);
			int im = kxy.size()-1;
			while(im >= 1) {
				if(kxy.get(im).x == kxy.get(im-1).x && kxy.get(im).y == kxy.get(im-1).y) {
					kxy.remove(im);
				}
				im--;
			}
			
			//kill
			for(int i = 0; i < kxy.size(); i++) {
				vmap[kxy.get(i).y][kxy.get(i).x] = 0;
				live--;
				now_cnt++;
			}
			//move
			for(int i = 0; i < X; i++) {
				if(vmap[Y-1][i] == 1) {
					live--;
					vmap[Y-1][i] = 0;
				}
			}
			for(int i = Y-1; i > 0;i--) {
				for(int j = 0; j < X; j++) {
					vmap[i][j] = vmap[i-1][j];
				}
			}
			for(int i = 0; i < X; i++)vmap[0][i] = 0;
			
		}
		max_kill = Math.max(now_cnt, max_kill);
		
	}

}
