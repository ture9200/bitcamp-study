// 클라이언트와 입출력 테스트 - byte stream
package com.eomcs.net.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0110 {
  public static void main(String[] args) {
    Scanner keyboard = null;
    ServerSocket serverSocket = null; //  finally에 닫아야하니까 바깥에 선언

    try {
      keyboard = new Scanner(System.in); //키보드 객체 생성 
      serverSocket = new ServerSocket(8888); 
      //서버소켓 객체를 담는다. 생성하는 순간 대기열 최대 50개까지 기다릴 수 있다. 
      System.out.println("클라이언트의 연결을 기다리고 있음.");

      Socket socket = null;
      OutputStream out = null;
      InputStream in = null;
      // finally에서 입출력 스트림 객체와 소켓 객체를 알아야하기 때문에 바깥에 선언 
      // try문 안에두면 finally문이 접근못한다. 

      try {
        // accept()
        // - 대기열에서 클라이언트 정보를 한 개 꺼내 소켓을 만들어 클라이언트와 연결한다.
        // - 만약 대기열에 클라이언트 정보가 없다면 클라이언트가 접속할 때까지 기다린다.
        socket = serverSocket.accept();
        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음.");

        // 클라이언트와 데이터를 주고 받을 입출력 스트림 객체를 준비한다.
        // => 출력 스트림 객체를 준비하기
        out = socket.getOutputStream();

        // => 입력 스트림 객체를 준비하기
        in = socket.getInputStream();
        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");

        // Client와 Server의 통신 규칙에 따라 순서대로 입출력 해야 한다.
        // 왜? 
        // 입출력은 blocking 모드로 작동하기 때문이다.
        // 즉 read()라는 메서드는 클라이언트가 보낸 데이터를 읽기 전까지 리턴하지 않는다.
        //
        // 클라이언트와 서버 간의 데이터를 주고 받는 통신 규칙을 "프로토콜(protocol)"이라 한다.
        // 클라이언트에서 한 줄의 문자열을 보내면
        // 서버는 한 줄의 문자열을 읽은 후에 응답해야 한다.

        System.out.print("데이터를 읽기 전에 잠깐!");
        keyboard.nextLine(); //키보드에서 한 줄 읽어온다. 한 단계 실행을 제어하려고 준것, 특별히 의미없음 

        System.out.println("클라이언트가 보낸 1바이트를 기다리고 있음!");
        // => 클라이언트가 1바이트를 보낼 때까지 리턴하지 않는다.
        int request = in.read(); // blocking 모드로 작동한다.

        System.out.println(request); //데이터를 보내면 출력 

        // 서버가 데이터를 보내지 않으면 클라이언트의 read()는 리턴하지 않는다.
        // 이를 확인하기 위해 잠시 실행을 멈춘다.
        System.out.print("데이터를 보내기 전에 잠깐!");
        keyboard.nextLine(); // 한단계 실행을 제어한다. 

        // => 클라이언트에게 받은 문자열을 그대로 보낸다.
        // 물론 클라이언트가 보낸 데이터를 다 읽을 때까지 리턴하지 않는다.
        out.write(request);
        // out.flush(); //찌끄러기 데이터 출력 
        // byte stream 을 사용할 때는 바로 출력한다.
        // 따라서 flush()를 호출하지 않아도 된다.
        System.out.println("클라인트에게 데이터를 보냈음.");

      } catch (Exception e) {
        e.printStackTrace(); // 표준출력장치로 에러정보를 출력하는데 STACK을 추적

      } finally { //출력부터 닫는다. 
        try {out.close();} catch (Exception e) {} //출력 스트림 닫는다. 
        try {in.close();} catch (Exception e) {} // 입력 스트림 닫는다.
        // 두개를 하나로 묶으면 안된다. 입출력 따로 닫아야한다. 
        // 이유: 출력을 닫다가 오류가 발생하면 입력은 닫지도 못하고 건너버린다. 

        try {socket.close();} catch (Exception e) {} // 소켓을 닫는다. 
        System.out.println("클라이언트와의 연결을 끊었음.");
      }


    } catch (Exception e) {
      System.out.println("상세 예외 정보:");
      e.printStackTrace(); //표준 출력장치, 에러정보를 쭉 따라올라가면서 출력 
      // 어느부분에서 예외가 발생되었는지 추적 

    } finally {
      // 개발자가 직접 finally구문을 작성해야한다. 
      System.out.println("키보드 자원 해제 및 서버 소켓 자원 해제!");
      keyboard.close();
      //try { keyboard.close(); } catch (Exception e) {}
      try { serverSocket.close();} catch (IOException e) {}
      // 소켓을 만드는데 하필이면 그 포트번호를 쓸 때 발생
    }
    System.out.println("서버 종료!");
  }

}

