package com.saffy.day07.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test03_DataComparable{
	static class Data implements Comparable<Data>{
		String name;
		int age;
		Data(String name, int age){
			this.name = name;
			this.age = age;
		}
		@Override
		public String toString() {
			return name + " , " + age;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 * 
		 * 0 : 자리바꿈 없음
		 * 음수 : 비교대상보다 앞으로 이동
		 * 양수 : 비교대상보다 뒤로 이동
		 */
		
		//내나이 30 인자나이 49
		//30 - 49 = -19
		//음수니깐 비교대상보다 앞으로 이동
		// 
		@Override
		public int compareTo(Data o) {
			//나이순 정렬
			//(this.age - o.age) * -1 하면 정렬순서 바꾸기~쌉가능~
			//return this.age - o.age; // 내나이 - 인자나이 => 음수 => 
			// TODO Auto-generated method stub
			
			//이름순정렬
			return this.name.compareTo(o.name);
		}
		
	}
	
	public static void main(String[] args) {
		
		
		/*
		 * "a" < "b"
		 * "abcd" < "b" -> 첫글자끼리 비교 후 두번째 글자 비교 -> 이건 a와b를 비교해서 리턴
		 * "abcd" < "ac" -> a끼리 비교 후 b와 c 비교
		 */
		
		System.out.println("ba".compareTo("bc")); // -2
		System.out.println("a".compareTo("A"));  // 32
		System.out.println("a".compareTo("a"));  // 0
		
		Data d1 = new Data("빈지노", 1000);
		Data d2 = new Data("오웬 오바도즈", 29);
		Data d3 = new Data("릴보이", 20000);
		Data d4 = new Data("제니", 999999);
		
		//배열 sort api
		Data[] arr = {d1,d2,d3,d4};
		Arrays.sort(arr);
		Arrays.sort(arr,Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		
		
		//List sort api
		List<Data> list = Arrays.asList(arr);
		Collections.sort(list);
		System.out.println(list);
	
	}
}
