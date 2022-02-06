package com.eomcs.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServerApp {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ServerApp.class, args);
  }

  @RequestMapping("/help") // 클라이언트가 help라는 요청이 들어오면 
  public String help() {  // 리턴 값이 string 
    StringBuilder strBuilder = new StringBuilder(); 
    strBuilder.append("<!DOCTYPE html>\n"); //html 만들어서 보내기 
    strBuilder.append("<html><head><meta charset='UTF-8'><title>웹계산기</title></head>\n");
    strBuilder.append("<body>\n");
    strBuilder.append("[웹계산기 도움말]\n"); // 문자열을 출력 
    strBuilder.append("[사용법:<br>\n");
    strBuilder.append("URL 형식 => http://서버주소:포트번호/calc?op=연산자&a=값1&b=값2");
    strBuilder.append("예) http://localhost:8080/calc?op=-&a=100&b=200<br>\n");
    strBuilder.append("</body></html>\n");
    // 개발자가 소스코드보기가 힘들어서 \n 을 붙임 페이지 소스 코드 확인하려할 때 보는데 
    // 텍스트에디터로 출력하기 때문에 \n 효과가 바로 보인다. 
    // 소스 볼때 이해하기 편하라고 사용 

    return strBuilder.toString(); 
  }
}
