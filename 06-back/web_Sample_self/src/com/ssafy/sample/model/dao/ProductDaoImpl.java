package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	static private ProductDao productdao = new ProductDaoImpl();

	private DBUtil db;

	private ProductDaoImpl() {
		super();
		this.db = DBUtil.getInstance();
	}

	static public ProductDao getInstance() {
		return productdao;
	}

	@Override
	public void insert(Product product) throws SQLException {
		try (Connection con = db.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into product(code, model, price) value (?,?,?)");) {
			int index = 0;
			pstmt.setString(++index, product.getCode());
			pstmt.setString(++index, product.getModel());
			pstmt.setInt(++index, product.getPrice());
			pstmt.executeUpdate();
		}

	}

	@Override
	public List<Product> selectAll() throws SQLException {
		List<Product> list = new ArrayList<Product>();

		try (
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from Product order by price");
			) {
			ResultSet nextset = pstmt.executeQuery();
			
			while (nextset.next()) {
				Product p = new Product();
				p.setCode(nextset.getString("code"));
				p.setModel(nextset.getString("model"));
				p.setPrice(nextset.getInt("price"));
				list.add(p);
			}
			return list;
		}
	}

	@Override
	public Product select(String code) throws SQLException {
		
		
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from product where code = ?");
		){
			ResultSet data = pstmt.executeQuery();
			Product product = new Product();
			product.setCode(data.getString("code"));
			product.setModel(data.getString("model"));
			product.setPrice(Integer.parseInt(data.getString("price")));
			return product;
		}
	}

}
