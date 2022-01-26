// Byte Stream - 읽은 데이터를 바이트 배열의 특정 위치에 저장하기
package com.eomcs.io.ex02;

import java.io.FileInputStream;

public class Exam0320 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/test1.data");

    // 데이터를 저장할 바이트 100개의 빈 배열을 준비한다.
    byte[] buf = new byte[100];

    // 바이너리 데이터를 읽어 배열에 저장하기
    // read(byte[])
    //   => 읽은 데이터를 바이트 배열에 채운다.
    //   => 리턴 값은 읽은 바이트 수이다.
    // read(byte[], 저장할 위치, 저장하기를 희망하는 개수)
    //   => 읽은 데이터를 "저장할 위치"에 지정된 방부터 개수만큼 저장한다.
    //   => 리턴 값은 실제 읽은 바이트 개수이다.
    int count = in.read(buf, 10, 40); // 40바이트를 읽어 10번 방부터 저장한다.
    //buf 데이터를 저장할 수 있는 유효한 배열의 주소 

    in.close();

    System.out.printf("%d\n", count);

    for (int i = 0; i < 100; i++)
      System.out.printf("%d: %02x \n", i, buf[i]); // 인덱스 번호 값,순으로 출력 

    System.out.println();

  }

}


