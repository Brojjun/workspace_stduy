package com.ssafy.first.xml;

import java.security.Provider.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.first.xml.controller.BoardController;
import com.ssafy.first.xml.model.service.BoardService;
import com.ssafy.first.xml.model.service.Dao.BoardDao;

public class Test {
	public static void main(String[] args) {
		
		// Bean	Factory => ApplicationContext(Interface)
		ApplicationContext container = new ClassPathXmlApplicationContext(
				"xml/first-exam2.xml");
		
		String names[] = container.getBeanDefinitionNames();
		
		for(String name : names)System.out.println(name);
		
		BoardController controller = (BoardController)container.getBean("boardController");
		
		BoardService service = container.getBean("boardService",BoardService.class);
		
		BoardDao dao = container.getBean(BoardDao.class);
		
		System.out.println(service);
		System.out.println("우와아아 성공했다!!!");
	}
}
