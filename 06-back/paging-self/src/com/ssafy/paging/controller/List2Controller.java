package com.ssafy.paging.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.paging.model.Board;
import com.ssafy.paging.model.Page;
import com.ssafy.paging.model.service.Board1ServiceImpl;
import com.ssafy.paging.model.service.BoardService;

@WebServlet("/board/list2")
public class List2Controller extends HttpServlet {
	private BoardService service;
	public List2Controller() {
		service = Board1ServiceImpl.getInstance();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Page page = new Page();
			try {
				page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
			} catch(Exception e) {}
			
			//목록 페이지를 구성하기 위해서 목록에 출력될 데이터와 하단 페이지 번호 관련 data
			Map<String, Object> result = service.listBoard(page);
			List<Board> list = (List<Board>)result.get("list");
			int count = (Integer)result.get("count");
			request.setAttribute("list",list);
			//전체 게시물 갯수를 얻어와서 페이징 관리
			int lastPage = (int)Math.ceil(count / 10d);
			
			request.setAttribute("count", count);
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("pageNo",page.getPageNo());
			
			//현재 요청한 페이지에 해당하는 탭 위치, 탬 시작 페이지, 이전, 다음 여부
			int tabSize = 10;
			int curTab = (page.getPageNo() - 1) / tabSize + 1;
			int begin = (curTab - 1) * tabSize + 1;
			int end = (curTab * tabSize > lastPage) ? lastPage : curTab * tabSize;
			
			boolean prev = begin != 1;
			boolean next = end != lastPage;
			
			request.setAttribute("beginPage", begin);
			request.setAttribute("endPage", end);
			request.setAttribute("prev", prev);
			request.setAttribute("next", next);
			
			request.getRequestDispatcher("/jsp/board/list2.jsp")
			       .forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}










