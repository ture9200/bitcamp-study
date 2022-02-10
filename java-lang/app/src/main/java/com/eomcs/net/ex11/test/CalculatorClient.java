package com.eomcs.net.ex11.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class CalculatorClient {
  public static void main(String[] args) {

    try ( 
        // close() 자동 호출하기 위해  입출력스트림을 괄호안에 집어넣는다.  
        Scanner keyScan = new Scanner(System.in);
        // 혹시나 서버와 연결이 끊어지면 키보드 닫아버린다. 
        Socket socket = new Socket("localhost", 8888); // 클라이언트와 연결을 기다린다. 
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        ) {

      while (true) {
        String str = in.nextLine(); // 서버가 보낸걸 받는다. 
        if (str.length() == 0) { // 빈 문자열이 오면 
          break; // 나가고 
        }
        System.out.println(str); // 화면 뿌린다. 
      }

      while(true) { // quit입력하기전까지 반복 
        System.out.print("계산식> ");
        String input = keyScan.nextLine(); // 사용자가 입력한걸 서버에 보냄 

        //stateful방식 
        // 계산식에 문자열을 입력하면 서버 연결 오류 발생이 뜬다. 
        // 정수로 바꾸려고 할 때 오류 발생
        // quit이 아니고 공백으로 짤랐는데 3이아니면 입력 형식이 올바르지 않는다고 나옴
        // 나가지 않아야하니까 continue 
        if(input.equals("quit") && input.split("").length != 3) {
          System.out.println("입력 형식이 올바르지 않습니다. 예) 23 + 5");
          continue;
        }

        out.println(input); 
        // 서버는 사용자가 입력한 걸 받아서 사용자에게 응답 
        //stateless 방식 사용 
        
        out.flush();

        String str = in.nextLine(); // 서버에 응답받아서 
        System.out.println(str); //화면에 출력 

        if (input.equals("quit")) {
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("서버 연결 오류!");
    }
  }
}

