package com.eomcs.mylist.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import com.eomcs.mylist.domain.Board;

//인터페이스를 직접 구현하는 대신에 AbstractBoardDao를 상속받는다. 
public class BinaryBoardDao extends AbstractBoardDao {
  String filename = "boards.bin"; // 파일명은 인스턴스에 준비 
  //ArrayList boardList = new ArrayList(); // 변수 선언 = 변수를 만들라는 명령!

  public BinaryBoardDao() {
    try {
      // 입출력이 바이트단위로 이루어져서 FileInputStream을 사용  
      // 데이터타입으로 읽을때  DataInputStream 쓰면 더 편하게 읽고 쓸 수 있다. 
      DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

      // 저장된 데이터 개수를 읽어 온다. 
      int len = in.readInt(); // 4바이트를 읽어온다. 

      // 게시글 개수만큼 읽는다.
      for (int i = 0; i < len; i++) { //len 만큼 읽는다. 
        Board board = new Board();     // 읽은 데이터를 저장할 board객체 준비 
        board.setTitle(in.readUTF());  // title을 읽는다. 
        board.setContent(in.readUTF());  //내용을 읽는다. 
        board.setViewCount(in.readInt());  // 조회수를 읽는다. 
        board.setCreatedDate(Date.valueOf(in.readUTF())); // 날짜를 문자열로 읽는다. 
        // 문자열을 날짜 객체로 바꿀때 Date.valueOf =>YYYY-MM-DD 
        // 객체를 만들어주는 메서드 => 공장 메서드(Factory Method) 

        boardList.add(board); // Board객체에 담아서 boardlist에 add시킨다. 
      }

      in.close();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    //출력할때 binarystream이니까 FileOutputStream 사용 
    //버퍼단위로 데이터를 다루는 기능이 없어서 버퍼기능을 데코레이터로 BufferedOutputStream 
    //문자열, boolean값 등 출력하는 기능이 없어서 DataOutputStream (데코레이터)
    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));

    // 게시글 개수를 먼저 출력한다.
    out.writeInt(boardList.size());

    // 게시글을 순차적으로 출력한다.
    for (int i = 0; i < boardList.size(); i++) { // boardList에 들어있는 만큼 개수를 출력 
      Board board = (Board) boardList.get(i); 
      out.writeUTF(board.getTitle()); // 문자열가져와서 제목 출력 
      out.writeUTF(board.getContent()); // 내용 출력 
      out.writeInt(board.getViewCount()); // 조회수 출력 
      out.writeUTF(board.getCreatedDate().toString()); // 문자열로 YYYY-MM-DD 출력 
    }
    out.flush(); // 버퍼에 남아있는거 출력 

    out.close(); // FLUSH 호출하지 않아도 CLOSE 호출할때 자동으로 FLUSH 된다. 
  }
}
