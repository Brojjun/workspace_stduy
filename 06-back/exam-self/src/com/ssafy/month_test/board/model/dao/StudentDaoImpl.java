package com.ssafy.month_test.board.model.dao;

import java.util.List;

import com.ssafy.month_test.board.model.Student;
import com.ssafy.month_test.board.model.service.StudentService;

public class StudentDaoImpl implements StudentDao {
	
	static private StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	
	public static StudentDaoImpl getStudentDaoImpl() {
		return studentDaoImpl;
	}



	@Override
	public List<Student> selectStudent() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectStudentByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStudent(Student student) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(int no) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudentAll() throws Exception {
		// TODO Auto-generated method stub

	}

}
