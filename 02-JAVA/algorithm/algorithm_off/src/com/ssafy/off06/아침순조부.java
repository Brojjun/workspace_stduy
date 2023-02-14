package com.ssafy.off06;

public class 아침순조부 {
	static int N = 5;
	static int M = 4;
	static int[] map;
	static boolean[] visited;
	public static void main(String[] args) {
		map = new int[N];
		visited = new boolean[N];
		System.out.println("순열 : ");
		son(0);
		System.out.println("조합 : ");
		jo(0, 0);
		//System.out.println("반복 부분집합 : ");
		//makeAll_for();
		
		System.out.println("재귀 부분집합 : ");
		makeAll_re(0);
	}

	
	
	private static void makeAll_re(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++)
				System.out.print(visited[i]?i+" " : " ");
			System.out.println();
		}
		
		visited[cnt] = false;
		makeAll_re(cnt+1);
		visited[cnt] = true;
		makeAll_re(cnt+1);
	}



	private static void makeAll_for() {
		for(int i = 0; i < (1 << N); i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {
			if((i & (1 << j)) == 0)continue;
				map[cnt++] = j;
			}
			for(int j = 0; j <= cnt; j++)System.out.print(map[cnt] + " ");
			System.out.println();
			
		}
		
	}



	private static void jo(int cnt, int start) {
				if(cnt == M) {
					for(int i = 0 ; i < M; i++) {
						System.out.print(map[i] + " ");
					}
					System.out.println();
					return;
				}
				
				for(int i = start; i < N; i++) {
					if(visited[i])continue;
					map[cnt] = i;
					visited[i] = true;
					jo(cnt+1, i + 1);
					visited[i] = false;
					map[cnt] = 0;
				}
	}

	private static void son(int cnt) {
		// TODO Auto-generated method stub
		if(cnt == M) {
			for(int i = 0 ; i < M; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i])continue;
			map[cnt] = i;
			visited[i] = true;
			son(cnt+1);
			visited[i] = false;
			map[cnt] = 0;
		}
	}
	
	
}
