package com.ssafy.f_interface.abs;

public class VehicleTest {

  public static void main(String[] args) {
    // TODO: DieselSUV와 ElectricCar를 각각 한대씩 관리하는배열을 만들고 사용해보자.
    // END:
	  Vehicle[] car = new Vehicle[3];
	  car[0] = new HorseCart();
	  car[1] = new ElectirCar();
	  car[2] = new DieselSUV();
	  
	  for(int i = 0; i < 3; i++) {
		 car[i].addFuel();
		 
	  }
  }

}
