package com.eomcs.app2;

import com.eomcs.app2.handler.ScoreHandler;
import com.eomcs.app2.net.ScoreTableProxy;
import com.eomcs.util.Prompt;

public class ClientApp {

  public static void main(String[] args) {
    new ClientApp().service();
  }

  public void service() {
    try { // 
      ScoreTableProxy scoreTableProxy = new ScoreTableProxy("localhost", 3336);
      ScoreHandler scoreHandler = new ScoreHandler(scoreTableProxy);

      while (true) {
        printMenu();
        String input = Prompt.promptString("명령> ");

        if (checkQuit(input)) {
          scoreTableProxy.close(); // 
          break;
        }

        try {
          switch (input) {
            case "1": scoreHandler.create(); break;
            case "2": scoreHandler.list(); break;
            case "3": scoreHandler.detail(); break;
            case "4": scoreHandler.update(); break;
            case "5": scoreHandler.delete(); break;
            default:
              System.out.println("올바른 메뉴 번호를 입력하세요!");
          }
        } catch (Exception e) {
          System.out.println("실행 중 오류 발생: " + e.getMessage());
        }
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("서버와 통신하는 중 오류 발생: " + e.getMessage());
    }
    System.out.println("종료!");
  }

  private void printMenu() { // printMenu  출력 
    System.out.println("메뉴:");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }

  private boolean checkQuit(String input) { 
    return input.equals("quit") || input.equals("exit");
  }
}

// 성적 정보를 극대화하는 것 메서드를 캡슐화 시켰고 에를들어 create 누르면 
// 복잡한 기능을 갖는거 알고보면 우리는 끊임없이 복잡한 기능을 캡슐화시키고 
//  그러면서 재사용성을 극대화시키고 사용편의성을 강화시켰다. 
// 클래스로 만든걸 캡슐화 시킨 것 
// 캡슐화 시키면서 어떤 메서드는 공개하고 어떤 메서드는 공개하지 않는 것 
// 네이버에서만 쓰는 메서드 프라이빗해서 공개하지 않고 
// 외부에서 쓰는 메서드 public 으로 공개 
// private, protected, public, 등은 캡슐화를 기반으로 공개하기도하고 감추는 등 접근범위를 제어
//  