package com.ssafy.hw.user.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.hw.todomvc.model.Todo;
import com.ssafy.hw.user.model.User;

public interface UserDao {

		User selectUser(User user) throws SQLException;
		
		void createUser(User user) throws SQLException;
		
}
