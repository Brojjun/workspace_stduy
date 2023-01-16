package com.saffy.day1;

public class ArrayTest {
	static int N = 3;
	static int M = 3;
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				
			};
		
	
	//exam01(arr);
	//exam02(arr);
	//exam03(arr);
	exam04(arr);
	}
	
	//지그재그 순회
	private static void exam04(int[][] arr) {
		// TODO Auto-generated method stub
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < M; x++) {
				System.out.print(arr[y][x + (M - x - x - 1) * ( y % 2 )]+" ");
		
			}
			System.out.println();
		}
	}

	//열 우선순회
	private static void exam03(int[][] arr) {
		// TODO Auto-generated method stub
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
	}
	
	//행 역순회
	private static void exam02(int[][] arr) {
		// TODO Auto-generated method stub
		for(int y = 0; y < N; y++) {
			for(int x = M-1; x >= 0; x--) {
				System.out.print(arr[y][x]+" ");
			}
			System.out.println();
		}
	}

	//행 우선순회
	private static void exam01(int[][] arr) {
		// TODO Auto-generated method stub
		for(int y =0; y<arr.length;y++) {
			for(int x = 0; x<arr[y].length;x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
	}
}
