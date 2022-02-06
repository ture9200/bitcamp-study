// 클라이언트 + 키보드 입력
package com.eomcs.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender2 {

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 실행!");

    Scanner keyScan = new Scanner(System.in); // 키보드 준비 

    Socket socket = new Socket("localhost", 8888); // 로컬호스트 서버에 접속 

    // 입출력 스트림 준비 
    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    // 키보드 입력을 받아서 한 줄의 문자열을 서버에게 전송한다.
    System.out.print("입력> ");
    String input = keyScan.nextLine();
    out.println(input);

    // 서버가 보낸 데이터를 수신한다.
    String str = in.nextLine();
    System.out.println(str);

    in.close();
    out.close();
    socket.close();
    keyScan.close();
  }

}


