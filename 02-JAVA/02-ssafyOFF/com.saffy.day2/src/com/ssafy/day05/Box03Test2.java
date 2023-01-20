package com.ssafy.day05;

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
class Box03<T> { // 사용하는 쪽 : Box<String>, Box<Integer>
	/*
	 * 타입 파라미터 권장 이름
	 * T : Type
	 * E : Element
	 * K : Key
	 * V : Value
	 * N : Number
	 */
	private T data;


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}

public class Box03Test2 {
	public static void main(String[] args) {
		//Box03 is a row type.
		//Referec to generic type Box03<T> should be parametarized.
		Box03<String> box = new Box03<String>();
		box.setData("히히힣");
		String data = box.getData();
		System.out.println(data.toString());
		//box.setData(123); //string을 줘서 오류가 난 모습
		//box.setData(100);
		
		Box03<Integer> box = new BOX03<Integer>();
		
		
	}
}