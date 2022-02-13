package com.eomcs.net.ex12.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient extends JFrame {
  private static final long serialVersionUID = 1L;
  
  // 다른 메서드에서 쓰기 위해서 이렇게 따로 빼서 쓴다. 
  // 인스턴스 필드 생성 
  Socket socket;
  DataInputStream in;
  DataOutputStream out;
  String nickname;

  JTextField addressTf = new JTextField(30);
  JTextField portTf = new JTextField(4);
  JButton connectBtn = new JButton("연결"); 
  // HTML 모든 태그에 id 부여하지 말고 찾을 일이 있을 때 부여하기
  // 컴파일하게 되면 이 문장은 chatclient 생성자 첫문장으로 들어가고  JTextField portTf; 로 바뀐다. 

  JTextArea messageListTa = new JTextArea();
  JTextField messageTf = new JTextField(35);

  public ChatClient() {

    String title = "대화명을 입력하세요.\n(2자 이상)";

    while (true) {
   // 대화명을 입력하라는 창이 뜬다. 닉네임을 입력
      nickname = JOptionPane.showInputDialog(title); 
      if (nickname == null) { // nicknamedl null이면 시스템 종료 
        // cancel 버튼 누르면 값을 입력해도 null 이 리턴된다. 
        // 아무것도 입력안하고 ok 누르면 빈 문자열 리턴 
        
        System.exit(0);
      } else if (nickname.length() >= 2) { // 닉네임이 두 자 이상인 경우 
        // nickname.length() > 1 -> 이거보다 직관적이고 가독성이 좋아서 위 방식이 더 낫다. 
        break; //나감. 
      }
      title = "대화명을 다시 입력하세요!\n(2자 이상)"; // 그렇지않으면 대화명을 다시 입력하세요 창이 뜸
    }

    setTitle("채팅!! - " + nickname); // this 생략하기, 코드 자동생성하면 this 붙음 
    // 이 클래스에서 내가 추가한 메서드가 아니고 상속받은 메서드가 일 때 this 명시 

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        if (connectBtn.getText().equals("종료")) { // 
          try {
            out.writeUTF("\\quit");
            out.flush();
          } catch (Exception ex) { // close하다 예외 발생나면  무시 
          }
        }
        try {in.close();} catch (Exception ex) {}
        try {out.close();} catch (Exception ex) {}
        try {socket.close();} catch (Exception ex) {}
        System.exit(0);
      }
    });
    setSize(500, 400);

    Container contentPane = this.getContentPane();
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    topPanel.add(addressTf);
    topPanel.add(portTf);
    connectBtn.addActionListener(this::connectChatServer);
    topPanel.add(connectBtn);
    contentPane.add(topPanel, BorderLayout.NORTH);

    JScrollPane scrollPane = new JScrollPane(messageListTa);
    contentPane.add(scrollPane, BorderLayout.CENTER); 

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체
    bottomPanel.add(messageTf);
    JButton sendBtn = new JButton("보내기");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);
    contentPane.add(bottomPanel, BorderLayout.SOUTH);

    messageTf.addActionListener(this::sendMessage); 
    // 메시지 입력하고 엔터치면 보내지는 기능을 넣는다. 
    // 버튼 이벤트 발생 

    setVisible(true); // 윈도우창 보이게 함 
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //운영체제에 상관없이 동일한 UI 
    // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    // UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); // Linux OS만 가능
    // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Window OS만 가능 
    // UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel"); // Apple OS만 가능 
    // System.out.println(UIManager.getSystemLookAndFeelClassName()); // LookAndFeel 타입을 알 수 있음
    
    new ChatClient();
  }

  public void connectChatServer(ActionEvent e) { 
    if (connectBtn.getText().equals("연결")) { // 버튼을 누르면 gettext를 알아내서 만약에 연결이라는 상태에 있다면 
      try { // 소켓 연결 
        socket = new Socket(
            addressTf.getText(), 
            Integer.parseInt(portTf.getText())); // 포트번호 

        // 서버와 연결되면 
        in = new DataInputStream(socket.getInputStream()); //한줄씩 읽고 
        out = new DataOutputStream(socket.getOutputStream()); //한줄씩 보낸다. 

        out.writeUTF(nickname); // 서버에 보낼 때 내가 누군지 별명 입력 
        out.flush(); 

        new MessageReceiver(in).start(); // 읽을때 사용할 도구를 주면서 서버에서 메세지오면 무조건 메세지 리스트에 출력해 

      } catch (Exception ex) { // 예외발생하면 메세지 창이 보임 
        // 에러를 콘솔창에 출력하지 않게 하기위해 이건 안드로이드 앱쪽에 비슷하게 돌아간다. 
        
        JOptionPane.showMessageDialog(this, "서버 연결 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
      }

      connectBtn.setText("종료"); // 연결이 완료되면 연결 버튼을 종료 버튼으로 바꾼다. 
    } else { // 연결상태가 아니라면 
      try {
        out.writeUTF("\\quit"); // \quit 을 입력해서 보내야한다. 
        out.flush();
      } catch (Exception ex) { // 예외가 발생할때는 무시 
      }
      connectBtn.setText("연결"); // 종료되면 종료버튼을 연결상태로 만든다. 
      messageListTa.setText(""); // 대화내용을 다시 지운다. 그러니까 빈 문자열로 만들어버린다. 
    }
  }

  public void sendMessage(ActionEvent e) {
 // 메시지 입력창에 아무것도 안보내면 서버에 안보내고 리턴 
    if (messageTf.getText().length() == 0) { 
      return; 
    }

    try {
      out.writeUTF(messageTf.getText()); // 메세지 보내야함. 
      out.flush();
      messageTf.setText(""); // 보낸다음 텍스트영역을 빈문자로 처리. 입력한 부분을 clear하기 위해서

    } catch (Exception ex) { // 예외발생하면 메시지 창 띄우기 
      JOptionPane.showMessageDialog(this, "메서지 전송 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  class MessageReceiver extends Thread { // 메시지 수신기 = 읽는 역할 

    DataInputStream in; 

    public MessageReceiver(DataInputStream in) { // DataInputStream을 받는다. 
      this.in = in; 
    }

    @Override
    public void run() { // start를 시키면 무한루프를 돈다. 
      while (true) {
        try { //예외가 발생하면 
          String message = in.readUTF(); // 서버가 보낸 메시지를 기다린다. 
          if (message.equals("<![QUIT[]]>")) { // 서버에서 연결을 끊겠다는 메시지가 오면 스레드를 종료한다.
            break; // 스레드 종료? run() 메서드의 실행을 마치면 스레드는 종료한다.
          }
          messageListTa.append(message + "\n"); // 메세지가 오면 클라이언트 콘솔창에 출력한다.
     
        } catch (Exception e) { // 무시한다. 
        }
      }
    }
  }
}







