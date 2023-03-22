package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/sseion")
public class Exam07 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세선가져오기
		HttpSession session = request.getSession();
		
		//세션의 아이디 가져오기
		String id = session.getId();
		
		//세션의 유효시간 변경하기
		session.setMaxInactiveInterval(3);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>JESSESION : " + id + "</h2>");
		out.close();
		
	}
	
	
}
