// 예외 던지고 받기
// 호출한다음에 다시 거꾸로 리턴된다. 
package com.eomcs.exception.ex4;

public class Exam0110 {
  static void m1() {
    m2();
  }

  static void m2() {
    m3();
  }

  static void m3() {
    m4();
  }

  static void m4() {
    System.out.println("m4() 실행됨!");
  }

  public static void main(String[] args) {
    m1();

  }

}
