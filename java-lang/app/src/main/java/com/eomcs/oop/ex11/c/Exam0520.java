// inner class : 바깥 클래스의 인스턴스를 보관할 this 변수와 생성자 II
package com.eomcs.oop.ex11.c;

class F {
  class X {
    // 컴파일러는 모든 생성자에
    // 바깥 클래스의 객체 주소를 받는 파라미터를 추가한다.
    X() {}
    // => 바깥 객체의 주소를 받는 생성자
    // => .class 파일의 내용
    //    F$X(com.eomcs.oop.ex11.c.F arg0);
    //        0  aload_0 [this]
    //        1  aload_1 [arg0]
    //        2  putfield com.eomcs.oop.ex11.c.F$X.this$0 : com.eomcs.oop.ex11.c.F [10]
    //        5  aload_0 [this]
    //        6  invokespecial java.lang.Object() [12]
    //        9  return
    //         Line numbers:
    //           [pc: 0, line: 8]
    //         Local variable table:
    //           [pc: 0, pc: 10] local: this index: 0 type: com.eomcs.oop.ex11.c.F.X
    // => 즉 컴파일러는 다음 코드로 변경한다.
    //    이런 식으로 바뀌었다 하더라도 이렇게 호출할 수는 없다. 
    //    X(F arg0) {}

    X(int a) {}
    // => int 값을 받는 생성자는 앞부분에 바깥클래스의 객체 주소를 받는 파라미터가 추가 
    // => 즉 컴파일러는 다음 코드로 변경한다.
    //    X(F arg0, int a) {}

    X(String s, int a) {}
    // => String과 int 값을 받는 생성자는 바깥클래스의 객체 주소를 받는 F arg0 추가 
    // => 즉 컴파일러는 다음 코드로 변경한다.
    //    X(F arg0, java.lang.String s, int a) {}
  }
}

public class Exam0520 {

  public static void main(String[] args) {
    F outer = new F();

    // 중첩 클래스의 인스턴스를 생성할 때,
    // 컴파일러는 바깥 클래스의 객체 주소를 생성자의 첫 번째 파라미터로 전달한다.
    // 즉 컴파일러가 만든 생성자를 호출하도록 코드를 변환한다.
    //
    F.X obj = outer.new X();
    // => invokespecial com.eomcs.oop.ex11.c.F$X(com.eomcs.oop.ex11.c.F) [25]
    // => 예) new X(outer)
    //

    F.X obj2 = outer.new X(100);
    // => invokespecial com.eomcs.oop.ex11.c.F$X(com.eomcs.oop.ex11.c.F, int) [28]
    // => 예) new X(outer, 100)
    //

    F.X obj3 = outer.new X("kim", 100);
    // => invokespecial com.eomcs.oop.ex11.c.F$X(com.eomcs.oop.ex11.c.F, java.lang.String, int) [33]
    // => 예) new X(outer, "kim", 100);
  }

}
