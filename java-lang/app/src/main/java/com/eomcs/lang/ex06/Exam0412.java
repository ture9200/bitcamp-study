package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 반복문
//
public class Exam0412 {
  public static void main(String[] args) {
    // for (변수선언 및 초기화; 조건; 증감문) 문장;
    // for (변수선언 및 초기화; 조건; 증감문) {문장1; 문장2; ...}

    // 변수 선언 및 초기화 문장 제거
    int i = 1; // 1로 초기
    for (; i <= 5;) {
      System.out.println(i);
      i++;
    }

    // for 문을 종료한 후에도 i 변수를 사용할 수 있다.
    // 바깥에 int i=1 이 선언되었기 때문
    // 똑같이 참인 동안만 실행
    System.out.println(i);
  }
}
