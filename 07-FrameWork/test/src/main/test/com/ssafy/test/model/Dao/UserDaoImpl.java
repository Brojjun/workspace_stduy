package com.ssafy.test.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.test.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	public UserDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public User selectLogin(User user) throws SQLException {
		try (
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement
						("select id, password, name from user where id = ? and password = ?");
				){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User userinfo = new User();
				userinfo.setId(rs.getString("id"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				return userinfo;
			}
			
		}
		return null;
	}

}
