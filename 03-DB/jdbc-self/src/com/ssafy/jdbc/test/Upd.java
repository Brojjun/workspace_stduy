package com.ssafy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Upd {
	
	public void update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sql = new StringBuilder("update jdbctest set name = ? ");
		sql.append("where ")
		try(
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","ssafy","ssafy");
			PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
