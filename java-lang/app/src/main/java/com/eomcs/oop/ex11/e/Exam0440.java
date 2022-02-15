// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;

public class Exam0440 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  static void m1(A obj) { // m1이라는 메서드는 A 인터페이스 구현체를 요구 
    obj.print();
  }

  public static void main(String[] args) {

    // 1) 로컬 클래스 만들기
    // m1이라는 메서드에 A를 구현한 x라는 클래스를 만들고 넣어줄 수 있고
    // 로컬클래스 만들어서 넣는다. 
    class X implements A {
      @Override
      public void print() {
        System.out.println("XXXXX");
      }
    }
    m1(new X());

    // 2) 익명 클래스 만들기
    // 익명클래스를 정의한 후에 객체주소를 담아서 넣는것 
    A obj = new A() {
      @Override
      public void print() {
        System.out.println("익명 클래스!!!");
      }
    };
    m1(obj);

    // 3) 익명 클래스를 파라미터 자리에 바로 삽입
    // 실무에서 가장 많이 쓰이는 것 
    // A 인터페이스를 구현한 익명클래스를 정의한 후에 즉시 인스턴스를 만들고 
    // 그러면 이자리에 A 인터페이스를 구현한 익명클래스의 객체주소가 놓이는데 
    // 위에서  스태틱메서드에 받아서 Obj.print 하면  이게 호출된다.
    // 익명클래스를 파라미터로 넘기는게 아니라는걸 명심 
    // 객체주소가 넘어가는것이다 .
    m1(new A() {
      @Override
      public void print() {
        System.out.println("안녕!!!");
      }
    });

  }
}
