package com.ssafy.off07;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 정형준_SWEA_9229_한빈이와SpotMart {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer NM = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(NM.nextToken());
			int m = Integer.parseInt(NM.nextToken());
			int map[] = new int[n];
			StringTokenizer data = new StringTokenizer(br.readLine());
			
			int cnt = 0;
			while(data.hasMoreTokens())map[cnt++] = Integer.parseInt(data.nextToken());
			
			//for(int i = 0; i <n;i++)System.out.print(map[i] + " ");
			Arrays.sort(map);
			
			int p1 = 0;
			int p2 = n-1;
			
			int result = -1;
			while(p1 < p2) {
				int sum = map[p1] + map[p2];
				
				if(sum <= m) {
					result = Math.max(result, sum);
					p1++;
				}else {
					p2--;
				}
			}
			
			System.out.println("#"+t +" " + result);
			
		}
	
		
		
	}



	

}