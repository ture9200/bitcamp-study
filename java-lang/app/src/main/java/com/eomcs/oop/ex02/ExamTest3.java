package com.eomcs.oop.ex02;

public class ExamTest3 {
  //인스턴스 생성없이 static클래스로만 쓰이는 예시 
  // 메모리를 1개 써서 가능하고
  // 여러개 사용하려면 new()인스턴스로 넣어줘야한다. 

  static class Score{
    String name;
    static int kor = 900;
    int eng;
    int math;
    int sum;
    float average;
    static void Test() {
      System.out.printf("score test 입니다." + kor);
    }
  };

  public static void main(String[] args) {

    Score.Test();
  }
}

