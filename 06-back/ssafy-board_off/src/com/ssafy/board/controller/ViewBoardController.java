package com.ssafy.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

@WebServlet("/board/view")
public class ViewBoardController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int articleNo = Integer.parseInt(request.getParameter("articelNo"));
		BoardDao dao = BoardDaoImpl.getBoardDao();
		dao.updateHit(articleNo);
		request.setAttribute("board", dao.viewArticle(articleNo));
		request.getRequestDispatcher("board/view.jsp")
				.forward(request, response);
		
		//response.sendRedirect(request.getContextPath()+ "/board/list");
		
	}

	
	
}
