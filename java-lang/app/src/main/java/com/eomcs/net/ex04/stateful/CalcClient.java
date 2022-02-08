// stateful 방식 - 계산기 클라이언트 만들기
package com.eomcs.net.ex04.stateful;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    Socket socket = new Socket("localhost", 8888);
    // 한번 연결되면 
    Scanner in = new Scanner(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    while (true) { // 값 연산자 값을 받아서 
      System.out.print("값1? ");
      out.writeInt(Integer.parseInt(keyScan.nextLine()));// 첫번쩨 서버에 보내는데 
      // 키보드로부터 입력을 받아서 숫자로 바꾸고 

      System.out.print("연산자? ");
      out.writeUTF(keyScan.nextLine()); // 한 줄을 입력받아서 서버에 보내고 

      System.out.print("값2? ");
      out.writeInt(Integer.parseInt(keyScan.nextLine())); // 문자열로 받아서 int값으로 바꿔서 서버에 보내고  
      out.flush(); // 값이 출력되게 flush 를 한다. 

      String str = in.nextLine();// 서버에서 한 줄 결과를 보내면 
      System.out.println(str); // 출력 

      if (str.equals("Goodbye!")) //서버에서 굿바이를 보냈으면 
        break; // 연결 끊는다. 
    }

    in.close();
    out.close();
    socket.close();
    keyScan.close();
  }
}



