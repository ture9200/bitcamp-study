// 추상 클래스와 추상 메서드의 활용: 적용 전
package com.eomcs.oop.ex07.b;

import java.util.Arrays;

public class Exam01 {

  static int[] createRandomNumbers(final int size) { 
    // createRandomNumbers에 100을 주면 100을 섞어 리턴 랜덤값을 섞어서 리턴 

    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i;
    }

    int count = size >> 1;
    for (int i = 0; i < count; i++) {
      //임의에있는 위치값 두개를 꺼내서 
      int index1 = (int)(Math.random() * size); 
      int index2 = (int)(Math.random() * size);
      int temp = arr[index1]; //index1에 있는 값을 임시변수값에 담는다. 
      arr[index1] = arr[index2]; //index2에 있는 값을 index1에 담는다. 
      arr[index2] = temp; // temp에 들어있는값을 index2에 담는다. 
    }
    return arr;
  }

  public static void main(String[] args) {

    int[] values = createRandomNumbers(100000);
    // System.out.printf("배열개수:%d\n", values.length);
    int[] values2 = Arrays.copyOf(values, values.length);
    //배열을 복사하는데 사이즈를 준다, 
    //배열과 똑같은 크기에 배열을 복제해서 리턴
    //int[] values와 int[]values2 는 같은 값을 갖는 배열 

    BubbleSort s1 = new BubbleSort(); 
    QuickSort s2 = new QuickSort();

    // 두 개의 정렬 객체가 서로 다른 타입이기 때문에
    // 정렬을 수행하고 출력할 메서드를 따로 따로 만들어야 한다.
    // 클래스의 사용법도 달라서 불편하다.
    // BubbleSort 객체는 run()을 호출해야 하고,
    // QuickSort 객체는 start()를 호출해야 한다.
    //
    display(s1, values); // bubblesort 
    display(s2, values2); //quicksort 

  }

  // 정렬을 수행하는 객체와 값을 주면
  // 그 값을 정렬한 후 출력하는 메서드이다.
  static void display(BubbleSort sorter, int[] values) { // bubblesort, 배열주소로 받는다. 

    //System.out.println("[정렬 전]");
    //printNumbers(values);

    long start = System.currentTimeMillis(); 

    // BubbleSort 사용법에 맞춰 정렬을 수행한다.
    sorter.run(values); //실행 

    long end = System.currentTimeMillis(); //리턴되었던 시간 측정 
    System.out.printf("걸린시간: %d\n", end - start);

    //System.out.println("[정렬 후]--------------------------");
    //printNumbers(values);
  }

  static void display(QuickSort sorter, int[] values) { // quicksort를 받는다. 

    //System.out.println("[정렬 전]");
    //printNumbers(values);

    long start = System.currentTimeMillis();

    // QuickSort 사용법에 맞춰 정렬을 수행한다.
    sorter.start(values, 0, values.length - 1); // 값이 들어있는 배열, 시작점, 몇개인지. 

    long end = System.currentTimeMillis();
    System.out.printf("걸린시간: %d\n", end - start);

    //System.out.println("[정렬 후]--------------------------");
    //printNumbers(values);
  }

  static void printNumbers(int[] values) {
    for (int  value : values) {
      System.out.print(value + ",");
    }
    System.out.println();
  }
}






