// Character Stream - 텍스트 읽기 II
package com.eomcs.io.ex03;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exam0430 {

  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("temp/test2.txt");

    // 데코레이터를 붙인다.
    // => 버퍼 기능 + 한 줄 읽기 기능
    BufferedReader in2 = new BufferedReader(in);
    // 문자 스트림을 버퍼 스트림에 저장시킨다. (쉽게 말해 데이터를 버퍼라는 상자에 가공하여 적재시키는 단계) 

    System.out.println(in2.readLine()); // 

    in.close();
  }

}


