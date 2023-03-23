package com.ssafy.self.student.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.self.student.model.Student;
import com.ssafy.self.student.model.service.StudentService;
import com.ssafy.self.student.model.service.StudentServiceImpl;

@WebServlet("/student")
public class StudentController extends HttpServlet {

	// 서비스 참조하기
	private StudentService studentService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		studentService = StudentServiceImpl.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) action = "list";
		
		/*
		 * list : 학생 목록
		 * push : 학생 등록
		 * fire : 학생 탈퇴
		 * view : 학생 조회
		 * kill : 학생 여러명 탈퇴
		 */
		String path = "";
		switch (action) {
		case "list":
			path = list(request, response);
			forward(request, response, path);
			break;
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		request.getRequestDispatcher(path)
		 	   .forward(request, response);
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Student> studentList = studentService.list();
			request.setAttribute("studentList", studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/student-list.jsp";
	}
	
}







