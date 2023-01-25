package com.ssafy.day06.Exception;

import java.util.Random;

class LottoNumberException extends RuntimeException{
	LottoNumberException(int num){
		super("지금 번호는 : "+num+"  로또 번호는 1 ~ 45 사이");
	}
	
	LottoNumberException(){
		super("로또 번호는 1 ~ 45 사이");
	}
}

class LottoService{
	private static final int MAX_NUM = 502; 
	//runtime에서는 throw가 없이 던지는거 가능은 하지만 -> 코드 가독성때문에 절대 하지마
	//runtime이 아니면 무조건 넣어야한다. 
	public int makeNumber() throws LottoNumberException{
		Random r = new Random();
		int num = r.nextInt(MAX_NUM) + 1;
		if(num > 45) {
			throw new LottoNumberException(num);
		}
		return num;
	}
}
public class Test08 {
	public static void main(String[] args) {
		
		LottoService game = new LottoService();
		
		try {
		System.out.println(game.makeNumber());
		} catch(Exception e) {
			System.out.println("로또 번호 예외 ㅠㅠ");
			e.printStackTrace();
		}
	}
}
