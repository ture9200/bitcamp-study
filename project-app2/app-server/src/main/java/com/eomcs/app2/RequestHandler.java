package com.eomcs.app2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.app2.table.ScoreTable;
import com.eomcs.app2.vo.Score;

public class RequestHandler extends Thread { // Threads를 상속받는다. 
  Socket socket; // run이라는 메서드에서 사용할 수 있도록 인스턴스 필드에 보관 

  public RequestHandler(Socket socket) { // 클라이언트와 연결할 소켓을 받는다. 
    this.socket = socket;
  }

  @Override
  public void run() { // 독립적으로 수행할 작업을 run이라는 메서드 안에 넣는다 
    try (Socket socket2 = socket; // 소켓 생성 , try 블럭을 나가기전 자동으로 close 호출하기 위해서 
        // socket객체주소를 socket2에 저장했기 때문에 socket이나 socket2나 같은 객체 
        // socket2를 클로즈하는것과 소켓을 클로즈하는게 마찬가지다. 
        // 선언안되면 자동 close 안된다. 
        
        //입출력스트림 준비 
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {

     //클라이언트 요청이 들어올때마다 요청을 처리 
      System.out.println("클라이언트가 접속했습니다.");

      while (true) {
        String command = in.readUTF();
        if (command.equals("quit")) {
          break;
        }
        try {
          switch (command) {
            case "insert":
              Score score = (Score) in.readObject();
              int count = ScoreTable.insert(score);
              out.writeUTF("success");
              out.writeInt(count);
              break;
            case "selectList":
              Score[] scores = ScoreTable.selectList();
              out.writeUTF("success");
              out.writeObject(scores);
              break;
            case "selectOne":
              int no = in.readInt();
              score = ScoreTable.selectOne(no);
              out.writeUTF("success");
              out.writeObject(score);
              break;
            case "update":
              no = in.readInt();
              score = (Score) in.readObject();
              count = ScoreTable.update(no, score);
              out.writeUTF("success");
              out.writeInt(count);
              break;
            case "delete":
              no = in.readInt();
              count = ScoreTable.delete(no);
              out.writeUTF("success");
              out.writeInt(count);
              break;
            default:
              out.writeUTF("fail");
              out.writeUTF("해당 명령을 지원하지 않습니다.");
          }
          out.flush();
        } catch (Exception e) {
          out.writeUTF("fail");
          out.writeUTF("실행 오류: " + e.getMessage());
          out.flush();
        }
      } // while (true)
      System.out.println("클라이언트와의 연결을 끊었습니다.");

    } catch (Exception e) {
      System.out.println("클라이언트와 통신 중 오류 발생!");
    }
  }
}

