package com.ssafy.jdbc;

import java.sql.Connection;

public class DriverLoadingTest {

	DriverLoadingTest(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패!");
		}
	}
	public static void main(String[] args) {
		new DriverLoadingTest();
	}
}
