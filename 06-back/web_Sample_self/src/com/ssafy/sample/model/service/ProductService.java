package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;

public interface ProductService {
	public void regist(Product product) throws SQLException;
	
	public List<Product> list() throws SQLException;

	public Product detail(String code) throws SQLException;
}
