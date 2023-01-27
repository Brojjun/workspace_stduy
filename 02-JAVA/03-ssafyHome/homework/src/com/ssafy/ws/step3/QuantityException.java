package com.ssafy.ws.step3;

public class QuantityException extends RuntimeException {

	public QuantityException() {
		super("수량이 부족합니다.");
	}

}
