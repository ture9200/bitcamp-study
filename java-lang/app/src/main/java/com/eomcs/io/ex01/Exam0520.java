// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기 II
package com.eomcs.io.ex01;

import java.io.File;
import java.sql.Date;

public class Exam0520 {

  public static void main(String[] args) throws Exception {

    File dir = new File(".");

    // 파일이나 디렉토리 정보를 File 객체로 받기
    // => File은 디렉토리와 파일을 통칭하는 용어다.
    // 파일이냐 디렉토리냐 구분을 하고 싶다. 
    //  배열로 리턴 
    File[] files = dir.listFiles();

    for (File file : files) {
      System.out.printf("%s   %s %12d %s\n",
          // %s %12d %s\n" 날짜(YYYY-MM-DD , 최대 12자리 확보한 다음 길이를 출력) 
          file.isDirectory() ? "d" : "-",     //조건연산자 , - : 파일
              new Date(file.lastModified()), 
              // lastmodified 마지막 변경된 날짜 
              // 리턴값이 long , 1970년 1월 1일 0시 0분 0초부터 지금까지 경과된 시간 
              file.length(), // 파일의 크기  
              file.getName()); // 파일의 이름을 순차적으로 출력 
    }
  }
}


