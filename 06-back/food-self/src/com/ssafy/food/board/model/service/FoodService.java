package com.ssafy.food.board.model.service;

import java.util.List;

import com.ssafy.food.board.model.Food;

public interface FoodService {
	
	List<Food> list() throws Exception;
	Food FoodByNo(int no)throws Exception;
	void push(Food food) throws Exception;
	void pop(int no) throws Exception;
	void clear() throws Exception;
}
