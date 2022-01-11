package com.eomcs.oop.ex02;

public class ExamTest1 {
  //1) 사용자 정의 데이터 타입을 만든다.
  //2) 인스턴스 값을 다룰 calculate() 연산자를 스태틱 메서드로 만든다.
  //3) calculate() 연산자를 논스태틱 메서드로 바꾼다.
  static class Score{
    // 변수 선언 : 데이터 타입을 설계 
    //이름, 국어 영문 수학 합계 평균 
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

  }

  public static void main(String[] args) {

    //Score 객체 생성해서 score 변수에 값 집어넣기 
    Score score = new Score();
    score.name = "홍길동";
    score.kor = 100;
    score.eng = 80;
    score.math = 90;
    score.sum = score.kor +score.eng + score.math;
    score.average = score.sum/3.0f;

    //출력하기 
    System.out.printf("%s,%d,%d,%d,%d,%.1f\n",
        score.name,score.kor,score.eng,score.math,score.sum,score.average);
  }
}

