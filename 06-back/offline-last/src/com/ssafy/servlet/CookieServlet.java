package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Cookie c = new Cookie("new", "singernewj");
			Cookie d = new Cookie("new222", "22222");
			response.addCookie(d);	
			c.setMaxAge(3600);
			response.addCookie(c);
	
		
		request.getRequestDispatcher("/cookie-info.jsp").forward(request, response);
	}
}
