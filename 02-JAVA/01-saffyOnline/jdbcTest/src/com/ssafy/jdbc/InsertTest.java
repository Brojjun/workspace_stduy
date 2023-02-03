package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class InsertTest {
	

	public InsertTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패!");
		}
		
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC", "ssafy", "ssafy");
		
	}
	
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		int cnt = it.registre("형준", 28);
		if(cnt != 0) {
			System.out.println("등록 성공");
		}
		else
			System.out.println("등록 실패");
	}
	
	private int registre(String name, int age) {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//DB연결
			con = getConnection();
			//SQL 실행준비
			StringBuilder sql = new StringBuilder("insert into jdbctest (name, age) ");
			sql.append("values (?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,name);
			pstmt.setInt(2, age);
			//SQL 실행
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return cnt;
	}
	
}
