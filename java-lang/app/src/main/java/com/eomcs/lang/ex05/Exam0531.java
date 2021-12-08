package com.eomcs.lang.ex05;

// # 조건 연산자 => ? :
//
public class Exam0531 {
  public static void main(String[] args) {

    int age = 20;

    // 조건 연산자의 결과 값이 왼편의 변수 타입과 일치해야 한다.
    // => 결과 값이 없거나 타입이 일치하지 않으면 문법 오류!
    // String str = age > 18 ? System.out.println("성인이다.") : System.out.println("미성년자이다.");

    // 표현식 자리에는 문자가 되었든 숫자가 되었든
    // 실행 결과가 놓여져야 한다.
    // 위의 System.out.println(...) 문장은 결과를 리턴하지 않는다.
    // 그래서 컴파일 오류이다.

    // =>왼쪽 편의 변수 타입과 표현식의 결과 타입이 같아야 한다.
    // int result = age > 18 ? "성인" :"미성년";
  }
}


