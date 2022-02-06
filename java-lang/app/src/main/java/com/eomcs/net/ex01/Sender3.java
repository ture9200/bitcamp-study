// 클라이언트 + 키보드 입력 + 무한 반복
package com.eomcs.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender3 {

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 실행!");

    Scanner keyScan = new Scanner(System.in);

    Socket socket = new Socket("localhost", 8888); // 서버와 연결되면 

    // 입출력 스트림 준비 
    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    // 입출력을 무한 루프 
    while (true) {
      // 키보드 입력을 받아서 서버에게 전송한다.
      System.out.print("입력> ");
      String input = keyScan.nextLine();
      out.println(input);

      // 서버가 보낸 데이터를 수신한다.
      String str = in.nextLine(); // 서버가 보낸 한 줄 읽어서 
      System.out.println(str); // 화면에 출력 

      if (input.equals("quit")) // 사용자가 보낸게 quit이면 
        break; // 반복을 나간다. 
    }

    in.close();
    out.close();
    socket.close();
    keyScan.close();
  }

}


