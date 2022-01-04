package com.eomcs.lang.ex07;

import java.util.Scanner;

// 1단계: 공백 출력 코드를 메서드로 추출하기
public class Exam0111 {

  //static 끼리 호출할 수 있다. 
  //static 안붙은거는 안붙은거끼리 호출할 수 있다. 

  //공백 출력하기 
  static void printSpaces(int len) {
    // void = 리턴하지 않겠다. 작업만 하겠다. 
    // 이름을 지을때 동사구 형태를 쓴다. 
    // 파라미터로 공백들을 출력하는 작업에 필요한 정보를 받을 변수 선언 
    int spaceCnt = 1;
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  public static void main(String[] args) {
    // static 메서드는 같은 static 메서드만 호출할 수 있다. 
    // static이 안붙어있는 메서드는 안붙어있는 메서드만 호출할 수 있다. 
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    int starLen = 1;
    while (starLen <= len) {
      printSpaces((len - starLen) / 2);

      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
      }

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
    }
  }
}