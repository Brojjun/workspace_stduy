package com.saffy.day07.sort;

import java.util.Arrays;

/*
 * 선택정렬(Selection Sort)
 * - 가장 작은 데이터를 찾아서 맨앞의 데이터와 체인지
 * 
 * 3 5 2 9 6 
 * 
 * 1단계
 * 2 5 3 9 6
 * 
 * 2단계
 * 2 3 5 9 6
 * 
 * 3단계
 * 2 3 5 9 6
 */
public class Test01_SelectionSort {
	public static void main(String[] args) {
		int[] map = {3, 5, 2, 9, 6, 2};
		
		for(int i=0; i<map.length-1; i++) {
			int at = i;
			
			//최소값 탐색
			for(int j=i; j<map.length; j++) 
				if(map[j] < map[at]) 
					at = j;
				
			
			//최소값과 앞 swap
			int tmp = map[i];
			map[i] = map[at];
			map[at] = tmp;
			System.out.printf("위치 변경(%d,%d) : %s %n",i,at,Arrays.toString(map));
		}
		System.out.println(Arrays.toString(map));
	}
}
