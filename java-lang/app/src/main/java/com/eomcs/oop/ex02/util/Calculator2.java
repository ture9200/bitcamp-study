package com.eomcs.oop.ex02.util;

public class Calculator2 {
  public int result = 0; 

  public void plus (int value) { 
    this.result += value;
  }

  public void minus (int value) {
    this.result -= value;
  }

  public void multiply (int value) {
    this. result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }

  public int getResult() {
    // TODO Auto-generated method stub
    return this.result;
  }
}
