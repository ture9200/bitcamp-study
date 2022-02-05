package com.eomcs.app1;

import java.util.Scanner;

public class App01 {
  static Scanner keyScan = new Scanner(System.in);

  //  static {
  //    keyScan = new Scanner(System.in); 
  //  }

  //java.util.Scanner keyScan = new java.util.Scanner(System.in);
  // 1) 키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다.

  public static void main(String[] args) {

    Console console = new Console();
    CommandHandler commandHandler = new CommandHandler();

    while(true) {
      Command command  =  console.prompt();

      if(command.getName().equals("quit") || command.getName().equals("exit") ) {
        break;

      }else if(command.getName().equals("")) {
        continue;

      }else if (command.getName().equals("help")) {
        commandHandler.doHelp();

      }else if (command.getName().equals("add")) {
        commandHandler.doAdd(command);

      }else if (command.getName().equals("minus")) {
        commandHandler.doMinus(command);

      }else if (command.getName().equals("divide")) {
        commandHandler.doDivide(command);

        //      }else if (command.getName().equals("multiple")) {
        //        commandHandler.doMultiple(command);

      }else {
        System.out.println("지원하지 않는 연산자입니다.");
      }
    }
    console.close();
  }
}




