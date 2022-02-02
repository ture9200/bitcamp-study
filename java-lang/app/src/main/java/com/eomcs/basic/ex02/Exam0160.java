// String - mutable vs immutable 객체
// 기술면접에서 mutable과 imutable 차이를 묻는게 나온다. 
// mutable: 값을 설정하면 값을 바꿀수 있는 객체 (예: StringBuffer, StringbBuilder) 
// immutable: 값을 한번 설정하면 바꿀 수 없는 객체 (예: String 클래스) 
package com.eomcs.basic.ex02;

public class Exam0160 {
  public static void main(String[] args) {
    // String 객체는 immutable 객체이다.
    // 즉 한 번 객체에 값을 담으면 변경할 수 없다.

    String s1 = new String("Hello");

    // String 클래스의 메서드는 원본 인스턴스의 데이터를 변경하지 않는다. 
    // 다만 새로 String 객체를 만들 뿐이다.
    String s2 = s1.replace('l', 'x');
    System.out.println(s1 == s2);
    System.out.printf("%s : %s\n", s1, s2); // 원본은 바뀌지 않는다.

    String s3 = s1.concat(", world!");
    System.out.printf("%s : %s\n", s1, s3); // 원본은 바뀌지 않는다.
  }
}





