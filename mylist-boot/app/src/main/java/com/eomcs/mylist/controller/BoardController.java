package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {

  @Autowired
  //필드 선언부에 이 애노테이션을 붙여서 표시해 두면, SpringBoot를 실행될 때 
  // SpringBoot가 BoardConroller 객체를 만들 때 BoardDao 구현체를 찾아 자동으로 주입한다. 

  BoardDao boardDao;

  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll();  //실무에서 목록을 리턴받을때 findAll 많이 쓰인다. 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) throws Exception {
    //스프링부트보고 알아서 하라고 한다. 

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardDao.insert(board); //boardDao에 board를 insert하라 
    return boardDao.countAll(); //boardDao에 현재 몇개 저장했는지 countAll해서 리턴 
  }


  @RequestMapping("/board/get")
  public Object get(int index) throws Exception { // indexㄹ
    //예외발생하니까 던진다. 데이터 처리는 Dao에게 맡긴다. 
    Board board = boardDao.findByNo(index); // 인덱스 번호를 찾는다. 
    // 조회할때마다 예전 게시물을 가져온다. 

    if (board == null) { // 만약 board가 못찾으면 
      return ""; // 빈 문자열을 리턴 
    }
    // 보내기전에 count를 update 해야한다. 
    boardDao.increaseViewCount(index);// count를 증가시킨다.  
    // save(); => save는 dao가 할 일이다. 
    // index 주면서 조회수 증가시키라고 boardDao에게 명령 
    // 기존 index에 있는 오리지널 데이터를 가져와서 
    return board; // board를 리턴 
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) throws Exception {
    //update하면 예외가 발생하니까 메서드 호출한 스프링부트보고 알아서하라고 한다.
    Board old = boardDao.findByNo(index); // 기존 index에 있는 오리지널 데이터를 가져온다. 
    if (old == null) { //오래된걸 못찾았다면 
      return 0;  //0을 리턴 
    }
    board.setViewCount(old.getViewCount()); // 찾았으면 변경데이터에 기존 조회수 데이터 넣고  
    board.setCreatedDate(old.getCreatedDate()); // 그리고 변경데이터에 등록일 데이터 넣고 
    return boardDao.update(index, board); // 찾은 위치에 새로 바뀐 board를 업데이트하라. 
    //dao는 원래 있던 데이터를 바꾸는 건 맡기고 새로운데이터를 만드는건 controller가 한다. 
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) throws Exception {
    // 예외발생하면 delete를 호출한 스프링부트에게 알아서 하라고 한다. 
    return boardDao.delete(index); 
    //delete에 index를 주면 정상적으로 삭제했으면 1, 삭제못했으면 0 
  }
}


