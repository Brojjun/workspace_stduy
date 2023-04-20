package com.ssafy.sample.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.sample.model.Board;
import com.ssafy.sample.model.User;

@Repository
public class BoardDaoImpl implements BoardDao {

	private DataSource dataSource;

	public BoardDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Board> selectBoard() throws SQLException {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select b.no, b.title, b.writer, u.name "
						+ "from board b join user u " + "on b.writer = u.id " + "order by no desc");) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Board> list = new ArrayList<Board>();
			while (rs.next()) {
				Board boardInfo = new Board();
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
	public Board selectByPk(int no) throws SQLException {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from board where no = ?");) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Board> list = new ArrayList<Board>();
			if (rs.next()) {
				Board boardInfo = new Board();
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
	public void write(Board board) throws SQLException {
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
