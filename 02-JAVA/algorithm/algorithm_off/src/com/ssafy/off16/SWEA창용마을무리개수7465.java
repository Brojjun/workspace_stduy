package com.ssafy.off16;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
	
class soint implements Comparable<Point>{
	int y;
	int x;
	int dis;

	public Point(int y, int x, int dis) {
		super();
		this.y = y;
		this.x = x;
		this.dis = dis;
	}

	@Override
	public int compareTo(Point o) {
		if(this.dis == o.dis) {
			if(this.y == o.y)
				return this.x - o.x;
			return this.y - o.y;
		}
		return this.dis - o.dis;
	}

	
}
	public class SWEA창용마을무리개수7465 {
		static int map[][];
		static int N, time, exp;
		static Point shark;
		static int dx[] = {0,-1,1,0};
		static int dy[] = {-1,0,0,1};
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//input
			N = Integer.parseInt(br.readLine());
			time = 0;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
					if(map[i][j] == 9) shark = new Point(i,j,2);
				}
			}
			
			while(true) {
				int n = moveBfs();
				if(n == 0)break;
				time += n;
				exp++;
				if(exp >= shark.dis) {shark.dis++; exp = 0;}
			}
			System.out.println(time);
		
	}

		private static int moveBfs() {
			PriorityQueue<Point> que = new PriorityQueue<>();
			que.add(new Point(shark.y,shark.x,0));
			boolean visited[][] = new boolean[N][N];
			while(!que.isEmpty()) {
				int y = que.peek().y;
				int x = que.peek().x;
				int d = que.poll().dis;
				if(map[y][x] > 0 && map[y][x] < shark.dis) {
					map[shark.y][shark.x] = 0;
					map[y][x] = 9;
					shark.y = y;
					shark.x = x;
					return d;
				}
				
				for(int i = 0 ; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					int nd = d + 1;
					if(ny < 0 || nx < 0 || ny >= N || nx >= N)continue;
					if(map[ny][nx] > shark.dis || visited[ny][nx])continue;
					visited[ny][nx] = true;
					que.add(new Point(ny,nx,nd));
				}
			}
			return 0;
		}
}
