package com.ssafy.off15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;




public class 정형준_BOJ_1759_암호만들기 {
	static boolean visit[];
	static String[] number;
	static String[] input;
	static int R;
	static int N;
	static ArrayList<String> arr = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		number = new String[R];
		input = new String[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			input[i] = st.nextToken();
		}
		
		dfs(0,0);
		Collections.sort(arr);
		for(int i = 0 ; i < arr.size(); i++)System.out.println(arr.get(i));
	}

	private static void dfs(int cnt, int start) {
		if(cnt == R) {
			int mo = 0;
			int ja = 0;
			for(int i = 0; i < R; i++) {
				if(number[i].equals("a") ||number[i].equals("e") ||number[i].equals("i") ||number[i].equals("o") ||number[i].equals("u"))
					mo++;
				else ja++;
			}
			if(mo < 1 || ja < 2)return;
			String[] imm = number.clone();
			Arrays.sort(imm);
			String dab = "";
			for(int i = 0 ; i < R; i++)dab += (imm[i]);
			arr.add(dab);
			return;
		}
		
		for(int i = start ; i < N; i++) {
			if(visit[i])continue;
			visit[i] = true;
			number[cnt] = input[i];
			dfs(cnt+1,i+1);
			visit[i] = false;
			
		}
	}

}
