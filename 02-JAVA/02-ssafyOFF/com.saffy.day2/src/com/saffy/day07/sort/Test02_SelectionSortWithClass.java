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
public class Test02_SelectionSortWithClass {
	static class Data {
		int num;
		
		@Override
		public String toString() {
			return "Data [num=" + num + "]";
		}
		Data(int num){
			this.num = num;
		}
		
	}
	
	static class DataArray{
		Data[] map = null;
		
		@Override
		public String toString() {
			return "DataArray [map=" + Arrays.toString(map) + "]";
		}

		DataArray(Data[] map){
			this.map = map;
		}
		
		public void Sort() {
			for(int i=0; i<map.length-1; i++) {
				int at = i;
				
				//최소값 탐색
				for(int j=i; j<map.length; j++) 
					if(map[j].num < map[at].num) 
						at = j;
					
				//최소값과 앞 swap
				int tmp = map[i].num;
				map[i].num = map[at].num;
				map[at].num = tmp;
				//System.out.printf("위치 변경(%d,%d) : %s %n",i,at,Arrays.toString(map));
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		Data d1 = new Data(4);
		Data d2 = new Data(1);
		Data d3 = new Data(7);
		Data d4 = new Data(13);
		Data d5 = new Data(25);
		Data d6 = new Data(242);
		Data d7 = new Data(5151);
		Data[] map = {d1,d2,d3,d4,d5,d6,d7};
		DataArray arr = new DataArray(map);
		arr.Sort();
		arr.toString();
		
		
		System.out.println(Arrays.toString(map));
	}
}
