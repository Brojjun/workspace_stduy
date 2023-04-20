package com.ssafy.hw.todomvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.hw.todomvc.model.Todo;
import com.ssafy.hw.todomvc.model.service.TodoService;
// WEB-INF/views/todo/index.jsp
@RequestMapping("/todo")
@Controller
public class TodoController {
	
	private final TodoService todoService;
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
		System.out.println("Todo컨트롤러 생성 완료");
	}
	
	//사용자 url 적용  // get,post전부 가능하다.
//	@RequestMapping("/todo/list")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String listTodo(Model model) throws Exception {
		model.addAttribute("list", todoService.listTodo());
		return "todo/index";
			
	}
	
	@RequestMapping(value="/regist",method = RequestMethod.POST)
	public String registTodo(Todo todo) throws Exception {
		todoService.registTodo(todo);
		System.out.println(todo);
		//return "redirect:todo/list";

		return "redirect:/todo/list";	
	}
	
	@RequestMapping(value="/clear")
	public String clearTodo() throws Exception {
		todoService.clearTodo();
		return "redirect:/todo/list";	
	}
	
	@RequestMapping(value="/destory")
	public String destoryTodo(int no) throws Exception {
		todoService.deleteTodo(no);
		return "redirect:list";	
	}
	
}


