// 오버라이딩(overriding) - 리턴 타입
package com.eomcs.oop.ex06.c;

public class Exam0610 {

  static class Car {}
  static class Sedan extends Car {}
  // static class Truck extends Car {} => 오버라이딩 안된다. 
  // 같거나 sub클래스는 허락한다. 
  static class Tico extends Sedan {}

  static class CarFactory {
    Car create() {
      return new Car(); // Sedan, Tico를 리턴할 수도 있다. 
    }
  }

  static class SedanFactory extends CarFactory {
    // 리턴타입이 달라도 오버라이딩이 가능한가? 
    // 오버라이딩 메서드의 리턴 타입은 
    // 서브 클래스(서브타입이라고 부르기도 한다.) 도 가능하다.
    @Override
    Sedan create() {
      return new Sedan();
      //return new String();
    }
  }

  static class TicoFactory extends SedanFactory {
    // 오버라이딩 메서드의 리턴 타입은 
    // 서브 클래스도 가능하다.
    @Override
    Tico create() {
      return new Tico();
    }
  }


  public static void main(String[] args) {

  }
}








