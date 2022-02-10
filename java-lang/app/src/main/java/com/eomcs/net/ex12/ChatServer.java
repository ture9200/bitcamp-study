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

  public ChatServer(int port) {
    this.port = port;
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        new RequestHandler(serverSocket.accept()).start(); //서버에 연결될 때마다 
      }

    } catch (Exception e) {
      System.out.println("서버 실행 오류 - " + e.getMessage());
    }
  }

  public void sendMessage(String message) { // 메세지를 주면 
    ArrayList deleteStreams = new ArrayList();
    
    for (int i = 0; i < clientOutputStreams.size(); i++) { // 사이즈만큼 반복한다.
      DataOutputStream out = (DataOutputStream) clientOutputStreams.get(i); // clientOutputStreams에서 i번째 꺼낸게 DataOutputStream 객체다. 
      try { // 출력하다 예외가 발생하면 
        out.writeUTF(message); //출력하는데 
        } catch (Exception e) {
        System.out.println("전송 오류:" + message); // 전송오류와 메세지를 화면에 뿌린다. 
        //clientOutputStreams.remove(i);
        deleteStreams.add(out); //무효한 출력 스트림은 삭제 명단에 등록한다. 
      }
    }
    for(Object deleteStream: deleteStreams) { // 삭제 명단에 등록된 출력 스트림을 클라이언트 목록에서 제거한다. 
      clientOutputStreams.remove(deleteStream);
    }
  }

  class RequestHandler extends Thread {
    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
      try (Socket socket2 = socket;
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())) {

        clientOutputStreams.add(out); // 환영합니다 보내기전에 서버에 보내겠다. 

        String nickname = in.readUTF(); 

        out.writeUTF(nickname + " 님 환영합니다!");
        out.flush();

        while (true) {
          String message = in.readUTF(); //클라이언트로부터 메세지 받았는데
          if (message.equals("\\quit")) {
            out.writeUTF("<![QUIT[]>"); //연결을 끊겠다는 특별한 메시지를 클라이언트에게 보낸다. 
            out.flush();
            clientOutputStreams.remove(out); // 메시지 출력 목록에서 연결이 종료된 클라이언트를 제거한다. 
            break;
          }
          sendMessage(String.format("[%s] %s", nickname, message)); // sendMessage쪽으로 닉네임과 메시지를 보내겠다. 
        }
      } catch (Exception e) {
        System.out.println("클라이언트와의 통신 오류! - " + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }
}