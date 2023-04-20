package com.ssafy.todomvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.ssafy.todomvc.model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {
	private final DataSource dataSource;
	

	
	public TodoDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		System.out.println("Dao 생성 완료");
	}

	@Override
	public void deleteAllTodo() throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from todo");
				){
				pstmt.executeUpdate();
			}
	}
	
	@Override
	public void deleteTodo(int no) throws SQLException {
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from todo where no = ?");
				){
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}
	}

	@Override
	public void insertTodo(Todo todo) throws SQLException {
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into todo(content) values(?)");
			){
			pstmt.setString(1, todo.getContent());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public List<Todo> selectTodo() throws SQLException {
		List<Todo>list = new ArrayList<Todo>();
		try(
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from todo order by no");
			){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Todo todo = new Todo(rs.getInt("no"),rs.getString("content"));
				list.add(todo);
			}
		}
		return list;
	}
}















