package com.eomcs.mylist;

import java.sql.Date;
import java.util.Calendar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
  @RequestMapping("/board/list")
  public Object list() {
    return ArrayList3.toArray(); 
  }


  @RequestMapping("/board/add")
  public Object add(Board board) {
    // System.out.println(todo);
    Calendar calendar = Calendar.getInstance();
    Date d = new Date(calendar.getTimeInMillis());
    board.setDate(d);
    ArrayList3.add(board);
    return ArrayList3.size;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= ArrayList3.size ) {
      return 0;
    } 

    Board board2 = (Board)ArrayList3.get(index);
    if( board2.getTitle().equals(board.getTitle())) return 0;

    return ArrayList3.set(index ,board) == null ? 0 :1;
  }

  @RequestMapping("/board/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= ArrayList3.size) {
      return 0; //index가 무효해서 설정하지 못했다. 
    }

    ((Board)ArrayList3.list[index]).done = done;
    return 1; // 해당 항목의 상태를 변경했다. 
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= ArrayList3.size) {
      return 0;
    }

    ArrayList3.remove(index);  // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }

}

