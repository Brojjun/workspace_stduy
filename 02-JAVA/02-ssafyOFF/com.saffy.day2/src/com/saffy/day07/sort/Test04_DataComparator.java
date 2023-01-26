package com.saffy.day07.sort;

import java.util.Arrays;
import java.util.Comparator;



class Data implements Comparable<Data>{
	String title;
	String name;
	int year;
	
	public Data(String title, String name, int year) {
		super();
		this.title = title;
		this.name = name;
		this.year = year;
	}

	@Override
	public String toString() {
		return title + " - " + name + " - " + year;
	}

	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
		//return this.year - o.year;
		return this.name.compareTo(o.name) * -1;
	}
	

}
//
//class DataComparator implements Comparator<Data>{
//
//	@Override
//	public int compare(Data o1, Data o2) {
//		// TODO Auto-generated method stub
//		return o1.year - o2.year;
//	}
//}


public class Test04_DataComparator {
	public static void main(String[] args) {
		Data d1 = new Data("더 글로리", "송혜교", 2023);
		Data d2 = new Data("카지노", "최민식", 2022);
		Data d3 = new Data("불멸의 이순신", "기억안남", 2005);
		Data d4 = new Data("야인시대", "김두한", 2001);
		Data d5 = new Data("미스터 션샤인", "이병헌", 2018);
		
		Data[] d = {d1,d2,d3,d4,d5};
		
		//Data의 sort를 무시하고, DataComparator의 sort를 덮어 씌움
		/*
		 * 익명클래스(내부클래스의 한 종류)
		 * - 클래스의 내용선언 + 객체의 생성 
		 * 형식
		 * new 부모클래스 | 부모인터페이스() {
		 * 	  ...(클래스의 내용)...
		 * }
		 */
		
		Arrays.sort(d, new Comparator<Data>(){

		
			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				return o1.year - o2.year;
			}
			
		});
		
		//Arrays.sort(d, comp);
		
		
		/*
		 * 람다표현식을 이용한 방법
		 * 구현하려는 인터페이스에 메소드가 딱 하나만 있을 때 람다식 허용 = functionallInterface
		 */
		
		Arrays.sort(d, (o1,o2)->o1.year - o2.year);
		
		
		System.out.println(Arrays.toString(d));
	}
}




	
	
