package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.Product;
import com.ssafy.test.model.Dao.ProductDao;


@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao boardDao;
	
	
	public ProductServiceImpl(ProductDao boardDao) {
		super();
		this.boardDao = boardDao;
	}

	@Override
	public List<Product> list() throws Exception {
		return boardDao.selectBoard();
	}

	@Override
	public Product detail(int no) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectByPk(no);
	}

	@Override
	public void delete(int no) throws Exception {
		boardDao.deleteBoard(no);
	}

	@Override
	public void write(Product board) throws Exception {
		boardDao.write(board);
		
	}

	@Override
	public void deleteAll(List<Integer>no) throws Exception {
		if(no.size() == 0)return;	
		for(int num : no)
			boardDao.deleteAll(num);
		
	}

}