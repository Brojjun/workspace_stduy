package com.ssafy.off12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int start;

	public Point(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	int end;

	@Override
	public int compareTo(Point o) {
		if (this.end == o.end)
			return this.start - o.start;
		return this.end - o.end;
	}

}

public class 정형준_BOJ_1992_쿼드트리 {

	static int N;
	static int map[][];
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}

		dfs(0, 0, N);

		System.out.println(sb.toString());
	}

	private static void dfs(int by, int bx, int n) {
		int now = map[by][bx];

		if (n == 0) {
			sb.append(now);
			return;
		}

		boolean flag = false;
		outerloop: 
		for (int y = by; y < by + n; y++) {
			for (int x = bx; x < bx + n; x++) {
				if (map[y][x] != now) {
					flag = true;
					break outerloop;
				}

			}
		}

		if (!flag) {
			sb.append(now);
			return;
		} 
		else {
			sb.append("(");
			dfs(by, bx, n / 2);
			dfs(by, bx + (n/2), n / 2);
			dfs(by + (n/2), bx, n / 2);
			dfs(by+ (n/2), bx+ (n/2), n / 2);
			
			sb.append(")");
		}
	}

}
