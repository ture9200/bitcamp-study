// JSON 문자열 --> 객체 : JSON 문자열에는 클래스 정보가 없다.
package com.eomcs.openapi.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0130 {
  public static void main(String[] args) throws Exception {

    // 1) JSON 문자열 준비
    // 날짜경우 gson 형식과 동일하면 에러가 발생되어 gson형식으로 사용했을때 출력값 millis 를 넣어준다. 
    // 날짜경우 문자열 아니니까 더블 쿼테이션 붙이지 않는다.
    String jsonStr = "{\"no\":100,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"password\":\"1111\",\"photo\":\"hong.gif\",\"tel\":\"010-2222-1111\",\"registeredDate\":1642991177846}";

    // 2) JSON 처리 객체 준비
    ObjectMapper mapper = new ObjectMapper();

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
    // - 주의! 
    //   Gson과 달리 JSON 프로퍼티에 해당하는 객체프로퍼티가 없다면 예외가 발생한다.  
    //   @JsonIgnoreProperties 에노테이션을 사용하여 JSON 프로퍼티 중에서 무시할 항목을 지정해야 한다. 
    //   Member정보를 Board 객체에 담기 
    Board b = mapper.readValue(jsonStr, Board.class);

    System.out.println(b);
  }
}





