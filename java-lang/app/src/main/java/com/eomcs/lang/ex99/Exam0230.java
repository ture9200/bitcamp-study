package com.eomcs.lang.ex99;

// # 키보드 입력 받기 - int, float, boolean 값 읽기
//
public class Exam0230 {
  public static void main(String[] args) {
    java.util.Scanner keyScan = new java.util.Scanner(System.in);

    System.out.print("int: ");
    int i = keyScan.nextInt();
    // nextInt()는 한 개의 토큰(token)을 읽을 때가지 기다린다.
    // 한 개의 token을 읽으면 4바이트 정수 값으로 바꾼 다음에 리턴한다.
    // 토큰(token)?
    // => 토큰이란 공백으로 구분되는 단어를 뜻한다. "통행허가코드"
    // 예: 100 3.14 true => 3개의 토큰 문자열로 구분되는 것
    // 공백(whitespace)?
    // => 스페이스(space), 탭, 줄바꿈(엔터) 코드를 말한다.
    // 예) aaa bbb cc ==> aaa, bbb, cc
    // 중간에 여러 개의 공백이 들어가더라도 한 개의 공백으로 간주한다.

    System.out.print("float: ");
    float f = keyScan.nextFloat();
    // 뒤에 f 붙이지 말아야한다.
    // 정수를 넣어도 된다. => 뒤에 소수점 이하 숫자가 0000으로 뜬다.

    System.out.print("boolean: ");
    boolean b = keyScan.nextBoolean();
    // 대문자 true/false 로 입력해도 소문자로 출력
    // 1 넣는거 안됨. 스프링부트랑 다르게 동작한다는것을 기억.

    keyScan.close();

    System.out.printf("%d, %f, %b\n", i, f, b);
  }
}


