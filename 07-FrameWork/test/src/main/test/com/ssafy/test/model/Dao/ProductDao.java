package com.ssafy.test.model.Dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.model.Product;

public interface ProductDao {
	List<Product>selectBoard() throws SQLException;

	Product selectByPk(int no) throws SQLException;

	void deleteBoard(int no) throws SQLException;

	void write(Product board) throws SQLException;

	void deleteAll(int no) throws SQLException;
}
