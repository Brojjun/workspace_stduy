package com.saffy.startcamp;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 *  9조 빙고 게임 입니다. 
 */
public class test07_binggo {
	
	public static int sizeOfMap = 5;
	public static int[][] people = new int[sizeOfMap+1][sizeOfMap+1];
	public static int[][] computer = new int[sizeOfMap+1][sizeOfMap+1];

	
	public static int[][] make_map(int n) {
		Random r = new Random();
		int[][] map = new int[n][n];
		int[] check = new int[n*n+2];
		int k = 0;
		
		for(int i = 1; i<(n*n+1);i++) check[i] = i;
		
		for(int i = 0;i < n; i++) {
			for(int j = 0; j<n; j++) {
				int number = r.nextInt(n*n - k) + 1;
				map[i][j] = check[number];
				check[number] = check[n*n-k];
				check[n*n-k] = map[i][j];
				k++;				
			}
		}
		
		return map;
	}
	
	//입력 숫자 제거
	public static void del_map(int n) {
		for(int i = 0; i<sizeOfMap;i++) {
			for(int j = 0; j<sizeOfMap;j++) {
				if(people[i][j] == n)
					people[i][j] = -1;
				
				if(computer[i][j] == n)
					computer[i][j] = -1;
			}
		}
	}
	
	//visual
	public static void print_map() {
		for(int i = 0; i<sizeOfMap;i++) {
			for(int j = 0; j<sizeOfMap;j++) {
				if(people[i][j] == -1)System.out.print("x   ");
				else if(people[i][j] > 9)System.out.print(people[i][j]+"  ");
				else System.out.print(people[i][j]+"   ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	// false-> playing, true -> win
	// 빙고는 빙고에 해당하는 칸을 중복해서 계산해야 하기 때문에 bfs는 힘들다고 판단하여 완전탐색 사용
	public static int check_people_over() {
		int n = 0;
		
		//가로
		for(int i = 0; i<sizeOfMap;i++) {
			int cnt = 0;
			for(int j = 0; j<sizeOfMap;j++) {
				if(people[i][j] == -1) cnt++;
			}
			if(cnt == sizeOfMap)n++;
		}
	
		//세로
		for(int i = 0; i<sizeOfMap;i++) {
			int cnt = 0;
			for(int j = 0; j<sizeOfMap;j++) {
				if(people[j][i] == -1) cnt++;
			}
			if(cnt == sizeOfMap)n++;
		}
	
		//대각
		int cnt = 0;
		for(int i = 0; i<sizeOfMap;i++) 
			if(people[i][i] == -1) cnt++;
		if(cnt == sizeOfMap)n++;
				
		cnt = 0;
		
		for(int i = 0; i<sizeOfMap;i++) 
			if(people[sizeOfMap - i-1][sizeOfMap - i-1] == -1) cnt++;
		if(cnt == sizeOfMap)n++;
		
		return n;
	}
	
	
	public static int check_computer_over() {
		int n = 0;
		//가로
		for(int i = 0; i<sizeOfMap;i++) {
			int cnt = 0;
			for(int j = 0; j<sizeOfMap;j++) {
				if(computer[i][j] == -1) cnt++;
			}
			if(cnt == sizeOfMap)n++;
		}
		//세로
		for(int i = 0; i<sizeOfMap;i++) {
			int cnt = 0;
			for(int j = 0; j<sizeOfMap;j++) {
				if(computer[j][i] == -1) cnt++;
			}
			if(cnt == sizeOfMap)n++;
		}
		
		//대각
		int cnt = 0;
		for(int i = 0; i<sizeOfMap;i++) 
			if(computer[i][i] == -1) cnt++;
		if(cnt == sizeOfMap)n++;
		
		cnt = 0;
		for(int i = 0; i<sizeOfMap;i++) 
			if(computer[sizeOfMap - i-1][sizeOfMap - i - 1] == -1) cnt++;
		if(cnt == sizeOfMap)n++;
		
		return n;
	}
	
	
	
	public static int computer_calcul_number() {
		int k = 1;
		int[] all_num = new int[(sizeOfMap * sizeOfMap) + 10];
		
		
		for(int i = 0; i<sizeOfMap;i++) {
			for(int j = 0; j<sizeOfMap;j++) {
				if(computer[i][j] == -1) continue;
				all_num[k] = computer[i][j];
				k++;
			}
		}
		
		Random r = new Random();
		int n = r.nextInt(k);
		return n;	
	}
	
	
	public static void main(String[] args) {
		//make map
		people = make_map(sizeOfMap);
		computer = make_map(sizeOfMap);
	
		System.out.println(Arrays.deepToString(people));

		Scanner scanner = new Scanner(System.in);
		System.out.println("1번 : 혼자하기  // 2번 : 컴퓨터와 대결");
		int game_number = scanner.nextInt();

		if(game_number == 1) {
			while (true) {
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n사용자 빙고 번호");
				print_map();
				System.out.print("빙고 번호를 입력하세요 : ");
				int people_number = scanner.nextInt();

				// 플레이어 턴
				del_map(people_number);
				if (check_people_over() >= sizeOfMap) {
					System.out.println("게임 종료!! \n 게임 종료 ");
					break;
				}


			}
			
		}
		if (game_number == 2) {
			while (true) {
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n사용자 빙고 번호");
				print_map();
				System.out.print("빙고 번호를 입력하세요 : ");
				int people_number = scanner.nextInt();
				int computer_number = computer_calcul_number();

				// 플레이어 턴
				del_map(people_number);
				if (check_people_over() >= sizeOfMap) {
					System.out.println("사용자 승리!! \n 게임 종료 ");
					break;
				}

				if (check_computer_over() >= sizeOfMap) {
					System.out.println("사용자 승리!! \n 게임 종료 ");
					break;
				}

				// 컴퓨터 턴
				del_map(computer_number);
				if (check_people_over() >= sizeOfMap) {
					System.out.println("사용자 승리!! \n 게임 종료 ");
					break;
				}
				if (check_computer_over() >= sizeOfMap) {
					System.out.println("컴퓨터 승리!! \n 게임 종료 ");
					break;
				}

			}
		}
		
	}
}
