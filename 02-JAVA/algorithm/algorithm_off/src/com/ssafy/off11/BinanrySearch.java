package com.ssafy.off11;

import java.util.Arrays;

public class BinanrySearch {

	public static void main(String[] args) {
		int arr[] = new int [101];
		
		for(int i = 1 ; i < 100; i++) {
			arr[i] = arr[i] + i * 2;
		}
		
		Arrays.sort(arr);
//		for(int i = 0 ; i < 100; i++) {
//			System.out.print(arr[i] +" " );
//		}
		System.out.println(search3(arr,1));
		//-값은 원래 들어갈 -1 * (위치 +1)
		System.out.println(search(arr,32));
		System.out.println(search2(arr,32,0,arr.length-1));
		//System.err.println(arr[search(arr,32)]);
		System.out.println("중복에서 윗 범위 " + upperbound(arr,32));
		System.out.println("중복에서 아랫 범위" + downbound(arr, 32));
	}
	private static int search(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		int mid = (left + right) / 2;
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] == num)return mid;
			else if(arr[mid] < num) left = mid;
			else if(arr[mid] > num) right = mid;
			
		}
		return 0;
	}
	
	private static int search3(int[] arr, int num) {
		return Arrays.binarySearch(arr, num);
	}
	
	
	private static int search2(int[] arr, int num, int left, int right) {
		if(left >= right) return 0;
		
		int mid = (left + right) / 2;
		if(arr[mid] == num) return mid;
		else if (arr[mid] < num) return search2(arr,num,mid,right);
		else return search2(arr,num,left,mid);
		

	}

	private static int upperbound(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		int mid;
		while(left <= right) {
			mid = (left + right) / 2;
			if(arr[mid] <= num) {
				left = mid +1;
			}
			else right = mid - 1;
		}
		return left;
	}
	
	private static int downbound(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		int mid;
		while(left <= right) {
			mid = (left + right) / 2;
			if(arr[mid] < num) {
				left = mid +1;
			}
			else right = mid - 1;
		}
		return right;
	}

	
}
