package com.ssafy.jdbc.test;

public class main {
	public static void main(String[] args) {
		Ins in = new Ins();
		Del dl = new Del();
		in.insert("으리으", 16);
		dl.delete("으리으리");
	}

	
}
