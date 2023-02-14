package com.ssafy.live03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.*;

	public class Main {

		public static void main(String[] args) throws Exception {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer xy = new StringTokenizer(br.readLine());
			int BY = Integer.parseInt(xy.nextToken());
			int BX = Integer.parseInt(xy.nextToken());
			
			int[][] map = new int[BY][BX];
			
			for(int y = 0; y < BY; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = 0;
				while(st.hasMoreTokens()) {
					int im = Integer.parseInt(st.nextToken());
					map[y][x++] = im;
				}
			}
			
			int minY = 0;
			int minX = 0;
			
			for(int y = 0; y < BY; y++) {
				if(map[minY][0] > map[y][0])
					minY = y;
			}
			
			for(int x = 0; x < BX; x++) {
				minX = Math.min(minX, map[map.length-1][x]);
				if(map[map.length-1][minX] > map[map.length-1][x])
					minX = x;
			}
			
			
			System.out.println((minY+1)+" "+(minX+1));
		}

		
	
	
	
}
