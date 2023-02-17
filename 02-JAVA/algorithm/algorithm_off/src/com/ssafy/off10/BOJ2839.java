package com.ssafy.off10;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.management.monitor.StringMonitorMBean;

class Paper implements Comparable<Paper>{
	int first;
	int second;
	
	public Paper(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Paper o) {
		// TODO Auto-generated method stub
		if(this.first == o.first)
			return this.second - o.second;
		else
			return this.first - o.first;
	}
}

public class BOJ2839 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bn = Integer.parseInt(br.readLine());
		int cnt = Integer.MAX_VALUE;
		int count = 0;
		while(bn > 0) {
			if (bn % 5 == 0) cnt = Math.min(cnt, bn / 5 + count);
			if (bn % 3 == 0) cnt = Math.min(cnt, bn / 3 + count);
			bn -= 5;
			count++;
		}
		if(cnt == Integer.MAX_VALUE) System.out.println(-1);
		else
			System.out.println(cnt);
		
		
		
	}
}


