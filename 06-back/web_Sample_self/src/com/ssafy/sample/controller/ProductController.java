package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;
import com.ssafy.sample.model.service.ProductServiceImpl;

@WebServlet("/product")
public class ProductController extends HttpServlet{
	ProductService productservice = ProductServiceImpl.getInstance();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("regist")) {
			Product product = new Product();
			product.setCode(request.getParameter("code"));
			product.setModel(request.getParameter("model"));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			try {
				productservice.regist(product);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("/error/error.jsp");
			}
			response.sendRedirect("/product?action=list");
		}
		else if(action.equals("registForm")) {
			request.getRequestDispatcher("/product/regist.jsp").forward(request, response);
		} else if(action.equals("list")) {
			try {
				request.setAttribute("products", productservice.list());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("/error/error.jsp");
			}
			request.getRequestDispatcher("/product/list.jsp").forward(request, response);
		} else if(action.equals("deatil")) {
			String code = request.getParameter("code");
			try {
				request.setAttribute("prodcut", productservice.detail(code));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("/error/error.jsp");
			}
			request.getRequestDispatcher("/product/deatail.jsp");
			
		
		}
	}

	
	
}
