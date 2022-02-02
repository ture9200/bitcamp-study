// 객체 읽기 - 파일이 데이터를 읽어 인스턴스로 만들기 
package com.eomcs.io.ex05;

import java.io.FileInputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/test4.data");

    Member member = null;

    member = new Member();

    // 출력된 순서에 따라서 그대로 읽어야한다. 
    // 1) 이름 읽기
    int size = in.read(); // 이름이 저장된 바이트 배열의 수, 문자열읽을때 1바이트로 읽음 
    byte[] buf = new byte[size]; //개수만큼 배열로 만들고 
    in.read(buf); // 이름 배열 개수 만큼 바이트를 읽어 배열에 저장한다.
    //배열에다가 읽은 데이터를 채워넣는다. (배열크기만큼 채운다) 
    member.name = new String(buf, "UTF-8"); 
    // UTF -8 charset 코드가 저장(인코드, 코드화)된걸 읽어서 UTF-16으로 바꿔서 JVM 문자열로 리턴

    // 2) 나이(int) 읽기
    member.age = in.read() << 24;
    member.age += in.read() << 16;
    member.age += in.read() << 8;
    member.age += in.read();

    // 3) 성별 읽기
    if (in.read() == 1) 
      member.gender = true;
    else 
      member.gender = false;

    in.close();

    System.out.printf("%s\n", member);
  }
}






