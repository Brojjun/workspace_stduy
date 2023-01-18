package com.ssafy.ws.step3;

import java.util.Scanner;

/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTest {

	public static void main(String[] args) throws Exception{
		// 코드를 작성해주세요.
		Scanner in = new Scanner(System.in);
		int test_num = in.nextInt();
		
		for(int test = 0; test < test_num; test++) {
			int max_data = 0;
			int size = in.nextInt();
			String[] imm = new String[size];
			
			in.nextLine(); // 버퍼 비우기.
			//input
			for(int i = 0; i < size; i++) imm[i] = in.nextLine(); 
			char[][] map = new char[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					map[i][j] = imm[i].charAt(j);
				}
			}
			
			int[][] building = new int[size][size];
			
			int dy[] = {-1,-1,0,1,1,1,0,-1};
			int dx[] = {0,1,1,1,0,-1,-1,-1};
			
			int mx[] = {0,0,1,-1};
			int my[] = {1,-1,0,0};
			//빌딩 탐색
			for(int y = 0; y < size; y++) {
				for(int x = 0; x < size; x++) {
					
					//팔방탐색
					boolean check = false;
					for(int k = 0; k < 8; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
						if(map[ny][nx] == 'G') {check = true; break;}
					}
					//if false -> 2
					if(check) building[y][x] = 2;
					//else -> G탐색
					else {
						building[y][x] = 1;
						for(int k = 0; k < 4; k++) {
						int nx = x;
						int ny = y;
						while (true) {
							nx += mx[k];
							ny += my[k];
							if (nx < 0 || ny < 0 || nx >= size || ny >= size)
								break;
							if (map[ny][nx] == 'G')
								break;
							building[y][x]++;
						}
						
						}
					}
					max_data = Math.max(building[y][x], max_data);
				}
			}
			System.out.println("#"+test+" "+ max_data);
		}
		
		
	}
}
