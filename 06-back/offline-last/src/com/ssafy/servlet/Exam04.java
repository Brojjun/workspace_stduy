package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value= {"/servlet/exam04","/s/exam04"})
//@WebServlet(urlPatterns= {"/servlet.exam04","/s/exam04"})
//@WebServlet("/servlet/exam04")
@WebServlet(name="servlet.Exam04",urlPatterns="/servlet/exam04")
public class Exam04 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("신난다~재미난다~");
	}


}
