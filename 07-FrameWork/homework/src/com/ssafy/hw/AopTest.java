package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		User user = (GeneralUser) context.getBean("generalUser");
		System.out.println("**********1. GeneralUser을 사용합니다. ***********");
		try {
			user.useApp();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user2 = (AdminUser) context.getBean("adminUser");
		System.out.println("**********2. AdminUser을 사용합니다. ***********");
		try {
			user2.useApp();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
