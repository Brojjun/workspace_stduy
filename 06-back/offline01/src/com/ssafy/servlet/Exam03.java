package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/exam03")
public class Exam03 extends HttpServlet {
	/*
	 * 1. init 2. service(sr,sr) 3. service(hsr,hsr) 4. Doget(hsr,hsr) or
	 * DoPost(hsr,hsr)
	 * 
	 * 2,3,4번 중 하나를 재정의 해야 405에러가 안뜬다. 4번을 재정의하려면 따로따로
	 * 
	 */

	// 이렇게 할 바에는 genericServlet을 사용한다.
//	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
//		System.out.println("2단계 service(ServletRequest request, ServletResponse response)");
//	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("doget");
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost2");
	}

}
