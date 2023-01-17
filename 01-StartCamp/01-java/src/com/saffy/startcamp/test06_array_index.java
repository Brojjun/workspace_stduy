package com.saffy.startcamp;

import java.util.Arrays;

public class test06_array_index {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		
		for(int i =0; i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		// foreach
		for(int v : arr) {
			System.out.println(v);
			
			
		}
		
//		System.out.println(Arrays.deeptoString(arr));
		System.out.println(Arrays.toString(arr));

		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		Arrays.stream(arr).forEach(v->System.out.print(v));
	}
}
