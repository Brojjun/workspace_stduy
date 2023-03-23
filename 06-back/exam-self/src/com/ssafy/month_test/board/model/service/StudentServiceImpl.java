package com.ssafy.month_test.board.model.service;

import java.util.List;

import com.ssafy.month_test.board.model.Student;
import com.ssafy.month_test.board.model.dao.StudentDaoImpl;
import com.ssafy.month_test.board.model.dao.StudentDao;
public class StudentServiceImpl implements StudentService {
	private static StudentServiceImpl instance = new StudentServiceImpl();
	
	//Dao 싱글톤 가져오기
	private StudentService studentservice = new StudentServiceImpl();
	private StudentDao studentDao = StudentDaoImpl.getStudentDaoImpl();
	
	public static StudentServiceImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public List<Student> list() throws Exception {
		
		return null;
	}

}
