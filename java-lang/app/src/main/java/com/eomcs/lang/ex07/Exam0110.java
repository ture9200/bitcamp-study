package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    //키보드를 스캐너와 연결 
    System.out.print("밑변의 길이? ");
    //사용자에게 출력을 하면서 밑변의 길이를 달라고 한다. 
    int len = keyScan.nextInt();
    // 사용자가 숫자를 입력하고 엔터를 치면 리턴
    keyScan.close();
    //keyscan은 필요하지 않으니 닫아버린다. 

    int starLen = 1;
    // 시작length 를 1부터 지정 
    while (starLen <= len) {
      // 별 앞에 공백 출력
      int spaceCnt = 1;
      int spaceLen = (len - starLen) / 2;
      // 공백은 전체 길이에서 출력할 별 갯수를 빼고 나누기 2 
      while (spaceCnt <= spaceLen) {
        // 1부터 length만큼 
        System.out.print(" ");
        //빈공간 출력 
        spaceCnt++;
      }

      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) {
        // 출력할 별 개수까지 반복 
        System.out.print("*");
        starCnt++;
      }

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;
      // 줄바꾸면서 두개 증가 
    }
  }
}