package com.ssafy.self.student.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.self.student.model.Student;
import com.ssafy.self.util.DBUtil;

public class StudentDaoImpl implements StudentDao {

	private static StudentDao instance = new StudentDaoImpl();
	private DBUtil dbUtil;
	private StudentDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}	
	public static StudentDao getInstance() {
		return instance;
	}
	
	@Override
	public List<Student> selectStudent() throws SQLException {
		List<Student> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getConnection();
			pstmt = con.prepareStatement(
					"select no, name, gender, region "
							+ "  from student "
							+ " order by name "
			);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setNo(rs.getInt("no"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setRegion(rs.getString("region"));
				list.add(s);
			}
		} finally {
			dbUtil.close(rs, pstmt, con);
		}
		return list;
	}
	/*
	@Override
	public List<Student> selectStudent() throws SQLException {
		try (
				Connection con = dbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"select no, name, gender, region "
								+ "  from student "
								+ " order by name "
						);
				) {
			List<Student> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setNo(rs.getInt("no"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setRegion(rs.getString("region"));
				list.add(s);
			}
			return list;
		} 
	}
	*/
	@Override
	public Student selectStudentByNo(int no) throws SQLException {
		return null;
	}

	@Override
	public void insertStudent(Student student) throws SQLException {

	}

	@Override
	public void deleteStudent(int no) throws SQLException {

	}
}
