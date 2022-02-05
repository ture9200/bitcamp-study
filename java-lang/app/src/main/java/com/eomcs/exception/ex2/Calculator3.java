// 예외 처리 문법을 적용한 후 - 오류일 때 예외 정보를 별도로 호출자에게 전달한다.
package com.eomcs.exception.ex2;

public class Calculator3 {

  public static int compute(String op, int a, int b) {
    switch (op) {
      case "+": return a + b;
      case "-": return a - b;
      case "*": return a * b;
      case "/": return a / b;
      case "%": return a % b;
      default:
        // 유효하지 않은 연산자인 경우 throw 명령을 이용하여 호출자에게 
        // 오류 상황을 알린다.
        // RuntimeException = 실행중에 발생된 예외를 던질때 사용하는 클래스 
        // RuntimeException이라는 상자에다가 예외정보를 담아서 던진다. 
        // 적절한 상자를 사용하는게 중요! 
        throw new RuntimeException("해당 연산자를 지원하지 않습니다.");
    }
  }
}
