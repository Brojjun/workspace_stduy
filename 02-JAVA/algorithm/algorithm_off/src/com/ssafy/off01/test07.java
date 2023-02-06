package com.ssafy.off01;

import java.util.ArrayList;
import java.util.List;

public class test07 {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		System.out.println(comb(4,3));
	}

	private static int comb(int n, int k) {
		if(n == k || k == 0) return 1;
		return comb(n-1,k-1) + comb(n - 1, k);
	}
}
