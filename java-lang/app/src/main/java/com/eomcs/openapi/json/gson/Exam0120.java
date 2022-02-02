// JSON 문자열 --> 객체 : JSON 문자열을 해석하여 객체를 생성하기
package com.eomcs.openapi.json.gson;

import com.google.gson.Gson;

public class Exam0120 {
  public static void main(String[] args) {

    // 1) JSON 문자열 준비
    // " "을 일반 문자열로 사용할려면 \를 사용해야한다. 
    // 날짜를 프로그램을 실행하는 국가 언어에 맞춰서 다룬다.
    String jsonStr = "{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":\"1월 24, 2022\"}";

    // 2) JSON 처리 객체 준비
    Gson gson = new Gson();

    // 3) JSON 문자열을 가지고 객체 만들기
    // 클래스 변수명인데 안에 클래스 정보가 들어있다.
    // json으로부터 객체를 꺼낸다. 두번째 파라미터에 어떤 객체를 만들어 넣을건지 클래스 정보를 줘야한다. 
    Member m = gson.fromJson(jsonStr, Member.class);

    System.out.println(m);
  }
}





