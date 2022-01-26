package com.eomcs.mylist.dao;

import java.io.File;
import com.eomcs.mylist.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Repository 
//클래스에 이 에노티에션을 붙여 표시해두면, springboot가 이 클래스의 객체를 자동 생성한다. 
//또한 이 객체를 원하는 곳에 자동으로 주입한다. 
public class JsonBookDao extends AbstractBookDao {
  String filename = "books.json";
  //ArrayList boardList = new ArrayList(); // 변수 선언 = 변수를 만들라는 명령!

  public JsonBookDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      bookList.addAll(mapper.readValue(new File(filename), Book[].class));

    } catch (Exception e) {
      System.out.println("독서록 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), bookList.toArray());
  }
}


