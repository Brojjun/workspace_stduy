package com.ssafy.corona.app;

public interface ProblemMng {
	void save(String filename);
	void load(String filename);
	void add(Problem problem);
}
