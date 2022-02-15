// static nested class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.b;

class A {
  static class X {

  }
}

public class Exam0110 {

  public static void main(String[] args) {
    // 레퍼런스 선언
    // 소스 코드를 쉽게 관리하기 위해 
    // 스태틱 메서드 사용하듯이 클래스 이름으로 접근해서 쓸 수 있다. 
    // 안드로이드 버튼 OnClickListener 에서 한번 봤다. (마우스 클릭에 대한 이벤트 => OnClickListener) , 안드로이드 예제에서 볼 수 있음. 
    // 맨 앞이 대문자 ,자바는 변수나 메서드는 소문자로 시작함
    //  이벤트 처리 함수가 On으로 시작함
    // 특정 클래스 안에서만 사용하려고 만들거나 관리차원에서 쉽게 관리하기 위해서 클래스 안에 묶어둔다. 
    A.X obj;

    // 인스턴스 생성
    obj = new A.X();
  }

}
