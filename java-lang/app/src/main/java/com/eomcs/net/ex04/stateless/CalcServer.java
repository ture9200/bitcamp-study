// stateless 방식 - 계산기 서버 만들기
// 요청할때마다 연결하고 응답받으면 연결을 끊는다. 
package com.eomcs.net.ex04.stateless;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      Socket socket = ss.accept(); // 클라이언트와 연결되는 순간 
      System.out.println("클라이언트 요청 처리!");
      try {
        processRequest(socket); //processRequest호출해서 
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
        System.out.println("다음 클라이언트의 요청을 처리합니다.");
      }
    }
    // ss.close();
  }

  static void processRequest(Socket socket) throws Exception {
    try (Socket socket2 = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());) {

      // 클라이언트가 보낸 Int, UTF 값을 읽는다. 
      int a = in.readInt();
      String op = in.readUTF();
      int b = in.readInt();
      int result = 0; // 서버에서 결과를 갖고 있어봐야 소용없다. 
      // 클라이언트에 응답하는 순간 소켓을 close하기때문에 메서드 호출이 끝나서 나간다. 

      //연산자에 따라 작업을 수행한다. 
      switch (op) {
        case "+":
          result = a + b;
          break;
        case "-":
          result = a - b;
          break;
        case "*":
          result = a * b;
          break;
        case "/":
          result = a / b;
          break;
        default: //연산자가 없으면 해당 연산을 지원하지 않습니다라고 클라이언트에게 보낸다. 
          out.println("해당 연산을 지원하지 않습니다.");
          return;
      }
      //클라이언트에게 계산한 줄을 보낸다. 
      out.printf("%d %s %d = %d\n", a, op, b, result);
    }
  }
}

// try 블럭을 끝내는 순간 알아서 close한다. 
// 클라이언트에 응답하는 순간 바로 끊기 때문에 오랫동안 기다리지 않고 바로 다음으로 간다. 

