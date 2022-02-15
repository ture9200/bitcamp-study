// inner class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.c;

class X {} // Top Level Class = 패키지 멤버 클래스 

class A {

  class X { // inner class = non-static class 
    // 컴파일러는 inner 클래스를 컴파일 할 때 다음과 같이 
    // - 바깥 클래스의 인스턴스 주소를 저장할 필드를 추가하고,
    // - 바깥 클래스의 인스턴스의 주소를 파라미터로 받는 생성자를 만든다.
    // 중첩클래스는 기본으로 static 을 붙여야한다. 그다음에 붙일지 말지를 고민해야한다. 
    // static을 뗀다는 건 바깥 클래스의 인스턴스를 쓴다는 것을 참고 
    //    A outer;
    //    public X(A obj) {
    //      this.outer = obj;
    //    }
  }

}

public class Exam0110 {

  public static void main(String[] args) {
    // 레퍼런스 선언
    A.X obj;

    // 인스턴스 생성
    //    obj = new A.X(); // 컴파일 오류! 바깥 클래스의 인스턴스 주소 없이 생성 불가! 

    //1) 바깥 클래스의 인스턴스 준비
    A  outer = new A();

    //2) 바깥 클래스의 인스턴스 주소를 사용하여 inner class의 인스턴스 생성
    obj = outer.new X(); // => 컴파일러는 다음 코드로 변경한다. new.A.X(outer) 

    // 컴파일러는 컴파일 할 때 다음과 같이 
    // - 바깥 클래스의 객체를 생성자에 전달하는 코드로 변경한다.
    //    obj = new X(outer); 직접 이렇게 쓰지 말라 

  }

}
