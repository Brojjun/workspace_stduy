package com.ssafy.off11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


	


public class BOJ_1920 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++)map[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		int[] output = new int[N];
		Arrays.sort(map);
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		//for(int i = 0 ; i < N; i++)System.out.print(map[i] + " ");
		
		for(int i = 0; i < M; i++) {
			int imm = Arrays.binarySearch(map, Integer.parseInt(st2.nextToken()));
			System.out.println(imm >= 0?"1":"0");
		}
	
		
		
		
	}
}
