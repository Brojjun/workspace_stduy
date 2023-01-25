package com.ssafy.f_interface.generic.method;

public class TypeParameterMethodTest<T> {
	T some;

	public TypeParameterMethodTest(T some) {
		this.some = some;
	}

	public <P> void method1(P p) {

		Class<?> clz = some.getClass(); // 클래스 자체에 대한 정보 (p가 뭐가 들어올지 몰라 ? 사용 )

		// getname = 클래스의 이름인데 패키지의 이름이 포함되어있다
		// getsimplename 간단한 클래스의 이름
		System.out.println(clz.getName());
		System.out.println(clz.getSimpleName());

        System.out.printf("클래스 레벨의 T: %s%n", some.getClass().getSimpleName());
        System.out.printf("파라미터 레벨의 P: %s%n", p.getClass().getSimpleName());
	}

	public <P> P method2(P p) {
        System.out.printf("클래스 레벨의 T: %s%n", some.getClass().getSimpleName());
        System.out.printf("파라미터 레벨의 P: %s%n", p.getClass().getSimpleName());
		return p;
	}

	public static void main(String[] args) {
		// 객체 생성 시점 - 클래스에 선언된 타입 파라미터 T의 타입 결정
		TypeParameterMethodTest<String> tpmt = new TypeParameterMethodTest<>("Hello");
		// 메서드 호출 시점 - 메서드에 선언된 타입 파라미터 P의 타입 결정
		tpmt.method1(10);
		tpmt.<Long>method2(20L);
	}
}
