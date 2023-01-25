package com.ssafy.day06.Exception;

class MyException extends Exception{ // 컴파일시 체크되는 예외 ( unchecked )
	
}

class MyRuntimeException extends RuntimeException{ // 실행시에 체크되는 예외 ( che
	
}

// FileNotFoundException -> 컴파일시 파일 없으면
// NullPointException 	 -> 런타임에서 null값
// ArimeticException 	 -> 0으로 나누기
public class Test02 {
	public static void main(String[] args) {
//		throw new MyRuntimeException();
		try {
			throw new MyException();
		} catch (MyException e) { // MyException e = new MyException();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
