// stateful 방식의 이점 활용 - 계산기 클라이언트 만들기
// 네이버하고 다음 웹의 서비스 업체들이 우리 클라이언트를 구분하는 방법 
// 웹 브라우저와 웹 서버 사이에 http프로토콜로 통신하는데 stateless방식 사용 
package com.eomcs.net.ex04.stateful2;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    Socket socket = new Socket("localhost", 8888);
    Scanner in = new Scanner(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    while (true) {
      System.out.print("연산자? ");
      out.writeUTF(keyScan.nextLine());

      System.out.print("값? ");
      out.writeInt(Integer.parseInt(keyScan.nextLine())); //입력을 해야 담는다. integer.parseInt해서 출력
      //출력이 안되면 out.flush() 
      //서버에 붙었을 때 보내진거 메모리 안에 들어있다. 상대방쪽에서 읽어야 보낸다. 
      //랜카드를 제어하는 소프트웨어가 TCP/IP 여러개 쌓여야 버퍼에 쌓이는거고 

      String str = in.nextLine();
      System.out.println(str);

      if (str.equals("Goodbye!"))
        break;
    }

    in.close();
    out.close();
    socket.close();
    keyScan.close();
  }
}


