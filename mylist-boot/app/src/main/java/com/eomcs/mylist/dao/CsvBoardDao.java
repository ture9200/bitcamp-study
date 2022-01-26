package com.eomcs.mylist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Board;

@Repository
public class CsvBoardDao extends AbstractBoardDao{
  //ArrayList boardList = new ArrayList(); // 인스턴스 변수를 만들라는 명령어 
  // 변수 선언 = 변수를 만들라는 명령! 
  // new할때 명령을 준다. 생성자가 호출될 때 생성. 
  //variables initilaizer = 변수선언에 값을 초기화 시키는 문장 

  public CsvBoardDao() { 
    // 컴파일러는 생성자가 없으면 기본생성자를 자동 만들어준다. 
    // super(); => 컴파일러가 수퍼클래스의 기본 생성자를 첫줄로 자동 삽입

    try {
      BufferedReader in = new BufferedReader(new FileReader("boards.csv"));


      String csvStr;
      while ((csvStr = in.readLine()) != null ) {
        boardList.add(Board.valueOf(csvStr)); 
        // this가 가리키는 필드라던가 this라는 값을 넘겨주면서 
        // 인스턴스 호출할 때는 this를 붙이기도 하지만 생략한다. 
        // 없으면 컴파일러가 자동으로 붙인다. 
        // this에 저장된 레퍼런스로 가서 명령어에 따라서 만들었다. 
        // boardlist가 메서드 안에 로컬변수가 아닐때만 컴파일러가 this를 붙인다. 

      }
      in.close();
    } catch(Exception e) {
      System.out.println("게시글 데이토 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception{
    // 명령어 실행하고 save를 요청했을때마다 계속 저장하는거 번거로우니까 이렇게 만들어줌  
    // 예외발생시 던져준다. 
    // 매번 저장하고 파일이 쌓이면 성능이 떨어지지 않냐?
    //  => 성능 신경쓰지 말자 
    PrintWriter out = new PrintWriter( new BufferedWriter(new FileWriter("boards.csv")));

    for (int i = 0; i < boardList.size(); i++) {
      Board board = (Board) boardList.get(i);
      out.println(board.toCsvString());
    }
    out.flush();

    out.close();
  }
}