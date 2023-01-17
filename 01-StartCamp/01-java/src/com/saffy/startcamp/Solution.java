package com.saffy.startcamp;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static class People{
		int y=0;
		int x=0;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			People at = new People();
			Queue<People> bfs = new LinkedList();
			char[][] map = new char[18][18];
			
			//input
			for(int i = 0; i<4;i++) {
				for(int j = 0; j<4;j++) {
					map[i][j] = (char)System.in.read();
					if(map[i][j] == 2) {
						at.y=i;
						at.x=j;
					}
				}
			}
			
			System.out.println(map[0][1]);
			//findMap
			/*
			boolean possible = true;
			bfs.add(at);
			while(!bfs.isEmpty() && possible) {
				int nx = bfs.element().x;
				int ny =bfs.element().y;
				bfs.poll();
				for(int i = 0; i<4;i++) {
					int nnx = nx+dx[i];
					int nny = ny+dy[i];
					
					if(nnx < 0 || nny < 0 || nnx >= 16 || nny >= 16) continue;
					if(map[nny][nnx] == '1') continue;
					if(map[nny][nnx] == '3') {
						possible = false;
						while(!bfs.isEmpty()) {
							bfs.poll();
						}
						break;
					}
					People nat = new People();
					nat.x = nnx;
					nat.y = nny;
					bfs.add(nat);
					
				}
			}
			if(!possible) {
				System.out.println("#"+t+" 1");
			}
			else
				System.out.println("#"+t+" 0");
				
			
			
		
		*/
		}
	}
	
}
