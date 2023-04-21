package com.ssafy.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.test.model.Product;
import com.ssafy.test.model.service.ProductService;

@Controller
@RequestMapping("/Product")
public class ProductController {
	
	private ProductService boardService;
	
	public ProductController(ProductService boardService) {
		super();
		this.boardService = boardService;
	}
	
	
}
