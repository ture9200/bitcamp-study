package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {

  //Board 객체 목록을 저장할 메모리를 준비한다. 
  ArrayList boardList = new ArrayList();

  @RequestMapping("/board/list")
  public Object list() { //클라이언트 요청을 처리한다. 
    return boardList.toArray(); // 배열을 다룬다. 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {
    // Calendar calendar =Calendar.getInstance();
    //현재 시간을 일반 시간이 아닌 요일, 오전/오후 등인 달력 기준으로 표기해주는 방식이다.  
    //board.setCreatedDate(new Date(System.currentTimeMillis()));
    //함수를 사용해서 현재 시간을 받아오고 board 에 날짜를 설정하라는 뜻. 
    boardList.add(board);
    return boardList.size();
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if(index < 0 || index >= boardList.size()) {
      return "";
    }
    Board board = (Board)boardList.get(index);
    // board 리스트 항목을 Board로 형변환해서 board에 저장한다. 
    board.setViewCount(board.getViewCount()+1);
    // board의 조회수를 하나씩 늘린다. 
    return board;
    // 그렇게 해서 ArrayList의 항목을 리턴한다. 
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if(index < 0 || index >= boardList.size()) {
      return 0;
    }
    Board old = (Board)boardList.get(index);
    // boardlist 항목들을 Board로 형변환해서 old에 저장한다. 
    board.setViewCount(old.getViewCount());
    // 기존조회수를 viewCount에 담고 
    board.setCreatedDate(old.getCreatedDate()); 
    // 기존 날짜도 게시글 날짜에 저장이 된다. 

    return boardList.set(index, board) == null ? 0 :1; //한번 더 거르겠다는 말!! 
  }


  @RequestMapping("/board/delete")
  public Object delete(Board board, int index) {
    if(index < 0 || index >= boardList.size()) {
      return 0;
    }
    return boardList.remove(index) == null ? 0:1;  // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
  }
}

