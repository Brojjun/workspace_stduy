package com.ssafy.live04;

import java.util.Scanner;

public class SubsetTest {

	static int N, S, totalCnt;
	static int[] input;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt(); // 목표합
		input = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		subset(0);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			totalCnt++;

			int number = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i])
					number += input[i];
			}
			if (number == S) {
				for (int i = 0; i < N; i++) {
					System.out.print((visited[i] ? input[i] : "X") + "\t");
				}
				System.out.println();
			}
			return;
		}

		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}
}
