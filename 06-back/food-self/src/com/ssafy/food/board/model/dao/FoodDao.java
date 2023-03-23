package com.ssafy.food.board.model.dao;

import java.util.List;

import com.ssafy.food.board.model.Food;

public interface FoodDao {
	/*
	 * list
	 * selectFood
	 * inseret
	 * del
	 * delAll
	 */
	
	List<Food> selectAll() throws Exception;
	Food selectFood(int no)throws Exception;
	void insert(Food food) throws Exception;
	void delete(int no) throws Exception;
	void deleteAll() throws Exception;
	
	
}
