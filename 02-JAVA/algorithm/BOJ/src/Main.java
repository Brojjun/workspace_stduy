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

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int by = Integer.parseInt(st.nextToken());
		int bx = Integer.parseInt(st.nextToken());
		String[][] map = new String[by][bx];
		for(int i = 0; i < by; i++) {
			map[i] = br.readLine().split("");
		}
		int cnt1 = 0;
		int cnt2 = 0;
		//화이트
		for(int y = 0; y < by; y++) {
			for(int x = 0; x < bx; x++) {
				if((y+x) % 2 == 0 && map[y][x].equals("B")) cnt1++;
				else if((y+x) % 2 == 1 && map[y][x].equals("W")) cnt1++;
				}
			}
		//블랙
		for(int y = 0; y < by; y++) {
			for(int x = 0; x < bx; x++) {
				if((y+x) % 2 == 0 && map[y][x].equals("W")) cnt2++;
				else if((y+x) % 2 == 1 && map[y][x].equals("B")) cnt2++;
				}
			}
		
		System.out.println(Math.min(cnt1,cnt2));
		
		
		
			
			
		
		
		
	}
}


