// 버퍼 사용 전 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

import java.io.FileInputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls11.pdf");
    //몇번 트랙에 jls11파일이 있는지 몇번 섹터에 있는지 알아야한다. 
    // 한바퀴돌때 읽어야한다. 데이터가 저장된 트랙을 찾고 섹터를 찾아서 섹터를 따라가면서 읽어야한다. 

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;
    while ((b = in.read()) != -1) { // read란 메서드가 한번에 1바이트씩 읽는다. 
      //333만 바이트를 읽으려면 333만 반복해야 된다.

      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis(); // 반복문을 돌기 전에 현재 시간을 기록해둔다 

    System.out.println(endTime - startTime); 
    // 반복문이 끝나면 그 시간을 기록해서 끝난 시간에서 시작한 시간을 뺀다. 둘다 밀리초 
    System.out.println(callCount);
    // 나머지 시간을 출력 

    in.close();
  }

}
