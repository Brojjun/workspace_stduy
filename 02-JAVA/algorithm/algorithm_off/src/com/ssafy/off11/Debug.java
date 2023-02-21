package com.ssafy.off11;

public class Debug {
	static int sum;
	static int[][] map = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16},
			{17,18,19,20},
			{21,22,23,24},
			
	};
	public static void main(String[] args) {
		debug();
		call2();
		for(int i = 0 ; i < map.length; i++) {
			for(int j = 0; j < map[0].length ;j++) {
				sum += map[i][j];
			}
		}
	}

	private static void debug() {
		// TODO Auto-generated method stub
		call(10);
		System.out.println(sum);
	}

	private static void call2() {
		int a = 100;
		a += 10;
		a += 30;
		System.out.println(a);
	}
	private static void call(int n) {
		if(n==0)return;
		sum +=n;
		call(n-1);
		
	}
}
