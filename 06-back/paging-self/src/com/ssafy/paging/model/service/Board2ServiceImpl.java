package com.ssafy.paging.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.ldap.PagedResultsControl;

import com.ssafy.paging.model.Board;
import com.ssafy.paging.model.Page;
import com.ssafy.paging.model.PageResult;
import com.ssafy.paging.model.dao.BoardDao;
import com.ssafy.paging.model.dao.BoardDaoImpl;

public class Board2ServiceImpl implements BoardService {
	private static BoardService boardService = new Board2ServiceImpl();
	private BoardDao dao;
	private Board2ServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	public static BoardService getInstance() {
		return boardService;
	}
	@Override
	public Map<String, Object> listBoard(Page page) throws Exception {
		Map <String, Object> result = new HashMap<>();
		
		result.put("list", dao.selectBoard(page));
		result.put("pageResult", new PageResult(page.getPageNo(), dao.selectBoardCount()));
		return result;
	}
}
