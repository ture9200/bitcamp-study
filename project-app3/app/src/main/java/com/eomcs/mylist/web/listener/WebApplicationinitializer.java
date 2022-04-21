package com.eomcs.mylist.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.eomcs.mylist.conf.AppConfig;

@WebListener
public class WebApplicationinitializer implements ServletContextListener {
  
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    //
    //
    AnnotationConfigWebApplicationContext 객체관리자 = new AnnotationConfigWebApplicationContext();
    객체관리자.register(AppConfig.class);
    
    //=> ServletContext를 통해 프론트 컨트롤러를 등록한다. 
    DispatcherServlet servlet = new DispatcherServlet(객체관리자);
    ServletRegistration.Dynamic registration = sce.getServletContext().addServlet("app",servlet);
    
    // => 서버에 등록한 프론트 컨트롤러의 동작을 상세히 설정한다. 
    registration.setLoadOnStartup(1); // 웹 애플리케이션이 시작될 떄 프론트 컨트롤러를 자동 생성하라는 의미 
    registration.addMapping("/app/*"); // 클라이언트에서 /app/* 요청이 들어왔으 때 프론트 컨트롤러에게 전달하라는 의미 
  }

}
