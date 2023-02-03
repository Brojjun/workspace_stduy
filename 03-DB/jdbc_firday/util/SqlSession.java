package com.ssafy.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SqlSession {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static int executeUpdate(String sql, Object...args) throws Exception {
		try(
			Connection con = DriverManager.getConnection(
					"", "ssafy", "ssafy"
			);
			PreparedStatement stmt = con.prepareStatement(sql);	
		) {
			int parameterIndex = 1;
			for (Object arg : args) {
				stmt.setObject(parameterIndex++, arg);
			}
			return stmt.executeUpdate();
		}		
	} 
	public static int insert(String sql, Object...args) throws Exception {
		return executeUpdate(sql, args);		
	} 
	public static int update(String sql, Object...args) throws Exception {
		return executeUpdate(sql, args);
	} 
	public static int delete(String sql, Object...args) throws Exception {
		return executeUpdate(sql, args);	
	} 
}












