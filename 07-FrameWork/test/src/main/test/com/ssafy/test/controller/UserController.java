package com.ssafy.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.test.model.User;
import com.ssafy.test.model.service.UserSerivce;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserSerivce userService;

	public UserController(UserSerivce userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/login")
	public String login(HttpSession session, User user) throws Exception {
		
		User userInfo = userService.login(user);
		if(userInfo != null) {
			session.setAttribute("userInfo", userInfo);
		}
		
		
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}
}
