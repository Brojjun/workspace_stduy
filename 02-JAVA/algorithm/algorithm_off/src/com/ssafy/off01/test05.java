package com.ssafy.off01;

import java.util.Arrays;

public class test05 {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9,14,165,2367,37,37,245,542353,234,324234234,252525,3636,1111};
		Arrays.sort(arr);
		// find return index
		int search = 37;
		System.out.println(search(arr, 0, arr.length, search));
	}

	private static int search(int[] arr, int begin, int end, int search) {
		// TODO Auto-generated method stub
		int mid = (begin + end) / 2;
		
		if(arr[mid] == search) return mid;
		if(begin == end) return -1;
	
		
		else if(arr[mid] > search) return search(arr,begin,mid-1,search);
		else return search(arr,mid+1,end,search);

	}
}
