// anonymous class - 생성자
// 인터페이스를 구현한 익명클래스 

package com.eomcs.oop.ex11.e;

public class Exam0210 {

  interface A {
    void print();
  }
  
  // 모든 생성자에 공통으로 들어가는 코드가 있다면 
  // 인스턴스 블럭을 만들고 공통으로 들어간 코드를 
  // 초기화 블럭에 집어넣어라! 
  
  // 컴파일러가 컴파일할 때 인스턴스 블럭에 있는 코드를 생성자 앞부분에 들어간다. 
  //(인스턴스 블럭은 사라진다) 
  // 결국 생성자가 호출될 때 그 인스턴스 블럭에 있는게 먼저 실행된다는 얘기가 나온다.
//  class x{
//    public x() {
//      System.out.println("ABC!");
//      System.out.println("Hello!");
//    }
//    
//    public x(int a) {
//      System.out.println("ABC!");
//      System.out.println("Hello!");
//    }
//    
//    public x(String s) {
//      System.out.println("ABC!");
//      System.out.println("Hello!");
//    }
//  } //java-lang/bin/main/com/eomcs/oop/ex11/e/Exam0210$X.class
  
  public static void main(final String[] args) {

    A obj = new A() {

      // 1) 익명 클래스는 생성자를 직접 정의할 수 없다.
      // - 그러나 컴파일러가 컴파일할 때 익명 클래스의 생성자를 만든다.
      //
      // 2) 대신 인스턴스 블록으로 생성자를 대신한다.
      // - 인스턴스 블록에 작성한 코드는
      //   결국 컴파일러가 자동 생성한 생성자에 들어간다.
      // - 그래서 인스턴스 블록에 작성한 코드가 실행될 것이다.
      {
        System.out.println("익명 클래스의 인스턴스 블록 실행!");
      }

      @Override
      public void print() {
        System.out.println("Hello!");
      }

    };
  }
}

// 수퍼 클래스 생성자 호출
// - 모든 클래스의 생성자는 항상 수퍼 클래스의 생성자를 먼저 호출한다.
// - 인터페이스를 구현한 익명 클래스는 java.lang.Object 클래스를 상속 받는다.
// - 따라서 익명 클래스의 생성자는 Object 클래스의 생성자를 먼저 호출한다.
//
