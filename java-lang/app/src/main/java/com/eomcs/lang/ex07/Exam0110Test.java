package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110Test {
  static void printSpaces(int len) {
    // len = length 의 줄임말 
    int spaceCnt = 1;

    // len 갯수만큼 돌면서 공백을 출력 
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  //갯수만큼 별을 출력 
  static void printStars(int len) {
    int starCnt =1;
    while(starCnt <= len) {
      System.out.println("*");
      starCnt++;
    }
  }

  static int getSpaceLength(int total, int starLen) {
    return (total-starLen)/2;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    // 별 1개부터 최대 사용자가 입력한 갯수만큼 출력 
    for (int starLen=1; starLen <=len; starLen +=2) {

      // 별 앞에 공백 출력   
      printSpaces(getSpaceLength(len, starLen));
      // 별 갯수 출력 
      printStars(starLen); 

      // 출력 줄 바꾸기
      System.out.println();
    }
  }
}