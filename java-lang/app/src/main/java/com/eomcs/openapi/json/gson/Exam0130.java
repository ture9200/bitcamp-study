// JSON 문자열 --> 객체 : JSON 문자열에는 클래스 정보가 없다.
package com.eomcs.openapi.json.gson;

import com.google.gson.Gson;

public class Exam0130 {
  public static void main(String[] args) {

    // 1) JSON 문자열 준비
    // " "을 일반 문자열로 사용할려면 \를 사용해야한다.
    // 날짜를 프로그램을 실행하는 국가 언어에 맞춰서 다룬다.
    String jsonStr = "{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":\"1월 24, 2021\"}";

    // 2) JSON 처리 객체 준비
    Gson gson = new Gson();

    // 3) JSON 문자열을 가지고 객체 만들기
    // - JSON 문자열에서 프로퍼티 이름과 일치하는 필드가 객체에 있다면 값을 설정해 준다. 
    // - 예)
    //   JSON 문자열     ------>   Board 객체
    //     no                         no
    //     name                       X
    //     email                      X
    //     password                   X
    //     photo                      X
    //     tel                        X
    //     registeredDate             registeredDate
    // 
    Board b = gson.fromJson(jsonStr, Board.class);

    System.out.println(b);
  }
}





