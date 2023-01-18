import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 시간계산
		 * 완탐 기준 : 500 * 500 * 256
		 * 6400만->가능
		 * 시간초과
		 * 최적화... 어디까지...
		 * 이진탐색인가?
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] yxbag = br.readLine().split(" ");
		int by = Integer.parseInt(yxbag[0]);
		int bx = Integer.parseInt(yxbag[1]);
		int bag = Integer.parseInt(yxbag[2]);
		
		int[][] map = new int[by][bx];
		
		int startPoint = Integer.MAX_VALUE;
		int endPoint = Integer.MIN_VALUE;
		
		for(int y = 0; y < by; y++) {
			String[] xmap = br.readLine().split(" ");
			for(int x = 0; x < bx; x++) { 
			map[y][x] = Integer.parseInt(xmap[x]);
			startPoint = Math.min(startPoint, map[y][x]);
			endPoint = Math.max(endPoint, map[y][x]);
			}
		}
		
		int min_time = Integer.MAX_VALUE;
		int height = 0;
	
		
		for(int t = startPoint; t <= endPoint; t++) {
			int virtual_bag = bag;
			int time = 0;
			
			for(int y = 0; y < by; y++) {
				for(int x = 0; x < bx; x++) {
					int immTime = Math.abs(map[y][x] - t);
					//땅파기
					if(map[y][x] > t) {
						time += immTime * 2;
						virtual_bag += immTime;
					}						
					//땅쌓기
					else {
						time += immTime;
						virtual_bag -= immTime;
					}
				}
			}
			if(virtual_bag >= 0 && min_time >= time) {
				min_time = time;
				height = t;
			}
			else 
				break;
		}
		System.out.println(min_time+" "+height);
}
}