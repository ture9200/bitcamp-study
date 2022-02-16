package com.eomcs.algorithm.data_structure.array2.step1;

import com.eomcs.algorithm.data_structure.array2.Score;

public class Test2 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("임꺽정", 90, 90, 90));
    list.add(new Score("유관순", 80, 80, 80));
    list.add(new Score("안중근", 70, 70, 70));
    list.add(new Score("윤봉길", 80, 90, 100));

    // 불편2:
    // => 목록을 값을 저장할 때 원하지 않는 타입의 값이 들어가는 것을 막을 수 없다.
    // 들어가지 못하게 하는 절 지원하는 문법이 제네릭 문법이다. 
    list.add(new String("오호라!")); // 오호라 추가하기 class cast 에러발생

    for (int i = 0; i < list.size(); i++) {
      Score s = (Score) list.get(i);
      System.out.printf("%s: %d, %f\n", s.name, s.sum, s.aver);
    }
  }
}

