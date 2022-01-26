package com.eomcs.mylist.dao;

import java.io.File;
import com.eomcs.mylist.domain.Board;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Repository //= 저장소, 데이터 처리 
// 클래스에 이 에노티에션을 붙여 표시해두면, springboot가 이 클래스의 객체를 자동 생성한다. 
// 또한 이 객체를 원하는 곳에 자동으로 주입한다.
// 손대지않고 코드를 교체할 수 있다. =>더 편한 방식 , 의존객체 주입받기 (Dependency Injection)
public  class JsonBoardDao extends AbstractBoardDao {
  String filename = "boards.json";

  public JsonBoardDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      boardList.addAll(mapper.readValue(new File(filename), Board[].class));
      // mapper한테 파일정보 줄테니까 파일을 읽어서 board배열로 만들어서 리턴해줘 
      // boardlist에 주면 배열을 저장한다. 

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), boardList.toArray());
  }
}


