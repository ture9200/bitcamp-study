package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[계산기 클라이언트]");

    Scanner keyScan= new Scanner( System.in);

    while (true) { // 무한루프 사용자로부터 입력받아서 서버에 전달할 때까지. 
      System.out.println("요청(예: 서버주소/연산자/값1/값2)?"); // 서버주소, 계산식을 합침
      System.out.print("=> ");
      String input = keyScan.nextLine(); // 사용자가 입력한걸 읽는다. 

      //문자열이 EXIT이거나 입력받은 문자열이 QUIT일 경로는 종료 
      if(input.equals("exit") || input.equals("quit")) { 
        System.out.println("종료!");
        break; //반복문을 즉시 멈춘다. 
      }
      // 예) input= '192.168.0.204/+/100/200" 
      int slashPos = input.indexOf("/"); // /를 찾아서 리턴
      //예) +/100/200, */3/7 , -/100/73, //12/3 => 첫문자가 /일경우 %2F로 교체
      String serverAddress = input.substring(0, slashPos); // /기준으로 앞부분을 리턴, 즉 192.168.0.204를 리턴
      String queryString = input.substring(slashPos+1); // /를 기준으로 뒷부분을 리턴,  연산자/값1/값2 만 서버에 보낸다. 

      //1) 서버 어플리케이션과 네트워크 연결을 수행한다. 
      // 연결한다는 의미에서 도구 이름이 소켓이다. 
      // ip주소와 포트번호를 넣는다.
      // Socket socket = new Socket("127.0.0.1", 8888); // 서버와 연결될 대까지 객체를 생성하지 않는다.  
      // Socket socket = new Socket("192.168.0.4", 8888); //ip주소를 소켓번호 대신 쓰면 남한테 연결 
      // 내 IP ADDRESS: 192.168.0.204 
      Socket socket = new Socket(serverAddress, 8888); //소켓 열기 소켓객체가 생성되어서 리턴되면 연결된것이다. 
      System.out.println("서버와 연결되었음!");

      // 데이터를 주고 받기 위한 입출력 스트림을 준비한다. 
      PrintStream out = new PrintStream(socket.getOutputStream()); // 쓰기 , PrintStream 데코레이터 
      Scanner in = new Scanner(socket.getInputStream()); 
      // 읽기, 소켓에 대해서 데이터를 읽을때 사용하는 도구를 줘라 ,Scanner 데코레이터역할 
      //BufferedReader 한줄씩 읽기 

      //만약 연산자가 / 일 경우 %2f 문자로 교체한다. 
      if(queryString.startsWith("/")) {
        queryString = queryString.replaceFirst("/", "%2f"); // 서버에 보내는 데이터 형식에 어긋나지 않도록 인코딩 한다. 
        // string은 immutable , 즉 변경할 수 없는 객체 한번 결정되면 바뀌지 않는다. 값이 설정되면 바뀌지 않는다. 
        //그래서 queryString에 담는다. 원래값에서 바꾼것을 바꿔서 새로 string만들어서 리턴 
      }

      //서버에 데이터를 보낸다. 
      out.println(queryString);

      //서버가 응답한 데이터를 읽는다. 
      String response = in.nextLine(); //서버가 한 줄의 문자열을 보낼 때까지 리턴하지 않는다.  in.nextLine() =>한줄을 리턴 
      //한줄의 문자열을 보내면 response로 받는다. 
      System.out.println("===>"+ response); // 서버가 뭐라고 응답했는지 콘솔창에 출력한다. 

      //입출력 도구를 다 사용했으면 자원을 해제한다. 
      out.close();
      in.close();

      //서버 에플리케이션과 연결된 것을 끊는다. 
      socket.close(); //닫기 
      System.out.println("서버 연결 종료!");
    }
    keyScan.close();
  }

}
