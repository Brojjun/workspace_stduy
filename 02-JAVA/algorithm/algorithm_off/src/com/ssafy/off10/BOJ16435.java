package com.ssafy.off10;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ16435 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int snake = sc.nextInt();
		PriorityQueue<Integer> arr = new PriorityQueue<>();
		
		for(int i = 0 ; i < T; i++) {
			arr.add(sc.nextInt());
		}
		
		while(!arr.isEmpty()) {
			int im = arr.poll();
			if(im <= snake)snake++;
		}
		System.out.println(snake);
	}
	
	
}
