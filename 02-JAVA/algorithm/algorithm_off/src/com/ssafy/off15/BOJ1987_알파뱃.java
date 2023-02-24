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


class Point{
	int y;
	int x;
	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}

public class Main {
	
	static int by, bx;
	static String[][] map;
	static HashSet<String> set = new HashSet<>();
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int answer=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		by = Integer.parseInt(st.nextToken());
		bx = Integer.parseInt(st.nextToken());
		map = new String[by][bx];
		for(int i = 0 ; i < by ; i ++) {
			map[i] = br.readLine().split("");
		}
		set.add(map[0][0]);
		dfs(0,0, 1);
		System.out.println(answer);
	}

	private static void dfs(int y, int x,int cnt) {
		answer = Math.max(answer, cnt);
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || nx >= bx || ny >= by)continue;
			String next = map[ny][nx];
			if(set.contains(next)) continue;
			set.add(next);
			dfs(ny,nx, cnt+1);
			set.remove(next);
		}
		
		
		
	}
}
