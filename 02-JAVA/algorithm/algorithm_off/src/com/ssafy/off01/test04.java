package com.ssafy.off01;

public class test04 {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		System.out.println(solve(arr.length, arr));
	}

	private static int solve(int len, int[] arr) {
		// TODO Auto-generated method stub
		if(len <= 0) return 0;
		return arr[len-1] + solve(len-1,arr);
	}
}
