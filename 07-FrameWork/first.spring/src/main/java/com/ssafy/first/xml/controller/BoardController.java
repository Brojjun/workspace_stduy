package com.ssafy.first.xml.controller;

import com.ssafy.first.xml.model.service.BoardService;

public class BoardController {
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("BoardController() 생성자 호출");
	}
	
	
	public void setController(BoardService boardService) {
		System.out.println("BoardController(Service) set 호출");
		this.boardService = boardService;
	}
	
	
	public BoardController(BoardService boardService) {
		System.out.println("BoardController(Service) 생성자 호출");
		this.boardService = boardService;
	}

	@Override
	public String toString() {
		return "BoardController [boardService=" + boardService + "]";
	}
	
	
}