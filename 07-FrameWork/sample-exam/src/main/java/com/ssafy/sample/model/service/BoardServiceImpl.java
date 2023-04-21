package com.ssafy.sample.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sample.model.Board;
import com.ssafy.sample.model.Dao.BoardDao;


@Service
public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao;
	
	
	public BoardServiceImpl(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectBoard();
	}

	@Override
	public Board detail(int no) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectByPk(no);
	}

	@Override
	public void delete(int no) throws Exception {
		boardDao.deleteBoard(no);
	}

	@Override
	public void write(Board board) throws Exception {
		boardDao.write(board);
		
	}

	@Override
	public void deleteAll(List<Integer>no) throws Exception {
		if(no.size() == 0)return;	
		for(int num : no)
			boardDao.deleteAll(num);
		
	}

}