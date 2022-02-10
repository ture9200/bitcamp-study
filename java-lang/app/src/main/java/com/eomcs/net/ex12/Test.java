package com.eomcs.net.ex12;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
  public static void main(String[] args) {
    Frame f = new Frame(); // 윈도우 컨테이너 , 운영체제 껍데기 
    // 윈도우 객체와 연결되어있어 peer(동료)라고 부름, 윈도우 컨트롤 
    // ms949사용해서 한글이 깨짐 

    class MyWindowListener extends WindowAdapter {
      @Override
      public void windowClosing(WindowEvent e) { // close버튼을 누르면 창 닫기 
        //windowClosing이 여기서 자바스크립트의 addEventListener 역할 
        // 자바스크립트에서는 이벤트가 발생했을 때 호출될 함수를 만들었는데 
        // 여기서는 호출될 함수가 이 함수 
        // 자바스크립트와 자바의 차이는 자바스크립트는 함수를 그대로 세팅할 수 있지만 
        // 자바는 자바스크립트와 달리 함수를 그대로 세팅할 수 없고 함수를 클래스안에 담아서 세팅
        System.exit(0);
      }
    }
 // 그래서 MyWindowListener() 라는 클래스에 담아서 규칙에 따라서 윈도우리스너를 정의후 등록 
    f.addWindowListener(new MyWindowListener());  
    f.setSize(300,200); // 300, 200 크기의 윈도우 설정 
    f.setVisible(true); // 화면 보임 

  }

}
