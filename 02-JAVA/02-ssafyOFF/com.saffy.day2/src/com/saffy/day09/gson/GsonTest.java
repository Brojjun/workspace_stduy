package com.saffy.day09.gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

class Food{
	String name;
	int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

class User{
	String id;
	String pass;
	List<Food> foods;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> list) {
		this.foods = list;
	}
}

public class GsonTest {
	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Food f = new Food();
		f.name = "딸기";
		f.price = 1111;
		Food f2 = new Food();
		f2.name = "감바스";
		f2.price = 12313213;
		
		User u1 = new User();
		u1.id = "ssafyt";
		u1.pass = "1234";
		u1.setFoods(Arrays.asList(f, f2));
		
		//System.out.println(new Gson().toJson(u1));
		User user = new Gson().fromJson(new FileReader("User.json"), User.class);
		
		System.out.println(user.getId());
		System.out.println(user.getPass());
		System.out.println(user.getFoods());
	}
}
