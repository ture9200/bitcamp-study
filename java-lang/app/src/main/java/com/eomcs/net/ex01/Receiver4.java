// 파일 받기
package com.eomcs.net.ex01;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver4 {

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = serverSocket.accept();
    System.out.println("클라이언트가 연결됨.");

    PrintStream out = new PrintStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream()); // InputStream에다가 DataInputStream이라는 데코레이터를 사용 
    // 서버에서 DataOutputStream으로 보냈으니까 읽을때 DataInputStream으로 읽어야함 

    System.out.println("클라이언트로부터 데이터 수신 중...");

    //1) 파일 크기 읽기
    long filesize = in.readLong(); // long값을 읽는다. 

    //2) 파일 이름 읽기
    String filename = in.readUTF(); // 문자열을 읽는다. 

    //3) 파일 데이터 읽기
    File file = new File("temp/ok_" + filename); // temp 밑에 ok_ + 클라이언트에서 보낸 파일이름으로 출력 
    FileOutputStream fileOut = new FileOutputStream(file);

    for (long i = 0; i < filesize; i++) { // 파일 사이즈만큼 반복문을 돌려서 
      fileOut.write(in.read());
    }
    System.out.println("클라이언트로부터 데이터 수신 완료!");

    //4) 클라이언트에게 응답하기
    out.println("OK!"); // 반복문을 다 돌았으면 클라이언트에게 ok로 전송 

    in.close();
    out.close();
    socket.close();
    serverSocket.close();
    fileOut.close();
  }

}





