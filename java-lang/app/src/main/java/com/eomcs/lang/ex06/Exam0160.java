package com.eomcs.lang.ex06;

import java.util.Scanner;

// if ~ else는 한문장이기 때문에 블록으로 묶지 않아도 된다.

public class Exam0160 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("나이를 입력하세요? ");
    int age = keyScan.nextInt();

    if (age < 8)
      System.out.println("아동입니다.");
    else {
      if (age < 14)
        System.out.println("어린이입니다.");
      else {
        if (age < 19)
          System.out.println("청소년입니다.");
        else {
          if (age < 65)
            System.out.println("성인입니다.");
          else
            System.out.println("노인입니다.");
        }
      }
    }

    keyScan.close();
  }
}
