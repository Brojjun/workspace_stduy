	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.PriorityQueue;
	import java.util.Queue;
	import java.util.Scanner;
	import java.util.StringTokenizer;
	
	public class Solution {
		static class Point {
			int y, x, num;
	
			public Point(int y, int x, int num) {
				super();
				this.y = y;
				this.x = x;
				this.num = num;
			}
		}
	
		static int endPro, endLine;
		static int number[];
		static int map[][];
		static ArrayList<Point> process;
		static int bn;
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
	
			for (int test = 1; test <= T; test++) {
				// �ʱ�ȭ
	
				bn = Integer.parseInt(br.readLine());
				map = new int[bn][bn];
				process = new ArrayList<>();
				endPro = 0;
				endLine = Integer.MAX_VALUE;
	
				int cnt = 0;
				// �Է�
				for (int y = 0; y < bn; y++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for (int x = 0; x < bn; x++) {
						map[y][x] = Integer.parseInt(st.nextToken());
						if (map[y][x] == 1) {
							if (y == 0 || x == 0 || y == bn - 1 || x == bn - 1)
								continue;
							process.add(new Point(y, x, cnt++));
						}
					}
				}
				number = new int[process.size()];
				//check();
	
				dfs(0);
				System.out.println("#" + test + " " + endLine);
			}
	
		}
	
	
		private static void dfs(int cnt) {
			if (cnt == process.size()) {
				calcul();
				return;
			}
	
			for (int i = 0; i < 4; i++) {
				number[cnt] = i;
				dfs(cnt + 1);
			}
		}
	
		static int dx[] = { 0, 0, 1, -1 };
		static int dy[] = { -1, 1, 0, 0 };
	
		private static void calcul() {
			int vmap[][] = new int[bn][bn];
			for (int i = 0; i < bn; i++)
				vmap[i] = map[i].clone();
			int count = 0;
			int count2 = 0;
	
			for (int i = 0; i < process.size(); i++) {
				int dir = number[i];
				int y = process.get(i).y;
				int x = process.get(i).x;
				int cnt = 0;
				boolean flag = false;
				while (true) {
					if (process.size() - i + count2 < endPro)
						return;
					
					y += dy[dir];
					x += dx[dir];
	
					if (y < 0 || x < 0 || y >= bn || x >= bn) {
						flag = true;
						break;
					}
	
					if (vmap[y][x] == 1)
						break;
					cnt++;
					vmap[y][x] = 1;
				}
				if (flag) {
					count++;
					count2 += cnt;
				}
			}
	
			if (endPro <= count) {
				if (endPro == count) {
					endLine = Math.min(endLine, count2);
				} else {
					endPro = count;
					endLine = count2;
				}
			}
		}
	
	}
