package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@RestController 
public class BoardController {

  // log�� ����ϴ� ���� �غ�
  private static final Logger log = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    log.error("error.....");
    log.warn("warn.....");
    log.info("info.....");
    log.debug("debug.....");
    log.trace("trace.....");

    log.info("�Խǹ� ��� ��ȸ!");
    return new ResultMap().setStatus(SUCCESS).setData(boardService.list());
  }

  @RequestMapping("/board/add")
  public Object add(Board board, HttpSession session) {
    log.info("�Խñ� ���!"); // ��ڰ� Ȯ���ϱ⸦ ���ϴ� ����
    log.debug(board.toString()); // �����ڰ� Ȯ���ϱ⸦ ���ϴ� ����

    Member member = (Member) session.getAttribute("loginUser");
    board.setWriter(member);
    boardService.add(board);
    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return new ResultMap().setStatus(FAIL).setData("�ش� ��ȣ�� �Խñ��� �����ϴ�.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(board);
  }

  @RequestMapping("/board/update")
  public Object update(Board board, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    board.setWriter(member);
    int count = boardService.update(board);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("�Խñ� ��ȣ�� ��ȿ���� �ʰų� �Խñ� �ۼ��ڰ� �ƴմϴ�.");
    }
  }

  @RequestMapping("/board/delete")
  public Object delete(int no, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    Board board = new Board();
    board.setNo(no);
    board.setWriter(member);

    int count = boardService.delete(board);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("�Խñ� ��ȣ�� ��ȿ���� �ʰų� �Խñ� �ۼ��ڰ� �ƴմϴ�.");
    }
  }
}

