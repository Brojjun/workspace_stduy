package com.ssafy.day05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * 장점 : 여러 데이터 타입을 하나의 박스로 저장할 수 있다.
 * 	   : 특정 용도(데이터 타입)도 사용하기 위한 제한이 쉽다.
 *     :원하는 타입이 아닌 데이터가 들어가는 것을 체크 할 수 있다. (컴파일 시점)
 *     : 꺼내쓸때 입력한 데이터 타입으로 형변환 하지 말고 실행한다.
 *
 * 
 * 제너릭을 적용하지 못하는 경우
 * - static 선언하는 변수에는 사용 불가능
 * - 배열 선언은 가능한데 생성은 불가능 new <T> 불가능
 *  */
class Box04<K, V> { // 여러개의 타입매개변수 선언
	/*
	 * 타입 파라미터 권장 이름
	 * T : Type
	 * E : Element
	 * K : Key
	 * V : Value
	 * N : Number
	 */
	private K key;
	private V value;
	
	Box04(K key, V value){
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
}

public class Box04Test3 {
	public static void main(String[] args) {
		//1.7버전부터 <> 연산자를 이용해서 타입파라미터를 생성 할 수 있다.
		Map<String, Map<Integer, List<String>>> map = new HashMap();
		
		Box04<Integer, String> box = new Box04(1,"점심");
		List<Integer> list = new ArrayList<>();
		
		Iterator ite = list.iterator();
		
	}
}