package com.ssafy.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mybatis.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

public class MemberTest extends UnitTestConfig {

	private final Logger log = org.slf4j.LoggerFactory.getLogger(MemberTest.class);

	@Autowired
	private MemberService memberService;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("----- Class Test Start!!! -----");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("----- Class Test End!!! -----");
	}

	@Before
	public void beforeMethod() {
		System.out.println("----- Method Test Start!!! -----");
	}

	@After
	public void afterMethod() {
		System.out.println("----- Method Test Snd!!! -----");
	}
	
	@Test
	@Ignore
	public void nullTest() {
		log.debug("nullttes");
		assertNotNull(memberService);
		log.debug("memberService : {}",memberService);
		
	}
	
	@Test
	@Ignore
	public void dbConnectionTest() throws SQLException{
		
		DataSource dataSource = context.getBean(DataSource.class);
		Connection conn = dataSource.getConnection();
		assertNotNull(conn);
		log.debug("db connection success : {}", conn);
	}
	
	@Test
	public void loginTest() throws Exception {
		Map<String,String> map = new HashMap<>();
		map.put("userid","ssafy");
		map.put("userpwd","1234");
		MemberDto memberDto = memberService.loginMember(map);
		assertNotNull(memberDto);
		assertEquals(memberDto.getUserName(), "김싸피");
	}
}
