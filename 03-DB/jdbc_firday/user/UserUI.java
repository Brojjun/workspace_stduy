package com.ssafy.jdbc.user;

public class UserUI {
	private UserDao userDao;

	public UserUI() {
		userDao = UserDaoImpl.getInstance();
	}
	
	
}
