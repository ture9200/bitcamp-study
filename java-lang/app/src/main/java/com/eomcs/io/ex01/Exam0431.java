// 특정 폴더를 생성하여 그 폴더에 파일을 만든다.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0431 {

  public static void main(String[] args) throws Exception {
    // 생성할 파일의 경로 설정
    File file = new File("temp/b/test.txt");
    //temp/b = 디렉토리, test.txt = 파일정보 

    // 파일을 생성하기 전에 존재하지 않는 폴더를 생성하고 싶다면,
    //    String path = file.getParent(); // => temp/b (경로까지만 리턴) 
    //    File dir = new File(path); // 경로가지고 파일 객체를 생성한 후 
    File dir = file.getParentFile(); // 위의 코드와 같다.
    // 위의 방법은 두번에 거쳐서 해야한다. 
    // 위의 방법을 하나로 합친것. 
    // 파일 객체 담아서 temp/b 까지만 리턴 
    System.out.println(dir.getCanonicalPath());

    // 먼저 디렉토리를 생성한다.
    if (dir.mkdirs()) {
      System.out.println("디렉토리를 생성하였습니다.");
    } else {
      System.out.println("디렉토리를 생성할 수 없습니다.");
    }

    // 그런 후 파일을 생성한다.
    if (file.createNewFile()) { // 파일 생성
      System.out.println("파일을 생성하였습니다.");
    } else {
      System.out.println("파일을 생성할 수 없습니다.");
    }
  }
}
