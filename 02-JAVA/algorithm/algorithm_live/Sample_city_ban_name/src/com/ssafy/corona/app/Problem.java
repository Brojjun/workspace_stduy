package com.ssafy.corona.app;

import java.io.Serializable;

public class Problem implements Serializable{
	String type;
	int score;
	public Problem() {}
	public Problem(String type, int score) {
		super();
		this.type = type;
		this.score = score;
	}
}
