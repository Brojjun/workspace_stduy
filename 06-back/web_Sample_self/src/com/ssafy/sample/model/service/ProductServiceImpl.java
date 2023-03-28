package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDao;
import com.ssafy.sample.model.dao.ProductDaoImpl;


public class ProductServiceImpl implements ProductService {
	static private ProductServiceImpl productService = new ProductServiceImpl();
	private ProductDao dao = ProductDaoImpl.getInstance();
	
	static public ProductService getInstance() {
		return productService;
	}

	@Override
	public List<Product> list() throws SQLException {
		return dao.selectAll();
	}
	@Override
	public void regist(Product product) throws SQLException {
		// TODO Auto-generated method stub
		dao.insert(product);
	}

	@Override
	public Product detail(String code) throws SQLException {
		// TODO Auto-generated method stub
		return dao.select(code);
	}
}
