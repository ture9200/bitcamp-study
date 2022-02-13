package com.eomcs.oop.ex11.overview.step2;

public class Test1 {
  public static void main(String[] args) {
    MyList myList = new MyList(); // mylist 
    myList.add("홍길동");
    myList.add("임꺽정");
    myList.add("유관순");
    myList.add("안중근");
    myList.add("윤봉길");
    myList.add("김구");

    ListIterator iterator = new ListIterator(myList); 
    // ListIterator에게 지금부터 값을 꺼낼 거는 myList로 부터 데이터 꺼내야한다. 
    while (iterator.hasNext()) {  // 꺼낼게 있으면 true  없으면 false 
      System.out.println(iterator.next()); // 한 개씩 꺼내주면서 현재 가리키는 걸 꺼내준다. 
    }
  }
}