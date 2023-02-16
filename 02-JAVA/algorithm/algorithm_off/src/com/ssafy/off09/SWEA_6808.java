package com.ssafy.off09;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SWEA_6808 {

	static int fr[];
	static int me[];
	static boolean[] visit;
	static int[] d;

	static int fWin = 0;
	static int Mwin = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());

		for (int T = 1; T <= test; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			fWin = 0;
			Mwin = 0;
			fr = new int[9];
			me = new int[9];
			visit = new boolean[9];
			for (int i = 0; i < 9; i++)
				fr[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(fr);

			int frat = 0;
			int meat = 0;
			for (int i = 1; i <= 18; i++) {
				if (frat < 9)
					if (fr[frat] == i) {
						frat++;
						continue;
					}
				
				if (meat >= 9)
					break;
				me[meat++] = i;
			}


		
		d = new int[9];
		dfs(0);
		System.out.println("#" + T + " " + fWin + " " + Mwin);

		}

	}

	private static void dfs(int cnt) {
		if (cnt == 9) {
			gameSet();
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			d[cnt] = i;
			dfs(cnt + 1);
			d[cnt] = 0;
			visit[i] = false;
		}
	}

	private static void gameSet() {
		int fs = 0;
		int ms = 0;
		for (int i = 0; i < 9; i++) {
			if (me[d[i]] > fr[i])
				ms += (me[d[i]] + fr[i]);
			else if (me[d[i]] < fr[i])
				fs += (fr[i] + me[d[i]]);
			
		}
		if (fs > ms)
			fWin++;
		else if (fs < ms)
			Mwin++;
	}

}