package com.ssafy.f_interface.abs;

// TODO: Vehicle을 상속받는 구조로 변경해보자.
public class DieselSUV extends Vehicle{
	public int curX = 4;
	
	@Override
	public void addFuel() {
		System.out.println("SUV 충전 꼴깍꼴깍꼴깍");
	}
	
}