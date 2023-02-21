package com.ssafy.off12;

import java.util.Scanner;

public class SWEA_모의역량_2115_벌꿀채취 {
	static int N, M, C, ans; // 통크기, 선택벌통수, 꿀의최대양, 테케정답
	static int[][] map, profit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			profit = new int[N][N];
			
			for(int i = 0; i < N; i++)for(int j = 0; j < N; j++)map[i][j] = sc.nextInt();
			
			setProfit(); // 각 좌표당 최대 이익
			setPosition(); // 조합의 자리 결정
			
			System.out.println("#" + t + " " + ans);
			ans = 0;
		}
	}
	private static void setPosition() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//일꾼 1의 위치
				for(int k = j+M; k < N - M; k++) 
					ans = Math.max(ans, profit[i][j] + profit[i][k]);
			
				
				for(int y = i+1; y < N; y++) {
					for(int x = 0; x < N; x++) {
						ans = Math.max(ans, profit[i][j] + profit[y][x]);
					}
				}
			}
		}
		
	}
	private static void setProfit() {
		for(int i = 0; i < N; i++)for(int j = 0; j <= N - M; j++) setMaxProfit(i,j,0,0,0);
		
	}
	private static void setMaxProfit(int y, int x, int cnt, int cSum, int pSum) {
		if(cSum > C)return;
		if(cnt == M) {
			profit[y][x - M] = Math.max(profit[y][x-M], pSum);
			return;
		}
		
		setMaxProfit(y, x+1, cnt+1, cSum, pSum); //선택하지 않음
		setMaxProfit(y, x+1, cnt+1, cSum + map[y][x], pSum + (map[y][x] * map[y][x])); //선택하지 않음
		
	}
}
