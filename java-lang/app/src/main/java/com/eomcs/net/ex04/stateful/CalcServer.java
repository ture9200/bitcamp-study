// stateful 방식 - 계산기 서버 만들기
package com.eomcs.net.ex04.stateful;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      try (Socket socket = ss.accept()) { // 클라이언트와 연결되는 순간 , 대기열에서 클라이언트 한명을 꺼낸다. 
        processRequest(socket); // 소켓을 넘겨주면서 processRequest가 처리, (대기했다가) 처리하라 
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
        System.out.println("다음 클라이언트의 요청을 처리합니다.");
      }
    }
    // ss.close();
  }

  static void processRequest(Socket socket) throws Exception { // 파라미터로 소켓을 받으면 
    //소켓을 통해서 입출력스트림을 준비한다. 
    try (DataInputStream in = new DataInputStream(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());) {

      loop: while (true) { //무한루프 돌면서 기다린다. 값과 연산자를 받아서 
        int a = in.readInt();
        String op = in.readUTF();
        int b = in.readInt();
        int result = 0;

        switch (op) { //연산자에 맞는 계산을 한 다음에 
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
          case "quit": // quit이면 반복문을 나간다. 
            break loop;
          default: // 위에 해당되는 연산기호가 없으면 
            out.println("해당 연산을 지원하지 않습니다.");
            continue;
        }

        out.printf("%d %s %d = %d\n", a, op, b, result); // 클라이언트에게 응답을 한다. 
        // 값을 계산한 결과를 출력 
      }
      out.println("Goodbye!");
    }
  }
}


