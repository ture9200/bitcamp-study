package com.eomcs.util;

import java.util.Scanner;

public class Prompt {
  static Scanner KeyScan = new Scanner(System.in);
  
  public static String promptString(String titleFormat, Object...args) {
    System.out.println(String.format(titleFormat,args));
    return KeyScan.nextLine();
  }
  
  public static int promptInt(String titleFormat, Object...args) {
    return Integer.parseInt(String.format(titleFormat,args));
  }
}
