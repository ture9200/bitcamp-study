// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;

class My { // Top Level Class 
  static void m1() {
    System.out.println("오호라!!!!!!");
  }
  
   void m2() {
    System.out.println("와우~~~~~~~!");
  }
}

public class Exam0450 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A { // 추상클래스 불가능 
    void print();
    //void test();
    //default void test();
  }

  // 로컬클래스 
  static A create1() {
    class X implements A {
      @Override
      public void print() {
        System.out.println("Hello!");   
      }
    }
    return new X();
  }
  
  // 실무에서 많이 쓰임
  // A라는 인터페이스를 구현한 익명클래스를 정의한후 즉시 객체를 생성한다. 
  // 이때 클래스는 수퍼클래스 생성자다. 
  // 인터페이스를 구현한다는 뜻은 익명클래스를 정의할 때 
  // 인터페이스에 있는 메서드를 오버라이딩해야한다. 
  static A create2() {
    return new A() {
      @Override
      public void print() {
      System.out.println("Hello2!");
      }
    };
  }
  
  // 함수 인터페이스 (functional interface) : 메서드 1개짜리 인터페이스 
  // 람다 문법으로 표현 
  // 메서드 인터페이스 블럭을 벗겨낸다. 
  // 메서드 선언부에 있는 오버라이딩문 지운다. 
  // 파라미터와 블럭사이에 화살표를 집어넣는다. 
  // 문장이 하나일경우 중괄호를 벗겨낼수 있다. 
  // 맨끝에 세미콜론도 뺀다. 
  // 최종적으로 코드를 한줄로 정의하면 아래와 같다. 
  // 인터페이스를 구현한 객체고 람다 문법으로 정의 
    static A create3() {
      return() -> System.out.println("Hello3!");
    }
    
    
    static A create4() {
      return My::m1; 
      // My클래스에 M1이라는 스태틱 메서드가 있는데 
      // 리턴값이 없고 파라미터가 없다. 
      // M1은 스태틱메서드 => 클래스 이름으로 지정
      
      // 인터페이스 구현체로 쓰려면 메서드를 한개만 갖고 있어야하고 
      
      // 메서드 두개만 갖고 있어도 되는 상황이라면 DEFAULT 메서드로 미리 구현되있는거라면
      // 구현되지 않는 추상메서드가 한개면 가능 
      // 추상클래스는 안된다. 
      // 추상메서드가 1개인 인터페이스는 된다. 
      // 추상메서드가 2개면 안된다. 
      //람다 문법, 메서드 레퍼런스는 오직 인터페이스만 가능하다.
      
          //System.out.println("Hello4!");
    }

    static A create5() { //메서드 레퍼런스 
      // M2는 인스턴스 메서드 => 인스턴스 주소로 지정해야함. 
      return new My()::m2;
          //System.out.println("Hello4!");
    }
    
  public static void main(String[] args) {
    A obj1 = create1();
    obj1.print();
    
    A obj2 = create1();
    obj2.print();
    
    A obj3 = create1();
    obj3.print();
    
    A obj4 = create4(); 
    obj4.print();
    
    A obj5 = create5();
    obj5.print();
  }
  
 
}
