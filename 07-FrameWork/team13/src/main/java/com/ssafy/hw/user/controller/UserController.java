package com.ssafy.hw.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.hw.user.model.User;
import com.ssafy.hw.user.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/loginPage")
	public String login() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return "redirect:login";
	}
	
	@RequestMapping("/makeId")
	public String makeId(User user) {
		
		return "todo:index";
	}
}
