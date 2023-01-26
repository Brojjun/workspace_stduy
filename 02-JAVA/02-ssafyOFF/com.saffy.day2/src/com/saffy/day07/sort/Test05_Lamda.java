package com.saffy.day07.sort;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.omg.Messaging.SyncScopeHelper;

@FunctionalInterface
interface Parent02 {
	int call(String msg);
}

@FunctionalInterface
interface Parent01 {
	void call(String msg);
}
//
//class Child implements Parent01{
//
//	@Override
//	public void call(String msg) {
//		// TODO Auto-generated method stub
//		System.out.println("<<"+ msg + ">>");
//	}
//	
//}

class Child2 implements Parent01{

	@Override
	public void call(String msg) {
		// TODO Auto-generated method stub
		System.out.println("{["+ msg + "]}");
	}
	
}

public class Test05_Lamda {
	static void test(Parent01 p) {
		p.call("방가방가");
	}
	static void test2(Parent02 p) {
		System.out.println(p.call(null));
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a","aa","aaaa");
		//for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
		
		list.stream().forEach(v -> System.out.println(v));
		
		list.stream().forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
			
		});
		
		list.stream().forEach(t->System.out.println(t));
//		Parent01 p = new Child();
//		test(p);
//		p = new Child2();
//		test(p);
		test(new Parent01(){

			@Override
			public void call(String msg) {
				// TODO Auto-generated method stub
				System.out.println("익명클래스 쌉가능~~~");
			}
			
		});
		//매개변수가 하나일 경우에만 가능
		//실행문장이 하나일 경우 {} 생략가능
		//실행문장이 return 을 포함하는 한문장일 경우 출력 성공시 return 키워드를 무조건 제거해야 한다.
		test(msg -> System.out.println("<{<{<{" + msg + "?>?>?>"));
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		//test2(abc -> Integer.parseInt(abc));
	}
}
