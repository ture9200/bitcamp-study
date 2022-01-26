// 인터페이스 다중 구현이 불가한 경우!
package com.eomcs.oop.ex09.c;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import com.eomcs.oop.ex09.c.Exam0110.ProtocolImpl;

public class Exam0310 {

  interface ProtocolA {
    void rule1();
    default void rule3() {
      System.out.println("**ProtocolA. rule3()**");
    }
  }

  interface ProtocolB {
    void rule2();
    default void rule3() {
      System.out.println("====> ProtocolB. rule3()");
    }
  }

  //  class ProtocolImpl implements ProtocolA, ProtocolB {
  //    // ProtocolA 입장에서는 rule0() 규칙 준수!
  //    // ProtocolB 입장에서는 rule0() 규칙을 준수하지 못했다.
  //    // - 리턴 타입이 다르다.
  //    @Override
  //    public void rule3() {}
  //
  //    // ProtocolB 입장에서는 rule0() 규칙 준수!
  //    // ProtocolA 입장에서는 rule0() 규칙을 준수하지 못했다.
  //    // - 리턴 타입이 다르다.
  //    @Override
  //    public int rule0() {return 0;}
  //
  //    // 두 메서드를 모두 정의하면 되지 않을까?
  //    // - 메서드 오버로딩 문법 상 리턴 타입만 다른 메서드를
  //    //   동시에 정의할 수 없다.
  //
  //    // ProtocolA 규칙 준수!
  //    @Override
  //    public void rule1("ProtocolImpl.rule1()") {
  ClassOpt}
//

//    // ProtocolB 규칙 준수!
//    @Override
//    public void rule2() {}

//    @Override
//    public void rule3() {}
//  }

public static void main(String[] args) {
  ProtocolImpl obj;
  obj = new ProtocolImpl();
  obj.rule1();
  obj.rule2();
  obj,rule3();
}
}







