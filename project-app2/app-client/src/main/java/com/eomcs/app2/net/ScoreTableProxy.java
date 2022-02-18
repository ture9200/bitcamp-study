package com.eomcs.app2.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.app2.vo.Score;

public class ScoreTableProxy {
  Socket socket; // 인스턴스 변수 선언 
  ObjectOutputStream out;
  ObjectInputStream in;
  
 public ScoreTableProxy(String host, int port) throws Exception {
   socket = new Socket(host, port);// 서버와 소켓 연결 
   
   
   // 입출력 스트림 생성 
    out = new ObjectOutputStream(socket.getOutputStream());
       in = new ObjectInputStream(socket.getInputStream());
 }
       
 public void close() {
   try {
     out.writeUTF("quit"); // quit이라고 화면에 출력 
     out.flush();
   }catch(Exception e) {
     // 종료할 떄 예외는 무시한다. 
   } finally { 
     // 무조건 실행 
     
   try {out.close();} catch (Exception e) {} // 소켓닫기전에 입출력 스트림을 닫는다. 
   try {in.close();} catch (Exception e) {}
   try {socket.close();} catch (Exception e) {}
   }
 }
 
  public int insert(Score score)  {
   try { out.writeUTF("insert"); // insert라고 화면에 출력이 뜨면  
    out.writeObject(score); // 점수를 입력 
    out.flush();// 반드시 flush 써줘야함 
    
  String status = in.readUTF(); // utf 로 읽은걸 status로 받는다. 
  if (status.equals("success")) { // 현재 상황이 success이면 
   return in.readInt(); // 숫자 정수값을 읽고 
    } else { // 그게 아니면 
      throw new RuntimeException(in.readUTF()); //runTime Exception 오류 발생 
  }
} catch(Exception e) { // 읽은 부분에 대해서 예외처리가 발생하면 
  throw new ScoreTableException(e); // scoreTableException 처리 
}
  }

  public  Score[] selectList() { // selectList 하라고 하면 
    try {
      out.writeUTF("selectList"); // selectList 화면에 출력하면 
      out.flush(); // 
      
      String status = in.readUTF(); // utf 로 읽는 걸 status 로 받는다. 
      if (status.equals("success")) { // 문자가 success 이면 
       return  (Score[]) in.readObject(); // 객체를 읽어서 score 배열로 형변환 
      } else { // 그게 아니면 
        throw new RuntimeException(in.readUTF());  // RunTimeException 을 던진다. 
      }
    } catch (Exception e) { // 예외가 발생하면 
      throw new ScoreTableException();   //ScoreTableException 처리를 던진다.      
        }
      } 
  
  public Score selectOne(int no) { //번호 파라미터를 받는 selectone 메서드를 호출하면 
    try {
      out.writeUTF("selectOne"); // selectone 문자가 화면에 출력 
      out.writeInt(no); // 번호 출력 
      out.flush(); // 
      
      String status = in.readUTF(); // 문자를 읽어서 
      if (status.equals("success")) { // success이면 
      return (Score) in.readObject(); // 한번 더 읽었다. score로 형변환  
      } else {                        // 그게 아니면 
        throw new RuntimeException(in.readUTF()); // RunTimeException 예외처리 던짐 
      }
    }catch(Exception e) { // 예외 발생하면 
      throw new ScoreTableException(e);  // ScoreTableException 예외 던진다. 
    }
    }

  public int update(int no, Score score) { // update 하면 
    try { // 예외던지기 
      out.writeUTF("update"); // update 가 화면에 출력 
      out.writeInt(no); // 번호 입력 
      out.writeObject(score); // 점수 입력 
      out.flush(); // 남은 찌끄러기 까지 나옴 
 
  String status = in.readUTF(); // 
  if (status.equals("success")) { // 상황이 success 라고 하면  
    return in.readInt(); // 숫자를 읽어서 리턴? 
    } else { // 그게 아니라면 
      throw new RuntimeException(in.readUTF()); // RunTimeException 예외 던짐 
  }
} catch(Exception e) { // 예외 발생이 그럼에도 생긴다면 
  throw new ScoreTableException(e); // ScoreTableException 을 던진다. 
}
  }

  public  int delete(int no) {
    try { 
      out.writeUTF("delete");
      out.writeInt(no);
      out.flush();
      
      String status = in.readUTF(); // 문자열로 읽어서 
      if (status.equals("success")) { //
       return in.readInt(); // 
      } else { // 그게 아니라면 
        throw new RuntimeException(in.readUTF()); //
      }
    } catch(Exception e) { // 
      throw new ScoreTableException(e);
    }
      }
  }