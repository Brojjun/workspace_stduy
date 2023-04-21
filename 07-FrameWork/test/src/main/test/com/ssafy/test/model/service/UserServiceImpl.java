package com.ssafy.test.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.test.model.User;
import com.ssafy.test.model.Dao.UserDao;

@Service
public class UserServiceImpl implements UserSerivce {
	
	private final UserDao userDao;


	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public User login(User user) throws Exception {
		return userDao.selectLogin(user);
	}

}
