package com.eomcs.mylist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.mylist.controller.ResultMap;
import com.eomcs.mylist.domain.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

// ����� ���� ���θ� �˻��ϴ� ���ͼ���
public class AuthInterceptor implements HandlerInterceptor {

  private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.trace("preHandle() ȣ���!");

    // �α��� ���� �˻�
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      // �α����� ���� �ʾ����� ���� �޽����� JSON �������� ���� �����Ѵ�.
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(new ObjectMapper().writeValueAsString(new ResultMap()
          .setStatus(ResultMap.FAIL)
          .setData("�α��� ���� �ʾҽ��ϴ�!")));

      return false; // ������ ��Ʈ�ѷ��� �������� ���� ��� �����϶�!
    }

    return true; // �α��� �� ���¶��, ��� �����϶�! (��û�� ������ ��Ʈ�ѷ��� �޼��带 ȣ���϶�!)
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    log.trace("postHandle() ȣ���!");
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }
}