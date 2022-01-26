// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0730x {

  public static void main(String[] args) throws Exception {
    //IO Exception해도 된다. Exception의 서브라서 
    // static메서드만 호출되는게 가능하다 .
    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);
    //printClasses(dir , ""); // 패키지이름이 없다. 
  }

  static void printClasses(File dir)  {
    //static void printClasses(File dir, String packageName)  {
    //리턴값을 사용하지 않으니까 void
    //파일객체를 넘기니까 파일객체를 받을 파라미터값을 설정 
    class JavaClassFilter implements FileFilter {
      // 파일필터 규칙에 따라 해당되는 목록만 뽑는다면
      @Override
      public boolean accept(File pathname) {
        if(pathname.isFile() && pathname.getName().endsWith(".class") 
            // 파일이고 파일 이름이 .class로 끝나거나 파일이 디렉토리라면 
            ||pathname.isDirectory()) {
          return true; // 목록에 포함시킨다
        }
        return false; // 목록에서 뺸다. 
      } 
    }

    File[] files = dir.listFiles(); // 파일 목록을 리턴 
    for(File f: files) { //파일 배열에서 한개씩 꺼내서 
      if(f.isDirectory()) { //f가 isDirectory라면 
        printClasses(f); // 프린트목록을 출력할때는 현재 f안에 들어있는 디렉토리 목록을 출력 
      } else { //디렉토리 목록이 아니면 
        System.out.println(f.getName()); //f의 이름만 출력 
      }
    }
  }
}




