package com.ssafy.off12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


	


public class BOJ_6987_월드컵 {
	static boolean[] flag = new boolean[4];
	static ArrayList<int[]> arr = new ArrayList<>();

	static boolean visit[] = new boolean[6];
	static int number[] = new int[2];
	static int map[][];
	static int vmap[][];
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makeTeam(0,0);
		for(T = 0; T < 4; T++) {
			map = new int[6][3];
			vmap = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6;i++)for(int j = 0; j < 3;j++)map[i][j]= Integer.parseInt(st.nextToken());
			
			int count = 0;
			for(int i = 0; i < 6;i++)for(int j = 0; j < 3;j++)count += map[i][j];
			if(count == 30)
				playgame(0);
			else
				flag[T] = false;
		}
		for(int i = 0; i < 4; i++) {
			if(flag[i])System.out.print("1 ");
			else System.out.print("0 ");
		}
		
	}
	private static void playgame(int cnt) {
		if(flag[T])return;
		if(!checkEnd()) return;
		if(cnt==arr.size()) {
			flag[T] = true;
			return;	
		}
		
		for(int i = 0; i < 3; i++) {
			int first = arr.get(cnt)[0];
			int second = arr.get(cnt)[1];
			if(i == 0) {
				vmap[first][0]++;
				vmap[second][2]++;
			}
			
			else if(i == 1) {
				vmap[first][1]++;
				vmap[second][1]++;
			}
			
			else if(i == 2) {
				vmap[first][2]++;
				vmap[second][0]++;
			}
			playgame(cnt+1);
			if(i == 0) {
				vmap[first][0]--;
				vmap[second][2]--;
			}
			
			else if(i == 1) {
				vmap[first][1]--;
				vmap[second][1]--;
			}
			
			else if(i == 2) {
				vmap[first][2]--;
				vmap[second][0]--;
			}
		}
		
	}

	
	private static boolean checkClear() {
		for(int i = 0;i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[i][j] == vmap[i][j])continue;
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkEnd() {
		for(int i = 0;i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[i][j] < vmap[i][j])return false;
			}
		}
		return true;
	}
	
	
	private static void makeTeam(int cnt, int start) {
		if(cnt == 2) {
			int[] im = {number[0],number[1]};
			//System.out.println(Arrays.toString(im));
			arr.add(im);
			return;
		}
			
		for(int i = start; i < 6; i++) {
			if(visit[i])continue;
			visit[i] = true;
			number[cnt] = i;
			makeTeam(cnt+1, i+1);
			visit[i] = false;
		}
		
	}
	
}
