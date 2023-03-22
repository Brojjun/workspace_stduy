package com.ssafy.servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if("ssafy".equals(id) && "1111".equals(password)) {
			//쿠키 생성
			Cookie c = new Cookie("product","TV");
			c.setMaxAge(-1);
			c.setPath("/");
			response.addCookie(c);
			
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {}
			
			//user정보 저장
			User user = new User(id,password,"싸피");
		
			//세션에 등록
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			// main.jsp로 이동
			response.sendRedirect(request.getContextPath() + "/main");
		}else {
			// login.jsp로 이동
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
	
	}
}
