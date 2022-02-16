package com.eomcs.app2;

import java.util.Scanner;


    public class App {
      Scanner KeyScan = new Scanner(System.in);
      
      public static void main(String[] args) {
        new App().service(); 
      }
        
        public void service() { 
        
           while(true) {
            printMenu();
            String input= prompt(); 
            
            if(checkQuit(input)) {
              break;
            }
            
             switch(input) {
               case "1":
                 createScore();
                 break;
               case "2":
                 listScore();
                 break;
               case "3":
                 deleteScore();
                 break;
               case "4":
                 updateScore();
                 break;
               case "5":
                 deleteScore();
                 break;
                 default:
                   System.out.println("올바른 메뉴 번호를 입력하세요!");
             }
           }
           System.out.println("종료!");
           KeyScan.close();
        }
     private void printMenu() {
        System.out.println("메뉴:");
        System.out.println("1. 등록");
        System.out.println("2. 조회");
        System.out.println("3. 상세");
        System.out.println("4. 변경");
        System.out.println("5. 삭제");
        }
     
     private String prompt() {
       System.out.println("명령> ");
       return KeyScan.nextLine();
     }
     
     private boolean checkQuit(String input) {
       return input.equals("quit") || input.equals("exit");
       }
     
     private void createScore() { 
       
     }
     
     private void listScore() {
       
     }
     
     private void detailScore() { 
       
     }
     
     private void updateScore() {
       
     }
     
     private void deleteScore() { 
       
     }
     }

