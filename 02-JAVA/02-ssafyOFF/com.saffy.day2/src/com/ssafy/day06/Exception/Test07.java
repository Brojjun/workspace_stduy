package com.ssafy.day06.Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MyClose implements AutoCloseable{

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyClose - close() 호출");
	}
	
	
}
public class Test07 {
	public static void main(String[] args) {
		try (
				//The resource type MyClose does not implement java.lang.AutoCloseable
				MyClose mc = new MyClose();
				){
			System.out.println("Try 시작");
			System.out.println(1/0);
			System.out.println("Try 종료");
			
		} catch (Exception e) {
			System.out.println("에러발생");
		}
		System.out.println("블럭 밖");
		/*
		//AutoCloseable 구현 클래스
		try (
				FileReader fr = new FileReader("Test04.txt");
				BufferedReader br = new BufferedReader(fr);
				){


			while (true) {

				String line = br.readLine();
				if (line == null)
					break;

				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		 */
	}
}
