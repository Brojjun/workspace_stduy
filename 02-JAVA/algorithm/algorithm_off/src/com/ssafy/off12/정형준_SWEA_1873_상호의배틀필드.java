package com.ssafy.off12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Car{
	int y;
	public Car(int y, int x, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
	int x;
	int dir;
}
public class 정형준_SWEA_1873_상호의배틀필드 {
	static int by, bx, bc, answer;
	static String[][] map;
	static String[] move;
	static Car me;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			//input + 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			by = Integer.parseInt(st.nextToken());
			bx = Integer.parseInt(st.nextToken());
			answer = 0;
			map = new String[by][bx];
			for(int i = 0; i < by; i++) map[i] = br.readLine().split("");
				
			bc = Integer.parseInt(br.readLine());
			move = br.readLine().split("");
				
			//전차 탐색
			outerloop:
			for(int i = 0; i < by; i++) {
				for(int j = 0; j < bx; j++) {
					if(map[i][j].equals("^")) {me = new Car(i,j,0); break outerloop;}
					if(map[i][j].equals(">")) {me = new Car(i,j,1);	break outerloop;}
					if(map[i][j].equals("v")) {me = new Car(i,j,2);	break outerloop;}
					if(map[i][j].equals("<")) {me = new Car(i,j,3);	break outerloop;}
				}
			}
			
			for(int i = 0; i < bc; i++) {
				int dir = -1;
				if(move[i].equals("U"))dir = 0;
				if(move[i].equals("R"))dir = 1;
				if(move[i].equals("D"))dir = 2;
				if(move[i].equals("L"))dir = 3;
				if(move[i].equals("S"))dir = 4;
				
				if(dir < 4) move(dir);
				else shoot();
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < by; i++) {
				for(int j = 0; j < bx; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}

	private static void shoot() {
		int nx = me.x;
		int ny = me.y;
		int ndir = me.dir;
		
		while(true) {
			nx += dx[ndir];
			ny += dy[ndir];
			if(ny < 0 || nx < 0 || ny >= by || nx >= bx)return;
			if(map[ny][nx].equals("*")) {
				map[ny][nx] = ".";
				return;
			}
			else if(map[ny][nx].equals("#"))return;
			
		}
		
	}

	private static void move(int dir) {
		int nx = me.x + dx[dir];
		int ny = me.y + dy[dir];
		me.dir = dir;
		if(dir == 0)map[me.y][me.x] = "^";
		if(dir == 1)map[me.y][me.x] = ">";
		if(dir == 2)map[me.y][me.x] = "v";
		if(dir == 3)map[me.y][me.x] = "<";
		
		if(nx < 0 || ny < 0 || nx >= bx || ny >= by)return;
		if(map[ny][nx].equals("#") || map[ny][nx].equals("*") || map[ny][nx].equals("-")) return;
		map[me.y][me.x] = ".";
		if(dir == 0)map[ny][nx] = "^";
		if(dir == 1)map[ny][nx] = ">";
		if(dir == 2)map[ny][nx] = "v";
		if(dir == 3)map[ny][nx] = "<";
		me.x = nx;
		me.y = ny;
		
		
	}
}

