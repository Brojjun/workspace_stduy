package com.saffy.startcamp;

import java.util.Arrays;

public class test05_multi_array {

	public static void main(String[] args) {
		
		int[]a1 = {1};
		int[]a2 = {2,3};
		int[]a3 = {4,5,6};
		int[][] arr1 = {a1,a2,a3};
		int[][] arr2 = {{1},{2,3},{4,5,6}};
		
		System.out.println(Arrays.deepToString(arr2));
		
		//
	}
}
