package com.ssafy.sample.model.Dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.model.Board;

public interface BoardDao {
	List<Board>selectBoard() throws SQLException;

	Board selectByPk(int no) throws SQLException;

	void deleteBoard(int no) throws SQLException;

	void write(Board board) throws SQLException;

	void deleteAll(int no) throws SQLException;
}
