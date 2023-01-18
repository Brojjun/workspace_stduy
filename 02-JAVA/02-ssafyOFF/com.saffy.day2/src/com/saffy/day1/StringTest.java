package com.saffy.day1;

import java.util.Arrays;

public class StringTest {
	/*
	 *  자바의 문자열 관련 API 클래스
	 *  
	 *  String
	 *  
	 *  StinrgBuffer
	 *  StringBuilder
	 *  
	 *  String buffer와 StringBulider의 차이

		String buffer=> 동기화 

		StringBulider=> 비동기화
	 *  
	 */
	
	static void exam01() {
		String str1 = "a";
		StringBuffer str2 = new StringBuffer("a");
		StringBuilder str3 = new StringBuilder("a");
		
		System.out.println(str1.concat("b"));
		System.out.println(str2.append("b"));          
		System.out.println(str3.append("b"));          
		                                               
		System.out.println(str1);          
		System.out.println(str2);
		System.out.println(str3);
		                   
	}
	
	// 문자열 매소드 시간비교
	static void exam02() {
		String s1 = "a";
		//동기화
		StringBuffer s2 = new StringBuffer("a");
		
		//비동기화
		StringBuilder s3 = new StringBuilder("a");
		
		long bt = System.currentTimeMillis();
		
		for(int i = 0; i<100000; i++) {
			//s1 += i;
			//s2.append(i);
			s3.append(i);
		}
		
		long at = System.currentTimeMillis();
		//1000d -> 더블형
		System.out.println("시간 : " + (at-bt) / 1000d + "초");
	}
	
	
	//string api 중심으로
	static void exam03() {
		String s = "Hello";
		char ch = s.charAt(0);
		int n = s.length();
		
		System.out.println(ch);
		System.out.println(n);
		
		for(int i = 0; i<n;i++)
			System.out.print(s.charAt(i));
		
		char[] arr = s.toCharArray();
		
		
		//equalsIgnoreCase는 대소문자 구분x  + equal은 구분
		s= "Hello";
		if(s.equalsIgnoreCase("hello"))
			System.out.println("true");
		
		
		
		System.out.println(s.toUpperCase());
		
		
		System.out.println(s.toLowerCase());
		
		s = "Hello Java";
		int a = s.indexOf("l");// llo가 시작되는 index 반환
		
		System.out.println(s.indexOf("l",a+1));// llo가 시작되는 index 반환
		
		
		System.out.println(s.lastIndexOf("l"));// llo가 시작되는 index 반환
		
		
		boolean find = s.contains("llo");//있다 없다를 판다. boolean으로 return
		System.out.println(find);
		
		
		//문자열로 만들기+, valueOF
		String data = 10 + "";
		data = String.valueOf(13200);
		
		//System.out.println(data);
		data = "     H  e ll o    ";
		data = data.trim();//앞 뒤 공백제거
		
		
		data = data.replace(" ","");//중간 공백 제거
		System.out.println(data);
	
	}
	
	public static String exam04(String a) {
		return a.replaceAll("[0-9]","");
		
	
	}
	public static void main(String[] args) {
		//exam01();
		//exam02();
		//exam03();
		String test = exam04("343434H43434i123213");
		System.out.println(test);
		
		String s = "3:2:1:3:2";
		String[] arr = s.split(":");
		System.out.println(Arrays.deepToString(arr));
		
		s = "https://www.naver.com";
		System.out.println(s.startsWith("https://"));//시작 문자열이 맞는지 참트루 확인
		
		s = "flower.jpg";
		System.out.println(s.endsWith(".jpg"));
		
		s = "/myserver/login?id=a&password=b";
		String contextPath = "/myserver";
		System.out.println(s.substring(contextPath.length()));//문자열 추출
		/*
		String A = "java";
		String B = new String("java");
		if(A==B)
			System.out.print("java");
		if(A!=B)
			System.out.print("c++");
		if(A.equals(B))
			System.out.print("true");
			
		*/
		
		
		StringBuffer C = new StringBuffer();
		
		
		
	}
	
	
}
