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

  Socket socket;
  DataInputStream in;
  DataOutputStream out;
  String nickname;

  JTextField addressTf = new JTextField(30);
  JTextField portTf = new JTextField(4);
  JButton connectBtn = new JButton("연결");

  JTextArea messageListTa = new JTextArea();
  JTextField messageTf = new JTextField(35);

  public ChatClient() {

    String title = "대화명을 입력하세요.\n(2자 이상)";

    while (true) {
      nickname = JOptionPane.showInputDialog(title);
      if (nickname == null) {
        System.exit(0);
      } else if (nickname.length() >= 2) {
        break;
      }
      title = "대화명을 다시 입력하세요!\n(2자 이상)";
    }

    setTitle("채팅!! - " + nickname);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        if (connectBtn.getText().equals("종료")) { // 
          try {
            out.writeUTF("\\quit");
            out.flush();
          } catch (Exception ex) { 
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

    setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    new ChatClient();
  }

  public void connectChatServer(ActionEvent e) {
    if (connectBtn.getText().equals("연결")) {
      try {
        socket = new Socket(
            addressTf.getText(), 
            Integer.parseInt(portTf.getText()));

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        out.writeUTF(nickname);
        out.flush();

        new MessageReceiver(in).start(); // 읽을때 사용할 도구를 주면서 서버에서 메세지오면 무조건 메세지 리스트에 출력해 

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "서버 연결 오류!", "통신 오류!", JOptionPane.ERROR_MESSAGE);
      }

      connectBtn.setText("종료");
    } else {
      try {
        out.writeUTF("\\quit");
        out.flush();
      } catch (Exception ex) { 
      }
      connectBtn.setText("연결");
      messageListTa.setText("");
    }
  }

  public void sendMessage(ActionEvent e) {
    if (messageTf.getText().length() == 0) {
      return;
    }

    try {
      out.writeUTF(messageTf.getText());
      out.flush();
      messageTf.setText("");

    } catch (Exception ex) {
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
          messageListTa.append(message + "\n"); // 메세지가 오면 출력한다. 

        } catch (Exception e) { // 무시한다. 
        }
      }
    }
  }
}







