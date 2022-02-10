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
  
  public ChatClient() {
    super("채팅");
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        //윈도우의 x버튼을 눌렀을 때 
        System.exit(0); //정상적으로 종료할 때 0 
      }  
  });
    setSize(500,400);
    
    Panel topPanel =new Panel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    TextField addressTF = new TextField(30);
    topPanel.add(addressTF);
    
    TextField portTF = new TextField(4);
    topPanel.add(portTF);
    
    Button connectBTN = new Button("연결");
    topPanel.add(connectBTN);
    
    add(topPanel, BorderLayout.NORTH);
    
    TextArea messageListTa = new TextArea();
    add(messageListTa, BorderLayout.CENTER);
    
    Panel bottomPanel = new Panel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    TextField messageTf = new TextField(35);
    bottomPanel.add(messageTf);
    
    Button sendBtn = new Button("보내기");
    bottomPanel.add(sendBtn);
    
    add(bottomPanel,BorderLayout.SOUTH);
    
    setVisible(true);   
  }
  
  public static void main(String[] args) {
   new ChatClient(); 
  } 
}
