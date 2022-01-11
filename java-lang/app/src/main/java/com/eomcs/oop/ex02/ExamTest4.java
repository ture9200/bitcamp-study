package com.eomcs.oop.ex02;

public class ExamTest4 {
  ////번외로 실무에 쓰이는 단위테스트 예 ) 
  // 단위테스트: Score 같은 내부 클래스 없이 메서드를 생성하는 것 

  static class Score{

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

  };

  int kor = 900;
  public void print_kor() {
    System.out.println("kor: " + kor);
  }
  int eng = 900;
  public void print_eng() {
    System.out.println("eng: " + eng);
  }

  public static void main(String[] args) {

    Score score = new Score();
    score.name = "홍길동";
    score.kor = 100;
    score.eng = 80;
    score.math = 90;
    score.sum = score.kor +score.eng + score.math;
    score.average = score.sum/3.0f;

    ExamTest4 examTest1 = new ExamTest4();
    examTest1.print_kor();
    examTest1.print_eng();


    System.out.printf("%s,%d,%d,%d,%d,%.1f\n",
        score.name,score.kor,score.eng,score.math,score.sum,score.average);
  }
}

