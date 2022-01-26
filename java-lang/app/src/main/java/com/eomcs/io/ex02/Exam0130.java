// Byte Stream - 바이트 단위로 읽기 II
package com.eomcs.io.ex02;

import java.io.FileInputStream;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/test1.data");

    // 반복문을 이용하여 여러 바이트를 읽는다.
    int b; //1바이트값을 받을 변수 준비 
    /*
      while (true) { // 무한루프 
        b = in.read(); //read라는 메서드의 int값이 b에 저장 
        if (b == -1) // 파일의 끝에 도달하면 -1을 리턴한다.
          break;
        System.out.printf("%02x ", b);
      }
     */ // 아래와 같이 쓰는것을 더 추천한다. 
    while ((b = in.read()) != -1) {
      System.out.printf("%02x ", b);
    }

    in.close();
  }

}
