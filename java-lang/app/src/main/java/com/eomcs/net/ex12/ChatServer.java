package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@SuppressWarnings("rawtypes") //제네릭 무시 , 경고 표시 
public class ChatServer {
  int port; 
  ArrayList clientOutputStreams = new ArrayList();

  public ChatServer(int port) { // 포트번호받아서 저장 
    this.port = port;
  }

  public void service() { // 서버가 정상적으로 실행한다면 서버 실행 중.. 출력
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) { // 무한루프로 처리 , 서비스가 시작되면
        new RequestHandler(serverSocket.accept()).start(); 
        //serverSocket.accept()가 먼저고 그다음 requestHandler. start 처리 
      }

    } catch (Exception e) { // 실행하다 오류뜨면 이렇게 받는거 서버실행오류와 메시지 
      System.out.println("서버 실행 오류 - " + e.getMessage());
    }
  }

  public void sendMessage(String message) { // 메세지를 주면 
    ArrayList deleteStreams = new ArrayList(); // 예외발생한 삭제대상 클라이언트 목록 따로 관리 
    
    for (int i = 0; i < clientOutputStreams.size(); i++) { // 서버에 접속한 모든 클라이언트 목록 사이즈만큼 반복한다.
      DataOutputStream out = (DataOutputStream) clientOutputStreams.get(i); // clientOutputStreams에서 i번째 꺼낸게 DataOutputStream 객체다. 
      try { // 출력하다 예외가 발생하면 
        out.writeUTF(message); //하나의 클라이언트가 보낸 메세지를 다른 클라이언트들에게 출력하는데 
        } catch (Exception e) { // 메세지 보내려다가 못보내면 또는 예기치 않은 강제종료된 상태로서 무효한 출력스트림이 있을듯.
        System.out.println("전송 오류:" + message); // 전송오류와 메세지를 화면에 뿌린다. 
        //clientOutputStreams.remove(i); // 유효하지 않은 클라이언트 제거한다. 
        deleteStreams.add(out); //무효한 출력 스트림은 삭제 명단에 등록한다. 
        // 삭제 명단에 등록해놨다가 나중에 삭제려나보다해서 다음 행위가 떠오른..
      }
    }
    for(Object deleteStream: deleteStreams) { // 삭제 명단에 등록된 출력 스트림을 클라이언트 목록에서 제거한다. 
      clientOutputStreams.remove(deleteStream); // 삭제 대상을 꺼냈다. 
    }
  }

  class RequestHandler extends Thread {
    Socket socket; // 인스턴스 필드 생성 

    public RequestHandler(Socket socket) { // 생성자가 호출되었을 때 socket으로 받고 
      this.socket = socket;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() { //클라이언트 요청을 처리하는 메서드 
      try (Socket socket2 = socket;
          
          // 자동으로 close() 호출 , 서버 연결
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) {

        clientOutputStreams.add(out); // 환영합니다 보내기전에 서버에 보내겠다. 

        String nickname = in.readUTF();  // 클라이언트가 보낸 별명을 읽는다. 읽어서 변수에 저장 

        out.writeUTF(nickname + " 님 환영합니다!"); //클라이언트한테 출력 
        out.flush(); // 방출하는거 빠뜨리지 말기! 

        while (true) { // 무한 반복
          String message = in.readUTF(); //클라이언트로부터 메세지 받았는데
          if (message.equals("\\quit")) { // 메세지를 quit이라고 받으면 
            
            //일반적으로 메시지로 입력하지 않을 특별한 코드 추가
            out.writeUTF("<![QUIT[]>"); //연결을 끊겠다는 특별한 메시지를 클라이언트에게 보낸다. 
            out.flush(); // 방출하는거 빠뜨리지 말기 
            clientOutputStreams.remove(out); // 메시지 출력 목록에서 연결이 종료된 클라이언트를 제거한다. 
            break;
          }
          sendMessage(String.format("[%s] %s", nickname, message)); 
          // sendMessage("[" + nickname + "]" + message);  같은 문장 
          // 메세지를 집어넣어서 하나의 문자열을만들어서 리턴하면 리턴한걸 sendmessage 통해서 보낸다. 
          // sendMessage쪽으로 닉네임과 메시지를 보내겠다. 
        }
      } catch (Exception e) { 
        System.out.println("클라이언트와의 통신 오류! - " + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service(); // 포트번호 8888 받아서 chatserver한테 서비스하라 
  }
}

