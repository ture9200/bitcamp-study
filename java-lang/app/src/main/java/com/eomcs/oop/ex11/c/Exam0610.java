// inner class : inner 클래스에서 변수를 찾는 순서
package com.eomcs.oop.ex11.c;

class G {
  int v1 = 1;
  int v2 = 2;
  int v3 = 3; 

  class X {
    int v1 = 10;
    int v2 = 20;

    void m1(int v1) {
      // 이 메서드를 호출했을 때 바깥 클래스의 인스턴스 변수값을 다루고 싶다. 
      // inner class 는 컴파일할 떄 this$0 필드 생성 
      // 컴파일러는 생성자가 만약에 있다면  
      // 기본 생성자에 바깥 클래스 객체 주소를 받을 파라미터를 추가할 것이고 
      // 만약에 int값을 받는 파라미터가 있다면  
      // 기존 생성자앞부분에 바깥클래스의 객체주소를 담는 변수를 추가할것이다. 
      // 만약에 생성자가 없다면 컴파일러가 기본 생성자를 만드는데 
      // 바깥 객체주소를 받을 생성자를 만들거고 그안에 컴파일러는
      // 파라미터로 받을 바깥 클래스의 객체주소를 내부에 자동생성한 이 변수에 
      // 저장하도록 this$0= arg0; 코드를 자동추가할 것이다. 
      // 메서드를 호출했을 때 바깥 클래스의 필드나 메서드를 사용하고 싶다면
      // this$0  변수로 접근하면 된다. 
      // 문제는 이변수는 임의의 변수, 컴파일러가 자동생성한것이기 때문에 
      // 바깥클래스 주소의 필드 값이 뭔지를 모르기 때문에 약속이 되어있기를 
      // 바깥클래스의 변수를 사용하고 싶다면 바깥클래스명.this 라고 적으면
      // 바깥클래스 객체주소가 저장되어있는 변수를 가리킨다. 
       

      // 중첩 클래스의 메서드에서 필드를 사용하기 
      System.out.println("G 객체:");
      System.out.printf("G.this.v1 = %d\n", G.this.v1);
      System.out.printf("G.this.v2 = %d\n", G.this.v2);
      System.out.printf("G.this.v3 = %d\n", G.this.v3);

      System.out.println("-------------------------");

      // inner 클래스의 인스턴스 필드 접근
    // 만약 바깥클래스 G 를 생략해버린다면 전혀 다른의미가 된다. 
      //m1이라는 메서드를 호출했을 때 x객체주소를 가리킨다. 
      
      System.out.println("G.X 객체:");
      System.out.printf("this.v1 = %d\n", this.v1);
      System.out.printf("this.v2 = %d\n", this.v2);

      System.out.println("-------------------------");

      // 로컬 변수 접근
      // 바깥클래스명과 this를 생략해버리면 가장 가까운 로컬변수를 가리킨다. 
      System.out.println("로컬:");
      System.out.printf("v1 = %d\n", v1);

      System.out.println("-------------------------");
    }
  }
}

public class Exam0610 {

  public static void main(String[] args) {
    G outer = new G();

    G.X obj = outer.new X();
    obj.m1(100);

  }

}
