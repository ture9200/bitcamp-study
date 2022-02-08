// 클라이언트와 입출력 테스트 - byte stream + buffer
package com.eomcs.net.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0160 {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try (Socket socket = serverSocket.accept();
          Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));
          PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()))) {

        System.out.println("클라이언트가 보낸 한 줄의 문자열을 기다리고 있음!");

        //클라이언트가 보낼 한 줄을 기다리고 있다. 
        String str = in.nextLine();
        System.out.println(str);// 화면에 뿌림 

        // 서버가 데이터를 보내지 않으면 클라이언트의 read()는 리턴하지 않는다.
        // 이를 확인하기 위해 잠시 실행을 멈춘다.
        System.out.print(">");
        keyboard.nextLine();

        // 다시 한줄을 보낸다. 
        out.println(str);
        //        out.flush();
        // 버퍼를 사용할 때는
        // 데이터를 보내기 위해 반드시 flush()를 호출해야 한다.
        // => 버퍼에 남아 있는 데이터를 연결된 출력 스트림을 이용하여 내보낸다.
        System.out.println("클라인트에게 데이터를 보냈음.");

      }
      System.out.println("클라이언트와의 연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }

}
//  바이트 스트림이라 할지라도 버퍼는 조심해야 됨
// 버퍼 바이트 배열에 보관된 상태이고 아직 랜카드 메모리에 안 들어간 상태다.
// 버퍼를 사용할 때는 데이터를 보내기 위해 반드시 flush()를 호출해야 한다.

//client는 out.flush 호출했고 서버는 호출하지않았는데 보내지는 이유?
//서버는클라이언트에게 데이터를 보냈음 하고 
//try블럭을 나가면서 close하게되는데 그럼 flush를 하게 된다. => 자동으로 방출  
//그래도 그냥 서버쪽에서 반드시 flush()를 명시해줘라 => 버퍼 때문에 