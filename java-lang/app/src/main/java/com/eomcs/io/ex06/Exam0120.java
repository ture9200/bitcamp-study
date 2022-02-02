// 버퍼 사용 후 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");

    byte[] buf = new byte[8192]; // 보통 8KB 정도 메모리를 준비한다. 1KB= 1024 
    int len = 0; // 한번에 몇바이트씩 읽었는지 ... 

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;

    while ((len = in.read(buf)) != -1) { // 한번에 8192 바이트씩 읽는다. 
      //System.out.printf("읽은 바이트의 수:%d\n", len);
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount); //몇번 반복문을 몇번 read 메서드를 호출하는지 확인 
    in.close();
  }

}
