// 인터페이스 - 기본 메서드(default method)
package com.eomcs.oop.ex09.b;

interface MyInterface3 { 
  // int a; //오류! , public, static, final 이 생략 
  // int a= 100; 

  void m1(); //public, static, abstract 생략 

  // default method:
  // - 기존 프로젝트에 영향을 끼치지 않으면서 기존 규칙에
  //   새 메서드를 추가할 때 유용한다.
  // - 인터페이스에서 미리 구현한 메서드이기 때문에
  //   클래스에서 구현을 생략할 수 있다.
  // - 반대로 구현을 강제할 수 없다는 것이 단점이다.
  default void m2() { //추상메서드가 아니다. 
    //System.out.println(this.a); => a가 italic체인데 italic체인것은 static 변수라 앞에 this가 올수 없다. 클래스이름이 와야한다. 
    System.out.println("MyInterface3.m2()");
    // 어차피 새 메서드는 새 프로젝트의 구현체가 오버라이딩 할 것이니
    // 여기에서는 자세하게 정의하지 않는다.
    // 다만 이 인터페이스를 구현한 예전 프로젝트에 영향을 끼치지 않으면서
    // 새 메서드를 정의할 때 사용하는 문법이다.
  };

  default void m3() {
    System.out.println("MyInterface3.m3()");
  };
}

// 2) 인터페이스 구현
class MyInterface3Impl implements MyInterface3 { //~impl이라는 클래스: 인터페이스이름+클래스 , 뜻: 인터페이스를 구현한 클래스 )

  // 추상 메서드는 반드시 구현해야 한다.
  @Override
  public void m1() {
    System.out.println("MyInterfaceImpl.m1()");
  }

  // default 메서드는 오버라이딩(재정의) 해도 되고 안해도 된다.
  @Override
  public void m2() {
    System.out.println("MyInterfaceImpl.m2()");
  }

  // default 메서드는 오버라이딩 해도 되고 안해도 된다.
  // => m3() 는 이 클래스에서 오버라이딩을 하지 않았다. 구현되었기때문이다. 
}

public class Exam03 {

  public static void main(String[] args) {
    MyInterface3 obj = new MyInterface3Impl();

    obj.m1();
    obj.m2();
    obj.m3();
  }

}
