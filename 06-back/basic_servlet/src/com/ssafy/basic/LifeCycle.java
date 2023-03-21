package com.ssafy.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/life")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
        super();
        System.out.println("Construction call~!~!");
    }


	@Override 
	public void destroy() {
        System.out.println("Destroy call~!~!");
		super.destroy();
	}


	@Override
	public void init() throws ServletException {
        System.out.println("Init call~!~!");
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Service call~!~!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
