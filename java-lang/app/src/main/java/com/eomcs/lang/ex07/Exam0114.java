package com.eomcs.lang.ex07;

import java.util.Scanner;

// 1단계: 공백 출력 코드를 메서드로 추출하기
// 2단계: 별을 출력하는 코드를 메서드로 추출하기
// 3단계: while 대신 for 문 사용하기
// 4단계: 공백 계산 식을 메서드로 추출하기
public class Exam0114 {

  static void printSpaces(int len) {
    for (int i = 0; i < len; i++) {
      System.out.print(" ");
    }
  }

  static void printStars(int len) {
    for (int i = 0; i < len; i++) {
      System.out.print("*");
    }
  }

  // 전체 별갯수에서 출력할 별 갯수 두개 파라미터를 주면 공백을 계산해서 리턴 
  static int getSpaceLength(int totalStar, int displayStar) {
    return (totalStar - displayStar) / 2;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(getSpaceLength(len, starLen));
      // 전체길이에서 현재출력할 별 갯수 두 개를 주면 공백이 얼마인지 알려주고 그 공백을 출력한다. 
      printStars(starLen);
      // 별 출력 
      System.out.println();
      //다음라인 간다. 
    }
  }
}




