// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0510 {

  public static void main(String[] args) throws Exception {

    // 현재 폴더의 정보를 알아낸다.
    File dir = new File(".");

    // 현재 폴더에 있는 파일이나 하위 디렉토리 이름을 알아내기
    String[] names = dir.list(); 
    // 현재 폴더의 리스트를 호출하면, 
    // 폴더아래있는 모든 직계자식 (손주는 아님). 
    // 디렉토리 목록과 파일목록을 문자열 배열로 담아서 리턴 

    for (String name : names) {
      System.out.println(name);
    }
  }
}


