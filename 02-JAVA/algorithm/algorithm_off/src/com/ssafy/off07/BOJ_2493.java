package com.ssafy.off07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int high;
	int at;
	public Point(int high, int at) {
		super();
		this.high = high;
		this.at = at;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.high - o.high;
	}
}

public class BOJ_2493 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Point> arr = new Stack<>();
		arr.push(new Point(Integer.MAX_VALUE, -1));
	
		int map[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) 
			map[i] = Integer.parseInt(st.nextToken());
			
		int visualMap[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			Point now = new Point(map[i],i);
			Point past = arr.peek();
			
			if(past.high < now.high) {
				while(past.high < now.high) {
					arr.pop();
					past = arr.peek();
				}
				visualMap[i] = past.at + 1;
				arr.push(now);
			}
			else {
				visualMap[i] = past.at + 1;
				arr.push(now);
			}
		}
					
		for(int i = 0; i < N; i++)System.out.print(visualMap[i]+" ");		
				
			
		
		
	
	}
}
