package com.ssafy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Del {
	Del(){};
	
	public void delete(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Driver is connected");
		
		StringBuffer sql = new StringBuffer("delete from jdbctest ");
		sql.append("where name = ? ");
		
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","ssafy","ssafy");
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
			){
			int i = 1;
			pstmt.setString(i++, name);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "'s data is delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
