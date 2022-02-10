package com.eomcs.net.ex11.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {

  String logo;
  //내장변수 this 는 innerclass에서 바깥 클래스의 마치 자기 변수인 마냥 생략 가능 

  public CalculatorServer() {
    StringBuilder logoStr= new StringBuilder();  

    // 웰컴 로고 
    // 텍스트형식의 파일을 읽어야하니까 fileReader 사용
    // 자동으로 close 호출 해야하니 try 사용 
    try (BufferedReader welcomeIn = new BufferedReader(new FileReader("welcome.txt"));) {
      while(true) {
        String str= welcomeIn.readLine(); // 읽는다. 
        if(str ==null) { // 만약 문자열이 null이면 
          break; // 반복문을 나간다. 
        }
        logoStr.append(str +"\n"); // 파일에서 읽어온걸 로고STR 에 append 한다. 
      }
    } catch(Exception e) { // 예외가 발생되면 
      // 로고를 읽으려는데 파일이 없으면 환영합니다 출력
      // 바깥에 두면 클라이언트 요청처리중 오류 발생 출력하면서 나가니까 분리해서 작성을 한다. 
      
      if(logoStr.length()>0) { // Length가 0보다 클때는 초기화 
        logoStr.setLength(0);
      //파일읽는데 중간에 오류날 수 있으니까 setLength를 0 으로 초기화 
        // 기존에 logoStr 담겨있는게 있다면 0으로 세팅 
      }
      logoStr.append("환영합니다!\n"); 
    }
    logo = logoStr.toString(); // 로고를 이 변수에 담는다. 
  }


  public void launch(int port) { // 로고를 쓰려면  생성 
    try( ServerSocket serverSocket = new ServerSocket(port)) { 
      // 포트번호 언제든지 바꿀 수 있게 번호대신 포트로 받는다.
      System.out.println("서버 실행중..");

      while (true) { 
        // 메인 스레드와 분리해서 requestHandler에있는 run메서드 코드값을 start하고
        // 즉시 다음 클라이언트 요청을 기다린다. 
        // 실행할 때 serverSocket.accept()부터 실행 리턴하지않으면 실행도 안함 
        // 특정 클래스안에서만 사용되는 클래스 = 중첩 클래스 
        new RequestHandler(serverSocket.accept()).start();
        //accept()).log.start() 할 필요가 없음 
        // RequestHandler가 하나의 클래스로써 멤버라서 바깥클래스의 인스턴스변수를 마음대로 사용가능 
      }
    }catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }

  public static void main(String[] args) {
    new CalculatorServer().launch(8888); 
  }

  // 내부에서 쓸거기때문에 공개할 필요가 없다. 
  class RequestHandler extends Thread {
    Socket socket; // socket인스턴스 변수 보관 

    public RequestHandler(Socket socket) { // thread 객체를 생성할 때 소켓을 받도록
      this.socket = socket; // 파라미터 소켓을 보관해두었다가 
    }

    @Override
    public void run() { //메서드 호출 될 때 
      try( 
          Socket socket2 = socket; 
          // close() 자동 호출하기 위해 
          // close()는 내부에서 쓸려고 만드는게 아니라 리턴해주려고 만드는것
          // 파라미터로 넘겨주는데 사용하기도함
          // 소켓을 다 썼으면 닫기 위해서 입출력스트림을 먼저 닫고 소켓을 닫아야한다. 
          // 서로 문자를 주고받을 수 있도록 입출력 스트림 준비 
          Scanner in= new Scanner(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream()); // 한줄을 출력 
          ) {

        out.print(logo); // 로고 출력 

        out.println("계산식을 입력하세요!");
        out.println("예) 23 + 7");
        out.println();

        while(true) { // 무한루프 
          String str= in.nextLine(); // 클라이언트가 보낸걸 읽는데 
          if(str.equals("quit")) { // 클라이언트가 quit이라는 명령어 보내면 
            out.println("Goodbye!"); //클라이언트에게 goodbye라고 메세지 보내고 
            out.flush(); //무조건 쓰기!
            break; // 즉시 반복문 나가고 그밖에는 출력한다. 
          }

          try { // 예외가 발생할 수 있으니 try 구문 사용 
            String[] values = str.split(""); // quit이 아니면 쪼갠문자열을 배열로 리턴 
            int a = Integer.parseInt(values[0]); //0번째 값을 정수로 바꿈 
            int b = Integer.parseInt(values[2]); //2번째 값을 정수로 바꿈 
            String op = values[1]; // 1번째 값은 연산자 

            switch(op) { // 작업을 수행 
              case "+": out.printf("%d %s %d = %d\n", a, op, b, a + b); break;
              case "-": out.printf("%d %s %d = %d\n", a, op, b, a - b); break;
              case "*": out.printf("%d %s %d = %d\n", a, op, b, a * b); break;
              case "/": out.printf("%d %s %d = %d\n", a, op, b, a / b); break;
              case "%": out.printf("%d %s %d = %d\n", a, op, b, a % b); break;
              default:out.printf("%d %s %d = %s\n", a, op, b,  "지원하지 않는 연산입니다."); 
            }
            out.flush(); // flush 잊지말기 

          }catch(Exception e) { // 예외가 발생하면 예외 메세지와 함께 출력 
            // try~catch구문안에 1개 이상 들어갈수 있다. 
            out.println("계산 중 오류 발생 - " + e.getMessage());
            out.flush();
          }
        }

      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      }
    }
  }
}

// out.print(CalculatorServer.this.logo); 
// 내장변수 this 는 innerclass에서 바깥 클래스의 마치 자기 변수인 마냥 생략 가능 
// 중첩클래스는 바깥 변수를 받을 필요가 없다. 
// 대신 바깥 클래스임을 알려주기 위해서 calculatorServer의 클래스에 인스턴스안에 있는 로고라고 표시 
// 이점이 있어야할 거 아님 
// 바깥클래스의 객체 주소가 this(빌트인변수)에 들어있다. 

// non-static nested class = inner class 
// 바깥클래스의 인스턴스 변수를 쓸 때 생략가능 그래서 out.print(logo); 



