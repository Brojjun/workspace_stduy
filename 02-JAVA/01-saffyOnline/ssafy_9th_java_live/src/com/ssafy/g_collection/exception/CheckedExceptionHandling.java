package com.ssafy.g_collection.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedExceptionHandling {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO: 다음에서 발생하는 예외를 처리해보자.
    	try {
    	Class.forName("abcd.efg");
        new FileInputStream("Abc.txt");
        DriverManager.getConnection("some");
    	}
    	
    	catch(ClassNotFoundException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
       	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	// END:
        System.out.println("프로그램 정상 종료");

    }
}
