package com.eomcs.app1;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 서버]");

    //클라이언트 App의 연결을 준비한다. 
    ServerSocket serverSocket = new ServerSocket(8888); // 연결을 기다리기때문에 IP주소를 적을 필요없고 대신 포트번호를 추가 

    while (true) { 
      //무한루프로 설정:  한번만 대화나누고 종료하고 싶지 않아서다. 
      //클라이언트의 연결 요청을 승인한다. 
      //   - 리턴 값은 클라이언트와 연결된 정보 
      System.out.println("클라이언트의 연결을 기다림!");
      Socket socket = serverSocket.accept(); // 클라이언트와 연결될 때까지 리턴하지 않는다. 클라이언트 연결요청이 오면 승인 
      System.out.println("클라이언트와 연결됨!"); //접속한 순간 리턴, 리턴 = 연결됨 

      //클라이언트의 요청을 처리할 작업자를 만든다. 
      Worker worker = new Worker(socket); // 서버에 연결하는 순간 작업자를 만들고 작업자에게 소켓을 넘긴다. 
      worker.start(); // 작업자에게 일을 하라고 시킨다. 
      System.out.println("작업자에게 클라이언트 요청을 맡겼음!");// 작업자에게 일을 시킨 후 즉시 리턴한다. 

      //클라이언트와 데이터를 주고받을 입출력 도구를 준비한다. 
      //도구를 준비할 때 먼저 읽는다고 하면 읽는거, 출력한다고 하면 출력도구를 먼저 준비한다. 
      //Scanner in = new Scanner(socket.getInputStream());
      //PrintStream out = new PrintStream(socket.getOutputStream()); 

      // 클라이언트와 주고 받는 순서가 맞아야 한다. 
      // String request = in.nextLine(); // 한줄을 보내니까 한줄을 읽어야한다. 
      // System.out.println("요청 계산식:" + request); // 요청을 했으니 서버 콘솔창에 출력 System.out 
      //out.println (request + "님 반갑습니다.");  말을 클라이언트한테 보낸다. out 

      //클라이언트와 연결을 끊음 
      //socket.close(); 
      //System.out.println("클라이언트 연결 종료!");

      //서버쪽 연결 도구 종료! => 무한루프라서 Unreachable code 에러가 뜬다. 
      //serverSocket.close();
      //System.out.println("서버 종료!");

      //방화벽차단 => 방화벽 상태 확인 => WindowsDefender 방화벽 설정 또는 해제 => 둘다 사용안함 클릭 
      //무한 루프 서버를 종료할 방법은 ctrl+c 
    }
  }
}
