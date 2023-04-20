package com.ssafy.hw.user.model.service;



import com.ssafy.hw.user.model.User;

public interface UserService {
	boolean login(User user) throws Exception;
	void makeId(User user) throws Exception;
}
