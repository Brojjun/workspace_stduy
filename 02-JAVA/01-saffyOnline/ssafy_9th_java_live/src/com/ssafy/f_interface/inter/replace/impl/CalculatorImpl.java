// @@DELETE_FILE:
package com.ssafy.f_interface.inter.replace.impl;

import com.ssafy.f_interface.inter.replace.Calculator;

public class CalculatorImpl implements Calculator {
  public int add(int a, int b) {
    System.out.printf("파라미터 확인: %d, %d%n", a, b);
    return a + b;
  }
}
