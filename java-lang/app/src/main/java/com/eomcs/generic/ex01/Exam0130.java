// 제네릭(generic) 적용 전 - 메서드에 제네릭 적용하기
package com.eomcs.generic.ex01;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Exam0130 {

  // 제네릭을 이용하면 여러 타입을 모두 수용할 수 있는 메서드를 만들 수 있다.
  //    <다루는_타입_별명>  다루는_타입_별명 메서드명(다루는_타입_별명 파라미터, ...) {...}
  //    예) <What> What test(what obj) {..}
  //
  // 다음 메서드를 해석하기
  // => echo() 메서드가 다루는 타입을 "What"라고 가정하자!
  // => echo()는 What라는 타입의 파라미터 값(객체주소)을 받고,
  //    What라는 타입의 객체(주소)를 리턴한다.
  // => 즉 What이 무슨 타입인지는 메서드가 호출될 때 넘겨주는 파라미터로 결정된다.
  // => 제네릭을 사용하면 특정 타입을 다루는 메서드 여러 개를 한 개의 메서드로 줄일 수 있다.
  // => 이때 "What"을 가리키는 용어로 "타입(이름을 받는) 파라미터"라고 부른다.
  //
  static <What> What echo(What obj) { // What 타입의 값을 리턴  
    // <What> 을 빼버리면 진짜 클래스나 인터페이스가 된다. => 변수명인것을 가리키기위해 <What> 표시 
    // 넘어오는 값에 따라서 결정되는 타입 파라미터다. 
    
    return obj;
  }

  public static void main(String[] args) {

    // 한 개의 메서드를 가지고 다양한 용도의 메서드를 사용할 수 있고 형변환 필요없다. 
    String obj1 = echo(new String("Hello")); //String 넘기니 리턴타입 String 
    Date obj2 = echo(new Date()); //Date 넘기니 리턴타입 Date 
    Calendar obj3 = echo(Calendar.getInstance()); //Calendar 넘기니 리턴타입 Calendar
    File obj4 = echo(new File("okok")); //File 넘기니 리턴타입 File 
    Integer obj5 = echo(Integer.valueOf(100)); //Integer 넘기니 리턴타입 Integer 
  }
}

// # 제네릭의 타입 파라미터로 많이 사용하는 이름
// - 보통 긴 이름을 사용하지 않고 다음과 같이 한 개의 대문자로 된 이름을 많이 사용한다.
//
// T - Type이라는 의미를 표현할 수 있어 많이 사용하는 이름이다.
// E - Element라는 의미로 목록의 항목을 가리킬 때 사용한다.
// K - Key 객체를 가리킬 때 사용한다.
// N - Number의 의미로 숫자 타입을 가리킬 때 주로 사용한다.
// V - Value의 의미로 값의 타입을 가리킬 때 사용한다.
// S,U,V 등 - 한 번에 여러 타입을 가리킬 때 두 번째, 세 번째, 네 번째 이름으로 주로 사용한다.
//
// 그러나 이름을 짓는 것은 개발자 마음이다.
// 다만, 다른 개발자와의 원활한 소통을 위하여
// 가능한 위의 규칙에 따라 이름을 사용하기 바란다.
