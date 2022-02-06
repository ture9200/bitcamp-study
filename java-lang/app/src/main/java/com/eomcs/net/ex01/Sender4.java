// 파일 보내기
package com.eomcs.net.ex01;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender4 {

  public static void main(String[] args) throws Exception {
    //File file = new File("temp/jsl11.pdf");
    File file = new File("temp/윈터3 .jpg");

    FileInputStream fileIn = new FileInputStream(file); // 파일에서 데이터를 읽을 때 사용하는 입력 스트림 

    System.out.println("서버에 연결 중...");
    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버에 연결 완료!");

    DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
    //DataOutputStream 데코레이터를 붙임, long 값을 출력하는 메서드 , 문자열을 출력하는 메서드 , 바이트 배열을 출력하는 메서드포함 
    Scanner in = new Scanner(socket.getInputStream());

    System.out.println("서버에 데이터 송신 중...");

    long startTime = System.currentTimeMillis(); // 보내기전 시작 시간 측정 

    // 1) 파일 크기 보내기
    out.writeLong(file.length()); // 길이를 long값으로 리턴 

    // 2) 파일 이름 보내기
    out.writeUTF(file.getName()); // 이름은 문자열로 리턴 

    // 3) 파일 데이터 서버에 보내기
    int b; 
    while ((b = fileIn.read()) != -1) {
      out.write(b);
    }

    long endTime = System.currentTimeMillis(); // 보낸 후 시간 측정 

    System.out.printf("서버에 데이터 송신 완료!(%d밀리초)\n", endTime - startTime); // 서버에 데이터를 보내는데 걸린 시간을 출력 

    // 4) 서버의 응답받기
    String response = in.nextLine(); // ok로 응답받으면 
    System.out.println(response); // ok를 클라이언트에 출력 

    in.close();
    out.close();
    socket.close();
    fileIn.close();
  }

}


