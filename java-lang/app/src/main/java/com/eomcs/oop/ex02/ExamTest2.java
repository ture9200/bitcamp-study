package com.eomcs.oop.ex02;

//1) 관련 메서드를 클래스로 묶는다.
//2) 메서드에서 계산한 결과를 클래스 변수에 저장한다.
//3) 인스턴스 변수로 바꿔서 결과를 개별적으로 관리한다.
//4) 인스턴스 메서드로 바꿔서 인스턴스 주소를 this 변수에 받는다.
//5) 클래스를 별도의 소스 파일로 분리한다.
//6) 클래스를 패키지로 분류한다.

public class ExamTest2 {

  public static void main(String[] args) {
    // 인스턴스 변언 선언 
    int result = 0;

    // 메서드 호출해서 result 변수에 담기 
    result = plus(2,3);// 2+3
    result = minus(result ,1);//결과값 -1 
    result = multiple(result, 7);//결과값 *7
    result = divide(result,3);// 결과값 /3

    //결과값 출력 
    System.out.printf("result= %d\n",+result);
  }

  static int plus (int a, int b) {return a + b;}// plus 메서드 선언 

  static int minus (int a , int b) {return a - b;}//minus 메서드 선언 

  static int multiple (int a, int b) {return a * b;}// multiple 메서드 선언 

  static int divide(int a, int b) { return a / b;}//divide 메서드 선언 

}
