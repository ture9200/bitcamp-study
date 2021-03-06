// 인스턴스 초기화 블록(instance initializer) - 여러 개의 인스턴스 초기화 블록
package com.eomcs.oop.ex03;

public class Exam0740 {

  static class A {
    int a;
    int b;
    int c;

    // 여러 개의 인스턴스 초기화 블록이 있을 때,
    // - 선언된 순서대로 생성자의 앞 부분에 삽입된다.
    // - 바이트코드(Exam0740$A.class)를 확인해 보라!
    // - 초기화 블록을 실행한 다음에 생성자가 실행된다.
    {
      this.a = 101;
      System.out.println("첫 번째 인스턴스 초기화 블록");
    }

    {
      this.a = 102;
      System.out.println("두 번째 인스턴스 초기화 블록");
    }

    {
      this.a = 103;
      System.out.println("세 번째 인스턴스 초기화 블록");
    }

    A() {
      // 인스턴스 초기화 블록은 선언된 순서대로 삽입한다.
      // 즉 다음과 같다.
      // this.a = 101;
      // System.out.println("첫 번째 인스턴스 초기화 블록");
      // this.a = 102;
      // System.out.println("두 번째 인스턴스 초기화 블록");
      // this.a = 103;
      // System.out.println("세 번째 인스턴스 초기화 블록");

      System.out.println("A()");
      b = 200;
      c = 300;
    }
  }

  public static void main(String[] args) {
    A obj1 = new A();
    System.out.printf("a=%d, b=%d, c=%d\n", obj1.a, obj1.b, obj1.c);
  }
}


