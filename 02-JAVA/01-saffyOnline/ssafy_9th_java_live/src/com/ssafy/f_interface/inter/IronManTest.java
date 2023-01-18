// @@DELETE_FILE:
package com.ssafy.f_interface.inter;

public class IronManTest {

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    IronMan iman = new IronMan();
    Object obj = iman;
    Heroable hero = iman;
    Fightable fight = iman;
    Transformable trans = iman;
  }
}
