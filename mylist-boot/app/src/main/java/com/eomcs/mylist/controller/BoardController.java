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
    boardDao.insert(board);
    return boardDao.countAll();
  }


  @RequestMapping("/board/get")
  public Object get(int index) throws Exception {
    //예외발생하니까 던진다. 데이터 처리는 Dao에게 맡긴다. 
    Board board = boardDao.findByNo(index); // 인덱스 번호를 찾는다. 
    // 조회할때마다 예전 게시물을 가져온다. 

    if (board == null) {
      return "";
    }
    // 보내기전에 count를 update 해야한다. 
    boardDao.increaseViewCount(index);// 조회활때마다 update 해야한다. 
    // save(); => save는 dao가 할 일이다. 
    // index 주면서 조회수 증가시키라고 boardDao에게 명령 
    // 기존 index에 있는 오리지널 데이터를 가져와서 
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) throws Exception {
    //update하면 예외가 발생하니까 메서드 호출한 스프링부트보고 알아서하라고 한다.
    Board old = boardDao.findByNo(index); // 기존 index에 있는 오리지널 데이터를 가져온다. 
    if (old == null) {
      return 0;
    }
    board.setViewCount(old.getViewCount()); // 조회수 데이터 설정 
    board.setCreatedDate(old.getCreatedDate()); // 등록일 데이터 설정 
    return boardDao.update(index, board); // 위 정보를 담아서 객체를 넘긴다. 
    //dao는 원래 있던 데이터를 바꾸는 건 맡기고 새로운데이터를 만드는건 controller가 한다. 
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) throws Exception {
    // 예외발생하면 delete를 호출한 스프링부트에게 알아서 하라고 한다. 
    return boardDao.delete(index);
  }


}


