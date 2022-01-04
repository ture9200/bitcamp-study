package com.eomcs.oop.ex02;

//1) 관련 메서드를 클래스로 묶는다. 
//2) 메서드에서 계산한 결과를 클래스 변수에 저장한다. 
//3) 인스턴스 변수로 바꿔서 결과를 개별적으로 관리한다.  
//4) 

public class ExamTest2 {

  public static void main(String[] args) {
    Calculator c1 = new Calculator(); 
    Calculator c2 = new Calculator();

    c1.plus(3);
    c2.plus(5);
    c1.minus(1);
    c2.minus(2);
    c1.multiple(7); 
    c2.multiple(8);
    c1.divide(3);
    c2.divide(4);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }

}


