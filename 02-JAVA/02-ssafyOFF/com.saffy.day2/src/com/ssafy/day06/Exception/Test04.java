package com.ssafy.day06.Exception;

class 물건사라지는Exception extends Exception{
	
}
class 사장{
	public void start()  {
		알바 alba = new 알바();
		try {
		alba.work();
		} catch(Exception e) {
			System.out.println("사장도 정리 중..");
			
		}
	}
}

class 알바 {
	public void work() throws 물건사라지는Exception {
		try {
			throw new 물건사라지는Exception();
		} catch(물건사라지는Exception e) {
			System.out.println("알바 정리 중...");
			throw e;
		}
	}
}
public class Test04 {
	public static void main(String[] args) {
		사장 boss = new 사장();
		boss.start();
	}
}
