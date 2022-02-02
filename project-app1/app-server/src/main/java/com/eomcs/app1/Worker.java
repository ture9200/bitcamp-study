package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Scanner;

public class Worker extends Thread {

  Socket socket;

  public Worker(Socket socket) { //클라이언트와 연결될 소켓을 받는다. 
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      //클라이언트와 데이터를 주고받을 입출력 도구를 준비한다. 
      Scanner in = new Scanner(socket.getInputStream()); //읽기 
      PrintStream out = new PrintStream(socket.getOutputStream()); // 쓰기 

      // HTTP 요청 데이터 읽기 
      String requestLine = in.nextLine();// 웹브라우저에서 보낸 첫줄은 무조건 requestLine
      System.out.println(requestLine); // 웹브라우저가 보낸 내용 출력 

      // 나머지 데이터는 버린다. 
      while(true) {
        String str = in.nextLine();
        if(str.length()==0) { // 빈줄이면 나간다. 더이상 읽을 필요가 없다. 
          break;
        }
      }

      // 예) requestLine =  "GET /+/100/200 HTTP/1.1"
      String requestUri= requestLine.split(" ")[1];  // 예) "/+/100/200" 공백으로 자름
      String[] values = requestUri.split("/"); // 예) {"", "plus", "100", "200"} /로 자름 

      if(values.length ==4) { //만약에 values.length 가 4가 아니라면 
        String op = URLDecoder.decode (values[1], "UTF-8"); // "%2b" -> "+", "-", "*", "%2f" -> "/"
        //charset을 지정안하면 deprecated 
        int a = Integer.parseInt(values[2]); // "100"
        int b = Integer.parseInt(values[3]); // "200"
        System.out.printf("%s, %d, %d\n", op, a, b);

        String response = null; 

        //        if(values.length !=3) { //계산식이 올바르지 않다면 
        //          out.println ("나: 계산식이 올바르지않습니다.");
        //        } else { //계산식이 올바르다면
        //          String op = values[0]; // "plus", 값을 연산자로써 op에 저장 
        //          int a = Integer.parseInt(values[1]); // int로 바꿔서 a에 저장 
        //          int b = Integer.parseInt(values[2]); //int로 바꿔서 b에 저장 
        //          int result = 0; // result를 저장할 변수를 준비 
        //          if(op.equals("%2f")) {  // 만약에 %2f라면 
        //            op ="/"; // %2f 문자열을 원래의 문자인 /로 디코딩한다. 
        //          }


        switch (op) { //계산식이 정상적이라면 
          case "+": 
            response = String.format("나: %d + %d = %d", a, b, (a + b));
            break;
          case "-": 
            response= String.format("나: %d - %d= %d", a,  b, (a-b)); //결과 리턴, 나가 보냈음 
            break;
          case "*": 
            response= String.format("나: %d * %d= %d", a,  b, (a*b));
            break;
          case "/": 
            response = String.format("나: %d / %d= %d", a,  b, (a/b));
            break;
          default: // 더하기 빼기가 아니라면 
            response = "나: 지원하지 않는 연산자입니다.";
        } 
        writeResponse(out,response);

      }else {
        writeResponse(out, "요청형식이 올바르지 않습니다");
      }

      // 클라이언트와의 연결을 끊음 
      socket.close();  //접속 종료! 
      System.out.println("클라이언트 연결 종료!");

    } catch (Exception e) { 
      e.printStackTrace(); // 어떤 메서드 호출하다가 예외가 떴는지 풀어서 출력 
    }
  }

  // HTTP 응답 데이터 보내기
  private void writeResponse(PrintStream out, String messagebody) throws Exception { // 내부적으로 쓸거니까 private으로 
    // 보낼 데이터를 URL 인코딩한다. 단 문자는 UTF-8 규칙(character set)에 따라 변환한다. 
    //출력 스트림을 파라미터로 받고 응답할 메세지를 파라미터로 받는다. 
    // http protocol보면 응답한 데이터를 message body 라고 한다. 
    //String encodedStr = URLEncoder.encode(messagebody, "UTF-8");

    out.println("HTTP/1.1 200 OK"); 
    out.println("Content-Type: text/plain; charset=UTF-8"); // text/plain: 순수텍스트 
    //out.printf("Content-Length: %d\n", messagebody.length()); // 길이출력 
    out.println();
    out.print(messagebody); //인코딩한걸 웹브라우저에게 보낸다. 
    out.flush();

    //ctrl+space 보조창 (assistant view)
  }
}
