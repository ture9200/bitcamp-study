package com.eomcs.lang.ex07;

// # 메서드 : 개념 및 기본 문법 II
//
public class Exam0221 {

  static void hello(String name, int age) {
    System.out.printf("%d살 %s님 반갑습니다.\n", age, name);
  }

  public static void main(String[] args) {
    // 파라미터의 타입, 개수, 순서가 일치해야 한다.

    //    hello("윤봉길"); // 컴파일 오류! => 파라미터 개수 일치해야함
    //    hello(20, "윤봉길"); // 컴파일 오류! => 파라미터 변수 순서 일치해야함 
    //    String r = hello("안중근", 30); // 컴파일 오류! => hello 는 리턴하지 않음 void이기 때문 
    //    void r = hello("안중근", 30); // 컴파일 오류! => void 변수 안됨 
  }
}
