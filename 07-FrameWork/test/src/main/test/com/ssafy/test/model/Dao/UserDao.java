package com.ssafy.test.model.Dao;

import java.sql.SQLException;

import com.ssafy.test.model.User;

public interface UserDao {

	User selectLogin(User user) throws SQLException;

}
