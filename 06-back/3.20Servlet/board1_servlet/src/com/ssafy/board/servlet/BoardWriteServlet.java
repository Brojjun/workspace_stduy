package com.ssafy.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 글제목, 글내용을 얻으세요.
		
//		2. 1의 data를 BoardDao의 writeArticle()메소드에 전달하고 DB에 insert 하세요.
		
//		3. 2의 결과에 따라 결과 화면을 출력하세요.
		
	}

}
