package com.ssafy.off05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class People{
	public int num;
	public int cnt;
	
	public People(int num, int cnt) {
		super();
		this.num = num;
		this.cnt = cnt;
	}
}
public class 마이쮸 {
	public static void main(String[] args) {
		Queue<People> q = new LinkedList<>();
		Scanner sc = new Scanner("1 1 2 1 3 2 4 1 5 3 6 2");
		
		int cookie = 20;
		
		
		int[] man = {1,1,1,1,1,1};
		
		while(sc.hasNext()) {
			int a = sc.nextInt();
			q.offer(new People(a, man[a-1]));
			man[a - 1]++;
		}
		
		int day = 1;
		while(!q.isEmpty()) {
			System.out.println((day++) + "일차 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			People im = q.poll();
			
			cookie -= im.cnt;
			if(cookie <= 0) System.out.println(im.num+"이 마지막 쿠키를 먹었습니다.");
			else System.out.println(im.num + "번이 " + im.cnt + "만큼 가져갑니다." + "   남은 수 : " + cookie);
		
		}
	}
}
