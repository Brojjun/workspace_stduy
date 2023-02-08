import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] map = new int[N+1];
		for(int i = 1; i <= N; i++) map[i] = Integer.parseInt(st2.nextToken());
		
		//구간합 구하기
		for(int i = 1; i <= N; i++) map[i] = map[i] + map[i-1];
		
		//답	구하기
		for(int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st3.nextToken());
			int end = Integer.parseInt(st3.nextToken());
			//System.out.println(start + " " + end);
			System.out.println(map[end] - map[start-1]);
		}
	}
}
