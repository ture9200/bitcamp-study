package com.eomcs.lang.ex07;

//# 메서드 : 스택 메모리 응용 II - 재귀호출
//
public class Exam0450 {

  static int sum(int value) {
    if (value == 1)
      return 1;

    return value + sum(value - 1);
  }

  public static void main(String[] args) {
    // 다음과 같이 작은 수를 계산 할 때는 재귀호출을 사용하는 것이
    // 코드도 간단하고 이해하기도 쉽다.
    // System.out.println(sum(19100));
    //System.out.println(sum(16000, 100000000));
    System.out.println(sum(5));
  }
}
// JVM Stack 메모리의 사용
// 0) 시작
// 1) main()
// 2) main() => sum(5) 
//           => 5 + sum(4) 
//                  => 4 + sum(3)
//                         => 3 + sum(2)
//                                => 2 + sum(1)
//                                       => 1
// 3) main()
// 4) 종료!
//
// 재귀호출(recursive call)
// - 쫄지 마라!
// - 그냥 다른 메소드를 호출했다고 생각해라.
// - 메서드가 호출되면? 스택에 그 메소드가 사용할 변수가 생성된다. 이것만 기억하라!
// - 수학식을 코드를 표현하기가 편하다.
// - 코드가 간결하다.
// - 그러나 반복문을 사용하는 경우보다 메모리를 많이 사용한다.
// - 멈춰야 할 조건을 빠뜨리면 스택 메모리가 극한으로 증가하여
//   메모리가 부족한 사태에 빠진다.
//   이런 사태를 "stackoverflow"라 부른다.
// - 그래서 큰 수(즉 많이 호출되는 경우)에 대해서 
//   재귀호출을 할 때 스택오버플로우가 자주 발생한다.
// - 메서드 호출이 너무 깊게 들어가지 않는 상황에서 재귀호출을 사용하라.
//


