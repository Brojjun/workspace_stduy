package com.ssafy.off08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ16935 {
	static int Y;
	static int X;
	static int T;
	static int map[][];
	static int game[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// input XYZ
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		game = new int[T];
		// input Array
		for (int i = 0; i < Y; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}


		// input Play
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++)
			game[i] = Integer.parseInt(st3.nextToken());

		for (int i = 0; i < T; i++) {
			if (game[i] == 1) upDown();
			else if (game[i] == 2) leftRight();
			else if (game[i] == 3) right90();
			else if (game[i] == 4) left90();
			else if (game[i] == 5) shareGo();
			else if (game[i] == 6) shareReverse();
		}
		
		visual();
	}

	private static void shareReverse() {
		int vmap[][] = new int[Y][X];
		int ny = Y / 2;
		int nx = X / 2;
		//1번
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				vmap[y][x] = map[y][x+nx];
			}
		}
		//2번
		for (int y = 0; y < ny; y++) {
			for (int x = nx; x < X; x++) {
				vmap[y][x] = map[y+ny][x];
			}
		}
		//3번
		for (int y = ny; y < Y; y++) {
			for (int x = 0; x < nx; x++) {
				vmap[y][x] = map[y-ny][x];
			}
		}
		//4번
		for (int y = ny; y < Y; y++) {
			for (int x = nx; x < X; x++) {
				vmap[y][x] = map[y][x-nx];
			}
		}
		map = vmap;
		
	}

	private static void shareGo() {
		int vmap[][] = new int[Y][X];
		int ny = Y / 2;
		int nx = X / 2;
		//1번
		for (int y = 0; y < ny; y++) {
			for (int x = 0; x < nx; x++) {
				vmap[y][x] = map[y+ny][x];
			}
		}
		//2번
		for (int y = 0; y < ny; y++) {
			for (int x = nx; x < X; x++) {
				vmap[y][x] = map[y][x-nx];
			}
		}
		//3번
		for (int y = ny; y < Y; y++) {
			for (int x = 0; x < nx; x++) {
				vmap[y][x] = map[y][x+nx];
			}
		}
		//4번
		for (int y = ny; y < Y; y++) {
			for (int x = nx; x < X; x++) {
				vmap[y][x] = map[y-ny][x];
			}
		}
		map = vmap;
	}

	private static void left90() {
		int vmap[][] = new int[X][Y];
		int im = Y;
		Y = X;
		X = im;
		
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				vmap[y][x] = map[x][Y - y - 1];
			}
		}
		map = vmap;
		
		
	}

	private static void right90() {
		int vmap[][] = new int[X][Y];
		int im = Y;
		Y = X;
		X = im;
		
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				vmap[y][x] = map[X - x - 1][y];
			}
		}
		map = vmap;
		
	}

	private static void leftRight() {
		int vmap[][] = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				vmap[y][x] = map[y][X - x - 1];
			}
		}
		map = vmap;

	}

	

	private static void visual() {
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				System.out.print(map[y][x] + " ");
			}
			System.out.println();
		}

	}

	private static void upDown() {
		int vmap[][] = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				vmap[y][x] = map[Y - y - 1][x];
			}
		}
		map = vmap;

	}
}
