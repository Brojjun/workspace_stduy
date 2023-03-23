package com.ssafy.month_test.board.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.month_test.board.model.service.StudentService;
import com.ssafy.month_test.board.model.service.StudentServiceImpl;

@WebServlet("/student")
public class StudentControloer extends HttpServlet{

	//싱글톤인 서비스 참조하기
	private StudentService StudentService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		StudentService = StudentServiceImpl.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action == null) action = "list";
		
		/*
		 * list : 학생 목록
		 * push : 학생 등록
		 * fire : 학생 탈퇴
		 * view : 학생 보기
		 * kill : 여러명 탈퇴
		 */
		if(action.equals("list")) {
			
		}else if(action.equals("push")) {
			
			
		}else if(action.equals("fire")) {
			
			
		}else if(action.equals("view")) {
			
			
		}else if(action.equals("kill")) {
			
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	
}
