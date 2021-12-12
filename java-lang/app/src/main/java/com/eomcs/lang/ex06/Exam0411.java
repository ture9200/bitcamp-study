package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 반복문
//
public class Exam0411 {
  public static void main(String[] args) {
    // for (변수선언 및 초기화; 조건; 증감문) 문장;
    // for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

    // 증감문 제거
    for (int i = 1; i <= 5;) {
      // ; 빠뜨리면 안된다. => 에러
      // 증감문을 꼭 괄호안에 안써도 된다.
      System.out.println(i);
      i++;
    }

  }
}
