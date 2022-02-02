// character stream - 출력할 문자 집합 설정하기
package com.eomcs.io.ex03;

import java.io.FileWriter;
import java.nio.charset.Charset;

public class Exam0111 {
  public static void main(String[] args) throws Exception {

    System.out.println(Charset.isSupported("EUC-KR"));
    // 인코딩 가능하면 TRUE 리턴, 못하면 FALSE 리턴 


    // 1) 출력 스트림 객체를 생성할 때  문자 집합을 지정하면 
    //    UCS2 문자열을 해당 문자집합으로 인코딩 한다.
    Charset charset =  Charset.forName("EUC-KR");
    // Forname = euc-kr 정보를 담은 객체를 리턴 => 팩토리메서드 => Charset을 만들어주는 공장메서드 
    //  New로 만들어주는것 객체생성이 복잡할때 사용 

    FileWriter out = new FileWriter("temp/test2.txt", charset);
    // 만약에 true일경우, charset이라는 클래스에 forname에다가 EUC -KR 문자정보를달라고 하고 
    // 그럼 EUC-KR 정보를 리턴하면 CHARSET 주면서 출력하라고 하면 이 문자집합으로 출력해줘 
    // 그래서 EUC-KR 형식으로 출력하게된다. => charset으로 지정된 문자집합으로 출력한다. 

    // 현재 JVM 환경 변수 'file.encoding' 값 알아내기
    System.out.printf("file.encoding=%s\n", System.getProperty("file.encoding"));

    // UCS2에서 한글 '가'는 ac00이다.
    out.write(0x7a6bac00); 
    // - 앞의 2바이트(7a6b)는 버린다.
    // - 뒤의 2바이트(ac00)은 MS949(b0a1) 코드 값으로 변환되어 파일에 출력된다.

    // UCS2에서 영어 'A'는 0041이다.
    out.write(0x7a5f0041);  // 
    // - 앞의 2바이트(7a5f)는 버린다.
    // - 뒤의 2바이트는 MS949(41) 코드 값으로 변환되어 파일에 출력된다.

    out.close();

    System.out.println("출력 완료!");

  }
}
