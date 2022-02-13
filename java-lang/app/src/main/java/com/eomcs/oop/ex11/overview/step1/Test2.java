package com.eomcs.oop.ex11.overview.step1;

public class Test2 {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    myStack.push("홍길동");
    myStack.push("임꺽정");
    myStack.push("유관순");
    myStack.push("안중근");
    myStack.push("윤봉길");
    myStack.push("김구");
    
   while(myStack.size() >0 ) { // 0보다 크다면 
     
     // stack은 항상 맨 마지막에 저장한것부터 꺼낸다. 넣을때는 순서대로 
     System.out.println(myStack.pop()); // 거꾸로 출력됨 이게 stack에서 데이터를 꺼내는 방법 
    }
   System.out.println(myStack.size);
  }
}
