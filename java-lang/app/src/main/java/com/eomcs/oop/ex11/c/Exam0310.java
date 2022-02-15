// inner class : 다른 멤버가 중첩 클래스 사용하기
// 항상 inner class는 바깥 클래스의 인스턴스 주소가 있어야 인스턴스 생성 가능

package com.eomcs.oop.ex11.c;

class C {

  static void m1() {
    // 스태틱 멤버는 인스턴스 멤버를 사용할 수 없다.
    // 따라서 static 블럭에서 inner class 객체를 만들 수 없다
    //
    X obj; // 레퍼런스 선언은 가능!

        obj = new X(); // 컴파일 오류! 인스턴스 생성 불가능!

    // 이유?
    // - 인스턴스 멤버를 사용하려면 인스턴스 주소가 있어야 한다.
    // - 스태틱 메서드는 인스턴스 주소를 담고 있는 this 변수가 존재하지 않는다.
  }

  void m2() {
    // 인스턴스 메서드는 C클래스의 인스턴스 주소를 담고 있는 this 변수가 있다.
    // 그래서 inner class 를 사용할 수 있다.
    X obj = this.new X();
    obj.test();

    X obj2 = new X(); // 인스턴스 필드나 메서드와 마찬가지로 this를 생략할 수 있다.
    // 인스턴스 메서드에서는 inner class의 객체를 마음대로 만들 수 있다.
    obj2.test();
  }

  class X {
    void test() {
      System.out.println("X.test()");
    }
  }
}

public class Exam0310 {

  public static void main(String[] args) {
    C.m1();

    C outer = new C(); // null 이면 유효한 주소가 넘어가지 않아 에러가 발생. 
    
    
    // 이미 this에 인스턴스 주소가 들어 있다는 전제가 성립
    //    반드시 인스턴스 주소가 있기 때문에 m2가 호출된 거임
    //    전제 조건을 가정하고 프로그래밍 짜기
    outer.m2();
  }

}
