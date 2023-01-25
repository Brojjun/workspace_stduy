package com.ssafy.day06.Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args){
		//System.out.println(1 / 0);
		
		//Unhandled exception type FileNotFoundException
		//Checked exception ( RunTimeException의 계일이 아닌 것 )
		// 반드시 예외처리를 해야만 한다.
	
		
		try {
			Object obj = new String("123"); 
			Integer iObj = (Integer)obj; //java.lang.ClassCastException
			String msg = null;
			int len = msg.length();
			Scanner in = new Scanner(new File("a.txt"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
