// stateless 방식 - 계산기 클라이언트 만들기
// 요청할때마다 연결하고 응답받으면 연결을 끊는다. 
package com.eomcs.net.ex04.stateless;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("값1? "); //키보드로부터 값을 받는다. 
      int a = Integer.parseInt(keyScan.nextLine()); 

      System.out.print("연산자? "); // 연산자받고 
      String op = keyScan.nextLine();

      System.out.print("값2? ");// 값2를 받고 
      int b = Integer.parseInt(keyScan.nextLine());

      //서버에 보낼때 서버에 연결해서 
      try (Socket socket = new Socket("localhost", 8888);
          Scanner in = new Scanner(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

        // writeInt, writeUTF 로 보낸다. 
        // 만약 서버에 안보내지면 out.flush()호출 
        out.writeInt(a);
        out.writeUTF(op);
        out.writeInt(b);

        String str = in.nextLine(); // 서버에 응답을 기다린다. 서버에서 응답받고 
        System.out.println(str); // 즉시 연결을 끊는다. 
        // try블럭을 벗어나면 연결을 끊는다. 

      } catch (Exception e) { 
        System.out.println("서버와 통신 중 오류 발생!");
      }

      System.out.print("계속하시겠습니까?(Y/n)"); //Y라고 입력하면 반복문 돈다. 
      if (keyScan.nextLine().equalsIgnoreCase("n")) {
        break;
      }
    }

    keyScan.close();
  }
}


