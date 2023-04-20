package com.ssafy.first.xml.model.service;

import com.ssafy.first.xml.model.service.Dao.BoardDao;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public String toString() {
		return "서비스 성공";
	}
	
}
