package com.ssafy.live09;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// nPn만 가능
public class NextPermutation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());

		// 오름차순 천처리
		Arrays.sort(input);

		do {
			System.out.println(Arrays.toString(input));
		} while (np(input));
	}

	private static boolean np(int[] input) {

		int n = input.length;

		// step 1. 꼭대기를 찾는다 (꼭대기 바로 앞이 교환할 자리)
		int i = n - 1;
		while (i > 0 && input[i - 1] >= input[i]) --i; // 
		if (i == 0)return false; // 꼭대기가 없는 경우는 단 한가지 경우 - 4 3 2 1

		// step 2. 꼭대기 바로 앞 (i - 1)자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n - 1;
		while (input[i - 1] >= input[j])
			--j;

		// step 3. 꼭대기 바로 앞 (i - 1)자리와 그 자리값보다 한 단계 큰 자리 (j)와 교환
		swap(input, i - 1, j);

		// step 4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n - 1;
		while (i < k) {
			swap(input, i++, k--);
		}

		return true;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
