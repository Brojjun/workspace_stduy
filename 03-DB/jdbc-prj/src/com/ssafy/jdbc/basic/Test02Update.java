package com.ssafy.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02Update {
	public Test02Update() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}

	private void insert() throws SQLException {
		String name = "싸피";
		String content = "자바를 이용한 데이터베이스 연결";
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into tb_test( ");
		sql.append("	name, content ");
		sql.append(") values ( ");
		//sql.append("	'" + name + "', '" + content + "' ");
		sql.append("	?, ? ");
		sql.append(") ");
		
		try(
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb", "ssafy", "ssafy");
			PreparedStatement stnt = con.prepareStatement(sql.toString());
		)
		{
			//SQL 문장을 실행하기 전에 ?에 들어갈 값을 설정한다.
			int i=1;
			stnt.setString(i++, name);
			stnt.setString(i++, content);
			int cnt = stnt.executeUpdate();
			
			System.out.println(cnt + "개의 행이 추가되었습니다.");
		}
	}

	private void delete() throws SQLException {
		String name = "싸피";
		int no = 3;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from tb_test ");
		sql.append("where name = ? ");

		
		try (
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb", "ssafy", "ssafy");
			PreparedStatement stmt = con.prepareStatement(sql.toString());
		) {
			// TODO Auto-generated catch block
			int i = 1;
			stmt.setString(i++, name);
			int cnt = stmt.executeUpdate();
			
			System.out.println(cnt + "개의 행이 삭제되었습니다.");
		} 
		
	}

	private void update() {

	}

	public static void main(String[] args) {
		try {
			Test02Update t = new Test02Update();
			t.insert();
			t.update();
			t.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
