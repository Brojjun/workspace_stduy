package com.ssafy.f_interface.abs;

// TODO: Vehicle을 상속받는 구조로 변경해보자.

class ElectirCar extends Vehicle{
	public int curX = 2;
	@Override
	public void addFuel() {
		System.out.println("전기차 충전은 지지이이이이잉");
	}
}