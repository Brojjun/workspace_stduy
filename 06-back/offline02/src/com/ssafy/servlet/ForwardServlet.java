package com.ssafy.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/forward")
public class ForwardServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//문자열 메시지
		// 시간정보
		req.setAttribute("msg", "데이터 공유 설정 테스트");
		req.setAttribute("time", new Date());
		
		//데이터를 사용할 화면 페이지로 이동 : forward
		// /로 시작하는 경로를 설정하는 경우 프로젝트 패스 다음부터 적용
		// http://localhost:8080/ProPath/servlet/forward
		// http://localhost:8080/PrjPath + /servlet/forward.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/servlet/forward.jsp");
		rd.forward(req, resp);
	}
}
