package com.eomcs.util;

import java.util.Scanner;

public class Prompt {
  static Scanner KeyScan = new Scanner(System.in);
  
  public static String promptString(String titleFormat, Object...args) {
    System.out.println(String.format(titleFormat,args));
    return KeyScan.nextLine();
  }
  
  public static int promptInt(String titleFormat, Object...args) {
    //2 화면에 입력 하라는 메시지 출려( titleFormat: %s, args "국어 ?")
    //System.out.println(String.format(titleFormat,args));
    // 입력된 다음 행의 값을 읽어 숫자로 변경해서 리턴
    //return Integer.parseInt(KeyScan.nextLine());
    //return Integer.parseInt(String.format(titleFormat,args));
    return Integer.parseInt(promptString(titleFormat,args));
  }
}
