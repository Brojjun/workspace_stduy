package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/login")
	public String login(HttpSession session,Model model, @RequestParam("userid") String userId, @RequestParam("userpwd") String userPwd) throws Exception {
		MemberDto memberDto = memberService.loginMember(userId, userPwd);
		if(memberDto != nul	l) {
			session.setAttribute("userinfo", memberDto);
			return "rediect:/";
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호 오류");
			return "user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
