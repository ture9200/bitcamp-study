package com.eomcs.mylist.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.util.ArrayList;

//@Repository
public class SerialBoardDao extends AbstractBoardDao {

  String filename = "boards.ser";
  //ArrayList boardList = new ArrayList(); // 변수 선언 = 변수를 만들라는 명령!

  public SerialBoardDao() {
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));

      boardList = (ArrayList) in.readObject(); // 객체를 왕창 저장하고 읽는다. 
      in.close();
    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
    out.writeObject(boardList); 
    out.flush();
    out.close();
  }
}