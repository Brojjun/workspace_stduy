package com.ssafy.food.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.food.board.model.Food;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class FoodDaoImpl implements FoodDao {
	static private FoodDaoImpl foodDao = new FoodDaoImpl();
	List<Food> list = new ArrayList();
	
	
	static public FoodDaoImpl getInstance() {
		return foodDao;
	}

	public void setFoodDao(FoodDaoImpl foodDao) {
		this.foodDao = foodDao;
	}

	@Override
	public List<Food> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food selectFood(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Food food) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub

	}

}
