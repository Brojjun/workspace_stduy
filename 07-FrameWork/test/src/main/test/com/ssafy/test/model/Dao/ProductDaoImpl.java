package com.ssafy.test.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.test.model.Product;
import com.ssafy.test.model.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	private DataSource dataSource;

	public ProductDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Product> selectBoard() throws SQLException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select b.no, b.title, b.writer, u.name "
						+ "from board b join user u " + "on b.writer = u.id " + "order by no desc");) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			while (rs.next()) {
				Product boardInfo = new Product();
				boardInfo.setNo(rs.getInt("no"));
				boardInfo.setTitle(rs.getString("title"));
				boardInfo.setWriter(rs.getString("writer"));
				boardInfo.setName(rs.getString("name"));
				list.add(boardInfo);
			}

			return list;
		}
	}

	@Override
	public Product selectByPk(int no) throws SQLException {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from board where no = ?");) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			if (rs.next()) {
				Product boardInfo = new Product();
				boardInfo.setNo(rs.getInt("no"));
				boardInfo.setTitle(rs.getString("title"));
				boardInfo.setWriter(rs.getString("writer"));
				boardInfo.setContent(rs.getString("content"));
				return boardInfo;
			}

			return null;
		}

	}

	@Override
	public void deleteBoard(int no) throws SQLException {
		try (
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from board where no = ?");) 
			{
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}
	}

	@Override
	public void write(Product board) throws SQLException {
		try (
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into board (title, writer, content) value (?,?,?)");) 
			{
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
				pstmt.executeUpdate();
			}
		
	}

	@Override
	public void deleteAll(int no) throws SQLException {
		try (
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from board where no = ?");) 
			{	
		
				pstmt.setInt(1, no);

				pstmt.executeUpdate();
			}
		
	}
}
