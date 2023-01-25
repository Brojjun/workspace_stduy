package com.ssafy.day06.Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * try
 * catch
 * finally
 * throw
 *   +
 * 사용자 정의 예외 ( extends 예외클래스 )
 */

public class Test03 {
	public static void main(String[] args) {
		try {
			//예외가 발생할 만한 코드
			FileReader fr = new FileReader("a.txt");
			int read = fr.read();
			
			System.out.println(1/0);
			String msg = null;
			int len = msg.length();
			System.out.println(len);
			
		} catch(ArithmeticException | IOException | NullPointerException e) {
			System.out.println("exception ");
//		catch(FileNotFoundException e) {	//try 블럭에서 발생한 예외중에 처리할 예외를 선언
//			
//		} catch(IOException e) {	//try 블럭에서 발생한 예외중에 처리할 예외를 선언
//			
//		} catch(NullPointerException e) {
//			
//		} catch(Exception e) {
//			
		} finally {	//예외 발생 여부와 상관없이 무조건 실행 
			
		}
	}
}
