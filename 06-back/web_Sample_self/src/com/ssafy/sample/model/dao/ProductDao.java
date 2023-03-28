package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductDao {
	void insert(Product prodcut) throws SQLException;
	List<Product> selectAll() throws SQLException;
	Product select(String code) throws SQLException;
}
