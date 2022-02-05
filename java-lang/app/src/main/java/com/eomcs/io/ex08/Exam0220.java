// 포함 관계로 기능 확장하기 - FileInputStream + DataInputStream
package com.eomcs.io.ex08;

import java.io.FileInputStream;

public class Exam0220 {

  public static void main(String[] args) throws Exception {

    FileInputStream in1 = new FileInputStream("temp/member.data");

    // 문자열, int, long, boolean 값을 읽는 것은 DataInputStream 에 맡긴다.
    // => FileInputStream에 DataInputStream의 기능을 덧붙인다.
    // => in1 자리에 FileInputStream이 있다. 
    DataInputStream in2 = new DataInputStream(in1);

    Member member = new Member();

    member.name = in2.readUTF(); //문자열 읽어라 
    member.age = in2.readInt(); // int값 읽어라 
    member.gender = in2.readBoolean(); //Boolean 값 읽어라

    in2.close();

    System.out.println(member);
  }

}
