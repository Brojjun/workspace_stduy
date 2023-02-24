package com.ssafy.off15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Cam{
	int y;
	int x;
	int z;
	public Cam(int y, int x, int z) {
		super();
		this.y = y;
		this.x = x;
		this.z = z;
	}
	
}
public class BOJ15683_CCTV {
	
	
	static int by, bx;
	static int[][] map;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {-1,0,1,0};
	static int answer=Integer.MAX_VALUE;
	static int[] number;
	static ArrayList<Cam> cams = new ArrayList<>();
	static int vmap[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		by = Integer.parseInt(st.nextToken());
		bx = Integer.parseInt(st.nextToken());
		map = new int[by][bx];
		
		for(int i = 0 ; i < by; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < bx; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					cams.add(new Cam(i,j,map[i][j]));
				}
			}
		}
		number = new int[cams.size()];
		dfs(0);
		System.out.println(answer);
	}

	private static void dfs(int cnt) {
		if(cnt == cams.size()) {
//			System.out.println();
//			System.out.println(Arrays.toString(number));
//			System.out.println();
			shoot();
			return;
		}
		int z = cams.get(cnt).z;
		int n;
		if(z == 2)n=2;
		else if (z == 5)n=1;
		else n = 4;
		for(int i = 0 ; i < n; i++) {
			number[cnt] = i;
			dfs(cnt+1);
		}
		
	}

	private static void shoot() {
		vmap = new int[by][bx];
		for(int i = 0 ; i < by; i++)
			vmap[i] = Arrays.copyOf(map[i], map[i].length);
		
		for(int i = 0; i < cams.size(); i++) {
			int num = cams.get(i).z;
			int x = cams.get(i).x;
			int y = cams.get(i).y;
			
			if(num == 1) {
				realShoot(y,x,number[i],i);
			}
			
			else if(num == 2) {
				if(number[i] % 2 == 0) {
					realShoot(y, x, 0,i);
					realShoot(y, x, 2,i);
				}
				else if(number[i] % 2 == 1) {
					realShoot(y, x, 1,i);
					realShoot(y, x, 3,i);
				}
			}
			
			else if(num == 3) {
				realShoot(y, x, number[i],i);
				realShoot(y, x, (number[i]+1) % 4,i);
			}

			else if(num == 4) {
				realShoot(y, x, number[i],i);
				realShoot(y, x, (number[i]+3) % 4,i);
				realShoot(y, x, (number[i]+1) % 4,i);
			}
			
			else if(num == 5) {
				for(int j = 0; j < 4; j++)realShoot(y, x, j,i);
			}
			
		}
		int cnt = 0;
		//빈공간수 count
		for(int i = 0 ; i < by; i++) {
			for(int j = 0 ; j < bx; j++) {
				if(vmap[i][j] == 0)cnt++;
			}
		}

//		if(answer > cnt) {
//			
//			for(int i = 0; i < by; i++) {
//				for(int j = 0; j < bx; j++) {
//					System.out.print(vmap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		answer = Math.min(answer, cnt);
	}

	private static void realShoot(int y, int x, int dir,int camera) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];

		while(true) {
			if(ny < 0 || nx < 0 || ny >= by || nx >= bx)break;
			if(vmap[ny][nx] == 6 )break;
			vmap[ny][nx] = -1 * (camera+1);
			ny += dy[dir];
			nx += dx[dir];
		}
		
	}
}
