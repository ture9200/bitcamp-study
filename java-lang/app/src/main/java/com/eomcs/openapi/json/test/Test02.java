package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test02 {

  public static void main(String[] args) throws Exception {
    //    String jsonStr = "[{\"name\":\"소보루\",\"maker\":\"안데르센\"},{\"name\":\"단팥빵\",\"maker\":\"안데르센\"}]";
    //    String jsonStr = "[{\"name\":\"소보루\",\"maker\":\"안데르센\"}]";
    //    대괄호로 감싼다. 
    //    배열안에 한개 들어있으면 한개 출력, 두개 들어있으면 두개 출력 
    //    빈 배열도 에러가 안뜬다.  
    String jsonStr = "[]";

    ObjectMapper mapper = new ObjectMapper();

    Bread[] arr = mapper.readValue(jsonStr, Bread[].class);
    // 배열로 만들어달라고 할때는 반드시 [] 로 해줘야한다. 

    for (Bread obj : arr) {
      System.out.println(obj);
    }

  }

}