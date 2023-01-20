package com.ssafy.day05;

/*
 * object 사용시
 * 장점 : 여러 데이터 타입을 하나의 박스로 저장할 수 있다.
 * 
 * 단점 : 특정 용도(데이터 타입)도 사용하기 위한 제한이 어렵다.
 * 	   => 원하는 타입이 아닌 데이터가 들어가는 것을 체크 할 수 없다. (실행 전까지...)
 * 	   => 꺼내쓸때 내가 원하는 데이터 타입으로 형변환해야한다.
 * 
 */
class Box02 {
	private Object data;


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}

public class Box02Test {
	public static void main(String[] args) {
		Box02 box = new Box02();
		box.setData("히히힣");
		box.setData(123);
		String data = (String)box.getData();
		box.setData(100);
		
	}
}