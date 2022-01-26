// 활용 - 클래스 파일 이름을 출력할 때 패키지 이름을 포함하라. (람다 문법 활용)
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0732 {

  public static void main(String[] args) throws Exception {

    // 클래스 이름을 출력할 때 패키지 이름을 포함해야 한다.
    // 예) ch01.Test01
    // 예) ch22.a.Test14
    //
    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir, ""); //패키지이름이 없다. 
  }

  static void printClasses(File dir, String packageName) {
    // 패키지이름을 받아야해서 파라미터에 추가 
    // 기존의 익명 클래스를 람다 문법으로 교체한다.
    File[] files = dir.listFiles(
        f -> f.isDirectory() || (f.isFile() && f.getName().endsWith(".class")));

    if (packageName.length() > 0) { // 현재 패키지가 0보다 클때만 
      packageName += "."; //. 을 찍는다. 
    }

    for (File file : files) {
      if (file.isDirectory()) {
        printClasses(file, packageName + file.getName());
        //패키지이름에다가 파일이름 출력 

      } else {
        System.out.println(packageName + file.getName().replace(".class", ""));
        //패키지이름 그리고 파일이름.class를 빈문자열로 만들어서 출력  
      }
    }
  }
}


