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


	


public class BOJ_1074 {
	public static int cnt;
	public static int size;
	public static int by;
	public static int bx;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		by = sc.nextInt();
		bx= sc.nextInt();
		
		size = 1 << n;
		makeMap(0,0,size);

	}

	private static void makeMap(int y, int x, int size) {
		if(y == by && x == bx) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		else if(size==1) {
			cnt++;
			return;
		}
		
		else if((bx > x + size || bx < x)  && (by > y +size || by < y)) {
			cnt+= size*size;
			return;
		}
		
	
		makeMap(y,x, size / 2);
		makeMap(y,x + size / 2, size / 2);
		makeMap(y + size / 2,x, size / 2);
		makeMap(y + size / 2,x + size / 2, size / 2);

	}
}
