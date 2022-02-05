// 예외 처리 전
// try with Resources 형식으로 씀 
package com.eomcs.exception.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam0110 {

  static Board read() {
    // RuntimeException의 자식이라 NumberformatException, IllegalArgumentException이라고 명시안해도 된다. 
    try (Scanner keyScan = new Scanner(System.in)) {
      Board board = new Board();

      System.out.print("번호> ");
      board.setNo(Integer.parseInt(keyScan.nextLine()));

      System.out.print("제목> ");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용> ");
      board.setContent(keyScan.nextLine());

      System.out.print("등록일> ");
      board.setCreatedDate(Date.valueOf(keyScan.nextLine()));

      return board;
    } 
  }

  public static void main(String[] args) {
    Board board = read(); // 번호, 제목, 내용, 등록일 입력받아서 그 객체를 생성하면 리턴
    System.out.println("---------------------");
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("등록일: %s\n", board.getCreatedDate());
  }
}


