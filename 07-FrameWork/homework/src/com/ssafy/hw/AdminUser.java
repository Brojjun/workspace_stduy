package com.ssafy.hw;

import java.util.Random;

public class AdminUser implements User {

	
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useApp() throws ApplicationException {
		System.out.println("애플리케이션을 관리합니다.");
		int n = new Random().nextInt();
		//예외 발생 코드 
		 if((n & 1) == 0) {
			 throw(new ApplicationException());
		 }
	}

}
