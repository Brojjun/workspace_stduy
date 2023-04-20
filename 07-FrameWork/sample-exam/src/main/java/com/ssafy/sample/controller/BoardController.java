package com.ssafy.sample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.sample.model.Board;
import com.ssafy.sample.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	@RequestMapping("/detail")
	public String detail(int no, Model model)throws Exception{
		Board board = boardService.detail(no);
		model.addAttribute("board", board);
		return "detail";
	}
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		List <Board> list = boardService.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/delete")
	public String delete(int no)throws Exception{
		boardService.delete(no);
		return "redirect:/board/list";
	}
	
	@GetMapping("/write")
	public String write()throws Exception{
		return "write";
	}
	
	@PostMapping("/write")
	public String wirte(Board board)throws Exception{
		boardService.write(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/deleteAll")
	public String deleteAll(@RequestParam(name = "no") List<Integer> no)throws Exception{
		System.out.println("이얏호");
		for(int a : no)System.out.println(no);
		boardService.deleteAll(no);
		return "redirect:/board/list";
	}
}
