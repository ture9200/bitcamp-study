package com.eomcs.mylist.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.eomcs.mylist.domain.Member;

// ����:
// - ��û�� ��� �� ��, ��� �׽�Ʈ�� ���� �ڵ����� �α��� ��Ų��.
//
@WebListener
public class AutoLoginListener implements ServletRequestListener {
  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    System.out.println("AutoLoginListener.requestInitialized() ȣ���!");
    Member loginUser = new Member();
    loginUser.setNo(2);
    loginUser.setName("user2");

    HttpServletRequest httpRequest = (HttpServletRequest) sre.getServletRequest(); 
    HttpSession session = httpRequest.getSession();
    session.setAttribute("loginUser", loginUser);
  }
}

