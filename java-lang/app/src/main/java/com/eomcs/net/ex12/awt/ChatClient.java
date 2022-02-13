package com.eomcs.net.ex12.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {
  //안드로이드도 똑같이 적용 
  // 한글이 깨진다. 윈도우는 기본 운영체제가 ms949 
  // 내보낼때 ms949형식으로 지정 
  // run configuration > chatClient의 arguments> -Dfile.encoding = MS949 
  
  public ChatClient() {
    super("채팅"); // 수퍼클래스의 기본 생성자를 호출, 수퍼클래스의 채팅을 받는 생성자를 호출 
    addWindowListener(new WindowAdapter() { // 앞에 this 생략 
      @Override
      public void windowClosing(WindowEvent e) {
        //윈도우의 x버튼을 눌렀을 때 
        System.exit(0); //정상적으로 종료할 때 0 
      }  
  });
    setSize(500,400); // chatclient의 창 사이즈 , 실무에서는 this 생략, 너비 높이 지정
    
    Panel topPanel =new Panel(); 
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); //기본 레이아웃 관리자를 교체 , 왼쪽 정렬 
    // 기본이 가운데 설정이라 왼쪽을 기준으로 배치하는 flowlayout Manager를 panel에 기본 레이아웃 매니저로 설정 
    TextField addressTF = new TextField(30); // 로컬호스트 주소 영역 생성 30자정도 입력크기 
    topPanel.add(addressTF);
    TextField portTF = new TextField(4); // 포트 입력 영역 생성 4자정도 입력크기 
    topPanel.add(portTF);
    Button connectBTN = new Button("연결"); // 연결버튼 생성 
    topPanel.add(connectBTN);
    
    add(topPanel, BorderLayout.NORTH); // 보드 레이아웃 윗쪽에 추가하는데 왼쪽에 치우져저서 배치 

    TextArea messageListTa = new TextArea(); // 텍스트 영역을 보드레이아웃 중앙에 배치 
    add(messageListTa, BorderLayout.CENTER); // 위치를 상수값으로 center 정의
    
    Panel bottomPanel = new Panel(); 
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽정렬 
    
    TextField messageTf = new TextField(35); // 텍스트 영역 크기 지정 35자정도 입력크기 
    bottomPanel.add(messageTf);
    
    Button sendBtn = new Button("보내기"); // 윈도우 아랫쪽에 보내기 버튼 생성 
    bottomPanel.add(sendBtn);
    add(bottomPanel,BorderLayout.SOUTH);
    
    setVisible(true);   // 윈도우가 생긴다. this 생략 
  }
  
  public static void main(String[] args) {
   new ChatClient(); //인스턴스 생성 
  } 
}
