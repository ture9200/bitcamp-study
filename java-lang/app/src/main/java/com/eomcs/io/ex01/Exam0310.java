// 디렉토리 생성
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    // 1) 생성할 디렉토리 경로 설정
    // - 폴더 경로를 지정하지 않으면 현재 폴더를 의미한다.
    //
    File dir = new File("temp");
    if (dir.mkdir()) { // 디렉토리 생성
      // 파일 클래스에 디렉토리 만드는 메서드가 있다. mkdir 
      // 파일클래스로 디렉토리 만들 수 있다. 
      // 정상적으로 생성했으면 리턴값이 true
      // 리턴하지 않았으면 리턴값이 false 
      System.out.println("temp 디렉토리를 생성하였습니다.");
    } else {
      System.out.println("temp 디렉토리를 생성할 수 없습니다.");
      // 파일이 존재하는데 또 디렉토리를 생성한다고 하면 생성할 수 없다고 출력
    }


  }

}
