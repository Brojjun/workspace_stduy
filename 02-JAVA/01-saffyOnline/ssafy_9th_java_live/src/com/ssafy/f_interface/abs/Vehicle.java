// @@DELETE_FILE:
package com.ssafy.f_interface.abs;

public abstract class Vehicle {
  public int curX, curY;

  public void reportPosition() {
    System.out.printf("차종: %s: 현재 위치: (%d, %d)%n", this.getClass().getSimpleName(), curX, curY);
  }

  public abstract void addFuel();
    //System.out.printf("차종: %s: 연료 주입: %s%n", this.getClass().getSimpleName(), "뭘까?");
  
}
