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
      // 파일읽을때는 FileReader, 좀더 빠르게 읽기위해서 BufferedReader 


      String csvStr; 
      while ((csvStr = in.readLine()) != null ) { // 한줄을 읽었는데 null이 아니라면 
        boardList.add(Board.valueOf(csvStr)); 
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
    //bufferedWriter = 출력하면 버퍼에 담아놨다가 버퍼에 꽉차면 왕창 파일로 보내기때문에 출력속도가 빠르다. 
    //여기다가 printWriter까지 주면 한 줄의 문자열 출력 가능 


    for (int i = 0; i < boardList.size(); i++) { // 반복문 돌면서 
      Board board = (Board) boardList.get(i); // boardList의 get I번째 객체를 꺼낸다. 
      out.println(board.toCsvString()); //csv문자열 꺼내서 출력 
    }
    out.flush(); // 마지막 찌끄래기를 수동으로 출력, 버퍼가 꽉안차면 출력안함, 
    // 명시적으로 호출해서 버퍼에 쌓인거를 출력하라고 해라 

    out.close();
  }
}