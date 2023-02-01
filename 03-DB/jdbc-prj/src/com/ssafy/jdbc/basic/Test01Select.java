package com.ssafy.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.PreparableStatement;



public class Test01Select {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		try {
			
			// 1. 드라이버 등록
			//오류나는 경우 : 드라이버를 안가지고 오고 쓰거나(빌드패스 등록 x), 경로 문자열이 다르거나
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("정상로딩");
			
			// 3. 실행할 쿼리 생성
			StringBuffer sql = new StringBuffer();
			sql.append("select employee_id, last_name, salary ");
			sql.append("from employees ");
			sql.append("order by salary desc limit 5 ");
			System.out.println(sql.toString());
	
			try(
					// 2. 드라이버 연결
					//Connection 인터페이스 사용
					//서버시간 받는 API
					//auto close를 위해 try()에 선언
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezon=UTC","ssafy", "ssafy");
					//4. 실제 실행할 객체 생성
				PreparedStatement stmt = con.prepareStatement(sql.toString());
				) 
			{
				System.out.println("드라이버 : " + con);
				//반환 타입이 다름
				ResultSet rs = stmt.executeQuery(); // (실행)select + return 실행된 결과
				//stmt.executeUpdate(); // select 이외
				
				//rs.next()는 다음 줄로 넘아가기 + 다음 줄이 있으면 true 리턴 or 없으면 false 리턴
				while(rs.next()) {
					Employee e = new Employee();
					
					e.setEmployeeId(rs.getInt("employee_id"));
					e.setLastName(rs.getString("last_name"));
					e.setSalary(rs.getDouble("salary"));
					list.add(e);
					//System.out.println(immId + "\t" + lastNmae + "\t" + salary);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list.toString());
			ObjectMapper mapper = new ObjectMapper();
			String a = mapper.writeValueAsString(list);
			System.out.println(a);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
