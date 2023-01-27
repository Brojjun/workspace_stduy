package com.ssafy.h_fileio.io.process.object;

import java.io.Serializable;

// TODO: Person 을 직렬화 가능하도록 처리하시오.

public class Person implements Serializable{
	
	
	private String id;
	private String pass;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", pass=" + pass + "]";
	}

	public Person(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
}

/*
class Person implements Serializable{
	private String name;
	private int age;
	
	private transient String son;
	private LoginInfo Info;
	
	class LoginInfo implements Serializable{
		private int a;
	}
	
}
*/
