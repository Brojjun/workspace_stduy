package com.ssafy.day03;


class Single {
	private Single() {
		
	}

 
	 //1번 방식
//	private static Single instance = new Single();
//	public static Single getInstance() {return Instance;}
	 
	//2번 방식
	private static Single instance;
	public synchronized static Single getInstance(){
		if (instance == null) {
			instance = new Single();
		}
		return instance;
	}
}

public class Exan06_singleton {
	
	public static void main(String[] args) {
		Single s = Single.getInstance();
		
	}
}
