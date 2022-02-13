package com.eomcs.oop.ex11.overview.step1;

public class Test1 {
  public static void main(String[] args) {
    MyList myList = new MyList(); 
    myList.add("홍길동");
    myList.add("임꺽정");
    myList.add("유관순");
    myList.add("안중근");
    myList.add("윤봉길");
    myList.add("김구");

    for (int i = 0; i < myList.size(); i++) {
      System.out.println(myList.get(i));// i번째 한개씩 꺼내서 출력, 조회한것 
    }
    System.out.println(myList.size()); // 사이즈 개수 출력 , 조회하기 때문에 6
  }
}