package com.ssafy.test.model.service;

import java.util.List;

import com.ssafy.test.model.Product;

public interface ProductService {
	List<Product>list() throws Exception;

	Product detail(int no) throws Exception;

	void delete(int no) throws Exception;

	void write(Product board) throws Exception;

	void deleteAll(List<Integer>no) throws Exception;
}
