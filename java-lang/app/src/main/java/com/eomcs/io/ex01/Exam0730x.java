// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import org.apache.logging.log4j.core.jackson.ContextDataAsEntryListSerializer;

public class Exam0730x {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);
  }

  static void printClasses(File dir) {

    File[] files = dir.listFiles(new FileFilter() {

      for(File f: files) {
        if(f.isFile() && f.getName().endsWith(".class")) {

        }ContextDataAsEntryListSe 
        printClasses(f);
      } else {
        System.out.println(f.getName());
      }
    }
  }


