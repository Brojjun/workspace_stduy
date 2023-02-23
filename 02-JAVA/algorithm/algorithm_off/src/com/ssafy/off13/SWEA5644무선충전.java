package com.ssafy.off13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Data {
	int data;
	int at;

	public Data(int data, int at) {
		super();
		this.data = data;
		this.at = at;
	}

}

class Point {
	int y;
	int x;
	int dis;

	public Point(int y, int x, int dis) {
		super();
		this.y = y;
		this.x = x;
		this.dis = dis;
	}

}

public class SWEA5644무선충전 {
	static int pN, mN;
	static int dir1[], dir2[];
	static int map[][][];
	static int max_charge;

	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };
	static ArrayList<Data> arr1;
	static ArrayList<Data> arr2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pN = Integer.parseInt(st.nextToken());
			mN = Integer.parseInt(st.nextToken());
			dir1 = new int[pN];
			dir2 = new int[pN];
			map = new int[11][11][mN];
			max_charge = 0;

			st = new StringTokenizer(br.readLine());// 사용자 A input
			for (int i = 0; i < pN; i++)
				dir1[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());// 사용자 B input
			for (int i = 0; i < pN; i++)
				dir2[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < mN; i++) {
				// 초기화 및 input
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				Queue<Point> que = new LinkedList<Point>();
				que.add(new Point(y, x, 0));
				map[y][x][i] = power;
				// 배터리 영역 체크
				while (!que.isEmpty() && que.peek().dis < range) {
					int xx = que.peek().x;
					int yy = que.peek().y;
					int distance = que.poll().dis;
					if (distance > range)
						break;
					for (int k = 1; k < 5; k++) {
						int nx = xx + dx[k];
						int ny = yy + dy[k];
						int nd = distance + 1;
						if (nd > range)
							break;
						if (ny <= 0 || nx <= 0 || ny > 10 || nx > 10)
							continue;
						map[ny][nx][i] = power;
						que.add(new Point(ny, nx, nd));
					}
				}

			}

			int n1x = 1;
			int n1y = 1;
			int n2x = 10;
			int n2y = 10;
			// move
			for (int m = 0; m <= pN; m++) {
				arr1 = new ArrayList<>();
				arr2 = new ArrayList<>();
				boolean flag = false; // 사람이 한 영역에 겹치는 경우

				int charge1 = 0;
				int charge2 = 0;

				for (int i = 0; i < mN; i++) {
					if (map[n1y][n1x][i] > 0 && map[n2y][n2x][i] > 0) {
						arr1.add(new Data(map[n1y][n1x][i], i));
						arr2.add(new Data(map[n2y][n2x][i], i));

						flag = true;
					} else {
						if (map[n1y][n1x][i] > 0)
							arr1.add(new Data(map[n1y][n1x][i], i));
						if (map[n2y][n2x][i] > 0)
							arr2.add(new Data(map[n2y][n2x][i], i));
					}
				}

				// 3번 둘다 겹치는 경우 --> 조합을 이용해 최대값 탐색
				if (flag && (arr1.size() > 1 || arr2.size() > 1)) {
					for (int i = 0; i < arr1.size(); i++) {
						Data first = arr1.get(i);
						if (charge1 == 0)
							charge1 = first.data;
						for (int j = 0; j < arr2.size(); j++) {
							Data second = arr2.get(j);
							if (first.at == second.at)
								continue;
							if (charge1 + charge2 < first.data + second.data) {
								charge1 = first.data;
								charge2 = second.data;
							}
						}
					}
				}

				// 2번 두 사람이 한 영역만 겹치는 경우 --> 한 영역에 두사람이 겹치니깐 2/1씩 ㄱㄱ
				else if (flag && arr1.size() == 1 && arr2.size() == 1) {
					charge1 = arr1.get(0).data / 2;
					charge2 = arr1.get(0).data / 2;
				}

				else {
					// 1번 사람이 두 영역에 걸쳐있는 경우
					if (arr1.size() >= 1) {
						for (int j = 0; j < arr1.size(); j++)
							charge1 = Math.max(charge1, arr1.get(j).data);
					}

					// 2번 한 사람이 두 영역에 걸쳐있는 경우
					if (arr2.size() >= 1) {
						for (int j = 0; j < arr2.size(); j++)
							charge2 = Math.max(charge2, arr2.get(j).data);
					}

				}
				max_charge += charge1 + charge2;
				if (m >= pN) {
					break;
				}
				n1x += dx[dir1[m]];
				n1y += dy[dir1[m]];
				n2x += dx[dir2[m]];
				n2y += dy[dir2[m]];

			}
			System.out.println("#"+t+" "+max_charge);
		}
		
	}

}
