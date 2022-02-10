// connectionless 클라이언트 - 연결없이 데이터 송신
package com.eomcs.net.ex05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Connectionless
// => 서버와 연결없이 데이터를 보내고 받을 수 있다.
// => DatagramSocket, DatagramPacket을 사용하여 처리한다.
// => 예) 편지, ping 등
// => 응용) 모니터링 프로그램에서 많이 사용한다.
//          보낼때 응답받을 때 시간체크해서 데이터 전송 수신시간이 어느 정도 걸리는지 알아내려할 때 
//          컴퓨터가 살아있는지 여부를 알아내려할 때 
//          기상데이터 센서 : 데이터를 서버에 던진다. 서버가 실행되면 받는거고 아니면 못 받는 것 

public class Client0210 {
  public static void main(String[] args) throws Exception {
    // connectionless 방식으로 통신을 수행할 소켓 생성
    // - 클라이언트 쪽은 포트 번호를 지정하지 않는다.
    // - 물론 OS가 자동으로 부여할 것이다. =stateful이나 stateless 상관없다. 
    DatagramSocket socket = new DatagramSocket();
    // 서버주소와 포트번호를 지정하지 않는다. 
    //강사님 UDP 방식에서 패킷을 집앞에 우체통처럼 담겨져서 서버에서 나중에 받을 수 있는 방법은 아직 없나요? 
    // DatagramSocket이 우체통인것이다.  우체통이  없으면 편지 버려지는거다. 
    // DatagramSocket= 데이터 덩어리를 던지고 받는 일을 하는 소켓 

    // 데이터를 받을 상대편 주소와 포트 번호
    String receiver = "localhost";
    int port = 8888;

    // 보낼 데이터를 바이트 배열로 준비
    // String message = new String("Hello"); // Heap에 String 객체 생성
    // String message = "Hello"; // constant pool에 String 객체 생성
    // byte[] bytes= message.getBytes("UTF-8");
    byte[] bytes = "Hello".getBytes("UTF-8"); // 위의 두 문장을 이렇게 한 줄로 쓴다. 

    // 보낼 데이터를 패킷에 담는다.
    // => 패킷 = 데이터 + 데이터크기 + 받는이의 주소 + 받는이의 포트번호
    DatagramPacket packet = new DatagramPacket(
        bytes, // 데이터가 저장된 바이트 배열
        bytes.length, // 전송할 데이터 개수
        InetAddress.getByName("localhost"), // 데이터를 받을 상대편 아이피 주소, 이메일주소, 로컬 호스트 가능  
        // InetAdress는 안타깝게도 기본 생성자는 있지만 접근 범위가 default
        port // 포트번호
        );

    // 데이터 전송
    socket.send(packet);
    System.out.println("데이터 전송 완료!");

    // 자원해제
    socket.close();  

    // 상대편이 네트웍에 연결되었는지 따지지 않고 무조건 데이터를 보낸다.
    // 만약 상대편이 연결되어 있지 않다면, 보낸 데이터는 그 쪽 네트웍에서 버려진다.
    // => 데이터 송수신을 보장하지 않는다.
  }
}


