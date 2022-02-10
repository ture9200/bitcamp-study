package com.eomcs.oop.ex11.overview.step3;

public class Test3 {
  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.offer("홍길동");
    myQueue.offer("임꺽정");
    myQueue.offer("유관순");
    myQueue.offer("안중근");
    myQueue.offer("윤봉길");
    myQueue.offer("김구");

    Iterator iterator = myQueue.iterator();    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      
      //인스턴스 메서드 안배웠을 때는 MyQueue.iterator(myQueue); 
      //특정클래스에 종속이 안되어있겠끔 좀 더 유연하고 유지보수하기 좋은 구조로 만듦
    }
  }
}
