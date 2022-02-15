// static nested class : 다른 멤버에 접근하기
package com.eomcs.oop.ex11.b;

class B {
  // 클래스 멤버
  static int v1;
  static void m1() {}

  // 인스턴스 멤버
  int v2;
  void m2() {}

  static void test() {
    B.v1 = 100;
    B.m1();

    // test() 메서드는 같은 멤버이기 때문에 
    // 다음과 같이 클래스 이름을 생략할 수 있다.
    v1 = 100;
    m1();

    // 스태틱 멤버는 this라는 빌트인 변수가 없기 때문에 
    // 인스턴스 멤버에 접근할 수 없다.
    // 스태틱 멤버는 인스턴스 변수를 사용할 수 없다. 
       v2 = 100; // 컴파일 오류!
    //    m2(); // 컴파일 오류!
  }

 
public class Exam0210 {

  public static void main(String[] args) {
 // 스태틱 멤버는 클래스명으로 접근 가능 
    // 이 클래스에 대해서 인스턴스를 만들고 인스턴스 주소를 가지고 스태틱 메서드를 호출할 수도 있지만 
    // 주소없이 그냥 클래스 이름으로 호출할 수도 있다. 
    // 무조건 클래스 이름으로 호출한다는거로 왠만하면 생각하기! 
    B.v1 =100;
    B.m1();
    B.test();
  }
  }
}
