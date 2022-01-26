package com.eomcs.mylist.dao;

import java.io.File;
import com.eomcs.mylist.domain.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Repository 
// 클래스에 이 에노티에션을 붙여 표시해두면, springboot가 이 클래스의 객체를 자동 생성한다. 
// 또한 이 객체를 원하는 곳에 자동으로 주입한다. 
public  class JsonContactDao extends AbstractContactDao {
  String filename = "contacts.json";

  public JsonContactDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      contactList.addAll(mapper.readValue(new File(filename), Contact[].class));

    } catch (Exception e) {
      System.out.println("연락처 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), contactList.toArray());
  }
}


