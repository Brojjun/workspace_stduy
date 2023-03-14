package com.ssafy.off18StudyA;
import java.io.*;
import java.util.*;

public class BOJ17144_미세먼지안녕 {
	
	static int by,bx,time;
	static int[][] map;
	static int[][] vmap;
	static int[][] aircon = new int[2][2];
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		by = Integer.parseInt(st.nextToken());
		bx = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());
		map = new int[by][bx];
		
		boolean flag = false;
		for(int i = 0 ; i < by; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < bx; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && flag) {
					aircon[1][0] = i;
					aircon[1][1] = j;
				}
				else if(map[i][j] == -1 && !flag) {
					aircon[0][0] = i;
					aircon[0][1] = j;
					flag = true;
				}
			}
		}
		
		//게임 스타뜨
		for(int i = 0; i < time; i++) {
			//확산
			vmap = new int[by][bx];
			for(int y = 0 ; y< by; y++) {
				for(int x = 0; x < bx; x++) {
					if(map[y][x] == 0) continue;
					if(map[y][x] == -1)continue;
					division(y, x);
				}
			}
			for(int j = 0 ; j < by; j++)map[j] = vmap[j].clone();
			map[aircon[0][0]][aircon[0][1]] = -1;
			map[aircon[1][0]][aircon[1][1]] = -1;
			vmap = new int[by][bx];
			wind(0);
			wind(1);	
			for(int j = 0 ; j < by; j++)map[j][0] = vmap[j][0];
			for(int j = 0 ; j < by; j++)map[j][bx-1] = vmap[j][bx-1];
			for(int j = 0 ; j < bx; j++)map[0][j] = vmap[0][j];
			for(int j = 0 ; j < bx; j++)map[by-1][j] = vmap[by-1][j];
			
			for(int j = 0 ; j < bx; j++)map[aircon[0][0]][j] = vmap[aircon[0][0]][j];
			for(int j = 0 ; j < bx; j++)map[aircon[1][0]][j] = vmap[aircon[1][0]][j];
			map[aircon[0][0]][aircon[0][1]] = -1;
			map[aircon[1][0]][aircon[1][1]] = -1;
		}
		
		//출력
		int dust = 0;
		for(int i = 0; i < by; i++) for(int j = 0 ; j < bx; j++)dust += map[i][j];
		System.out.println(dust + 2);
	}
	
	
	//dy0~3는 num == 0 일때  + 4~7는 num == 1 일때
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1,0,1,0,-1};
	static int dy2[] = {0,1,0,-1};
	
	private static void wind(int num) {
		int cnt = 0;
		int dir = num * 4;
		
		int y = aircon[num][0];
		int x = aircon[num][1];
		int ny = aircon[num][0] + dy[cnt + dir];
		int nx = aircon[num][1] + dx[cnt];

		while(true) {
			ny += dy[cnt + dir];
			nx += dx[cnt];
			y += dy[cnt + dir];
			x += dx[cnt];
			
			if(ny < 0 || nx < 0 || ny >= by || nx >= bx) {
				ny -= dy[cnt + dir];
				nx -= dx[cnt];		
				cnt = (cnt + 1 ) % 4;
				ny += dy[cnt + dir];
				nx += dx[cnt];
			}
			if(map[ny][nx] == -1)return;
			vmap[ny][nx] = map[y][x];
			
			
		}
	}

	private static void division(int y, int x) {
		int minus = 0;
		for(int i = 0 ; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= by || nx >= bx)continue;
			if(map[ny][nx] == -1)continue;
			vmap[ny][nx] += map[y][x] / 5;
			minus += map[y][x] / 5;
		}
		vmap[y][x] += (map[y][x] - minus);
	}
}
