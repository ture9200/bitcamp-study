package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test01 {

  public static void main(String[] args) throws Exception {
    String jsonStr = "{\"name\":\"소보루\",\"maker\":\"안데르센\"}";
    //json 문자열 준비 , {} =객체 , 이름: 소보루빵과 제조사: 안데르센 
    // "" 를 문자로 집어넣을 때는 반드시 \ , json은 반드시 "" 로 감싸야한다. 
    // 자바스크립트는 ' ' 가능

    ObjectMapper mapper = new ObjectMapper();

    Bread obj = mapper.readValue(jsonStr, Bread.class);
    // mapper에 readValue라는 메서드가 있고 jsonStr을 준다. 
    // 프로그램은 데이터를 만들어서 어떤 객체를 만들어야할지 readValue에 알려줘야한다. 
    // readValue에게 json문자열인데 문자열읽어서 어떤 객체로 만들어야할지 알려줘야한다. 
    // 빵객체로 만들어달라고 하기 위해서 bread.class를 두번째 파라미터에 넘겨야한다. 
    // 이걸 안넘겨주면 json문자열을 가져다가 어떤 객체로 저장해야하는지 알길이 없다. 
    System.out.println(obj); // 객체를 출력 

  }

}
