package com.ssafy.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import sun.print.PrinterJobWrapper;

@WebServlet("/servlet/exam06")
public class Exam06 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서비스 중 입니당.....");
		/*
		 * 응답하는 문서의 타입 설정 및 인코딩
		 * 응당 객체 얻기
		 * 응답 내용 작성 후 전송
		 * 
		 * MINE
		 * 
		 * main/sub
		 */
		
		resp.setContentType("text/html"); // 서버에서 전송하는 내용이 어떤건지 클라이언트 브라우저에게 알려준다.
		//text/plain이면 html인식 x / text/html이면 html 인식O
//		OutputStream out1 = resp.getOutputStream(); //바이트 단위 출력
		
		req.setCharacterEncoding("charset=utf-8");
		resp.setContentType("text/html;charset=uft-8"); // 서버에서 전송하는 내용이 어떤건지 클라이언트 브라우저에게 알려준다.
		resp.setContentType("text/xml;charset=uft-8"); // 서버에서 전송하는 내용이 어떤건지 클라이언트 브라우저에게 알려준다.
		resp.setCharacterEncoding("utf-8");
		PrintWriter out2 = resp.getWriter(); // 문자 단위 출력
		out2.print("success");
		out2.print("<h2>success</h2>");
		out2.print("<family><me>짱구</me></family>");
		out2.close();
		
		
	}
}
