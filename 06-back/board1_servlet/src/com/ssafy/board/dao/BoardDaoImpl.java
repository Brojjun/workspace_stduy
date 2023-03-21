package com.ssafy.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;
import com.sun.corba.se.pept.transport.Connection;

public class BoardDaoImpl implements BoardDao {

	@Override
	public int writeArticle(BoardDto boardDto) {
		// 0. JDBC연결하기=>
		// 1. 드라이버 로딩
		// 2. 연결객체 얻기
		// 3. SQL문 작성
		// 4. SQL 실행 객체 얻어오기
		// 5. SQL 실행하기
		// 6. 결과 처리
		java.sql.Connection con = null;
		PreparedStatement pstnt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into Board( 				");
			sql.append("	user_id, subject, content	");
			sql.append(") values (						");
			sql.append("	?, ?, ?						");
			sql.append(")								");
			pstnt = con.prepareStatement(sql.toString());
			int index = 0;
			pstnt.setString(++index, boardDto.getUserId());
			pstnt.setString(++index, boardDto.getSubject());
			pstnt.setString(++index, boardDto.getContent());
			return pstnt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			DBUtil.close(con);
		}
	}

	@Override
	public List<BoardDto> listArticle() {
		List<BoardDto> list = new ArrayList<>();
		// 0. JDBC연결하기=>
		// 1. 드라이버 로딩
		// 2. 연결객체 얻기
		// 3. SQL문 작성
		// 4. SQL 실행 객체 얻어오기
		// 5. SQL 실행하기
		// 6. 결과 처리
		java.sql.Connection con = null;
		PreparedStatement pstnt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("Select * ");
			sql.append("	from board");
			sql.append("order by article_no;");
			pstnt = con.prepareStatement(sql.toString());
			ResultSet rs = pstnt.executeQuery();
			while(rs.next()) {
				BoardDto board = new BoardDto();
				board.setArticleNo(rs.getInt("article_no"));
				board.setSubject(rs.getString("subject"));
				board.setUserId(rs.getString("user_id"));
				board.setHit(rs.getInt("hit"));
				board.setRegisterTime(rs.getString("register_time"));
				list.add(board);
			}
		return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BoardDto viewArticle(int articleNo) {
		
		// 0. JDBC연결하기=>
		// 1. 드라이버 로딩
		// 2. 연결객체 얻기
		// 3. SQL문 작성
		// 4. SQL 실행 객체 얻어오기
		// 5. SQL 실행하기
		// 6. 결과 처리
		java.sql.Connection con = null;
		PreparedStatement pstnt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("Select * ");
			sql.append("	from board");
			sql.append("where article_no = ? ;");
			pstnt = con.prepareStatement(sql.toString());
			pstnt.setInt(1, articleNo);
			ResultSet rs = pstnt.executeQuery();
			
			if(rs.next()) {
				BoardDto board = new BoardDto();
				board.setArticleNo(rs.getInt("article_no"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setUserId(rs.getString("user_id"));
				board.setHit(rs.getInt("hit"));
				board.setRegisterTime(rs.getString("register_time"));
				return board;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
