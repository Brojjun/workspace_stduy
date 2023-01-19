package com.ssafy.ws.step3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTest {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int test_num = in.nextInt();
		
		for(int test = 1; test <= test_num; test++) {
			int max_data = 0;
			int size = in.nextInt();
			String[] imm = new String[size];
			
			in.nextLine(); // 버퍼 비우기.
			//input
			for(int i = 0; i < size; i++) imm[i] = in.nextLine(); 
			
			int[][] building = new int[size+1][size+1];
			
			int dy[] = {-1,-1, 0, 1, 1, 1,  0, -1};
			int dx[] = {0,  1, 1, 1, 0, -1,-1, -1};
			
			int[][] mapp = new int[7][7];
			for(int i = 0; i < 8; i++) {
				int xx = 3 + dx[i];
				int yy = 3 + dy[i];
				mapp[yy][xx] = 1;
			}

			int mx[] = {0, 0, 1,-1};
			int my[] = {1,-1, 0, 0};
			
			boolean[][] check = new boolean[size][size];
			System.out.println(Arrays.deepToString(check));
			//빌딩 탐색
			for(int y = 0; y < size; y++) {
				for(int x = 0; x < size; x++) {
					
					//팔방탐색
					
					for(int k = 0; k < 8; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
						if(imm[ny].charAt(nx) == 'G' || imm[ny].charAt(nx) == 'G') {
							check[y][x] = true;
						}
					}
					
					// if true -> 2
					if (check[y][x]) {
						building[y][x] = 1;
						for (int k = 0; k < 4; k++) {
							int nx = x;
							int ny = y;
							while (true) {
								nx += mx[k];
								ny += my[k];
								if (nx < 0 || ny < 0 || nx >= size || ny >= size)
									break;
								if (imm[ny].charAt(nx) == 'B')
									building[y][x] += 1;
							}
						}
					}
					// else -> G탐색
					else 
						building[y][x] = 2;
							

					max_data = Math.max(building[y][x], max_data);	
					}
					
				}
			
			System.out.println(Arrays.deepToString(check));
			}
			
			
		
		
		
	}
}
