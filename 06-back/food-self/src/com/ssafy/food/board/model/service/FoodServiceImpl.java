package com.ssafy.food.board.model.service;

import java.util.List;

import com.ssafy.food.board.model.Food;
import com.ssafy.food.board.model.dao.FoodDao;

import sun.security.jca.GetInstance;

public class FoodServiceImpl implements FoodService {
	private FoodServiceImpl foodService = new FoodServiceImpl();
	
	FoodDao foodDao = FoodDao.getInstance();
	
	static public FoodServiceImpl getInstance() {
		return foodService;
	}
	@Override
	public List<Food> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food FoodByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(Food food) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void pop(int no) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() throws Exception {
		// TODO Auto-generated method stub

	}

}
