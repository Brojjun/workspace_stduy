package com.ssafy.month_test.board.model.dao;

import java.util.List;

import com.ssafy.month_test.board.model.Student;

public interface StudentDao {
	/*
	 * list : 학생 목록
	 * push : 학생 등록
	 * fire : 학생 탈퇴
	 * view : 학생 보기
	 * kill : 여러명 탈퇴
	 */
	
	List<Student> selectStudent() throws Exception;
	
	Student selectStudentByNo(int no) throws Exception;
	void insertStudent(Student student) throws Exception;
	
	void deleteStudent(int no) throws Exception;
	void deleteStudentAll() throws Exception;
	

	

	
}
