package com.ssafy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Ins {
	
	public void insert(String name, int age) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is connected");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","ssafy","ssafy");
			System.out.println("Connection success");
			
			StringBuffer sql = new StringBuffer("insert into jdbctest(name, age) ");
			sql.append("values(?, ?); ");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			int i = 1;
			pstmt.setString(i++, name);
			pstmt.setInt(i++, age);
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "'s update success");
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver isn't connected");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection failed");
		}
	}
	
}
