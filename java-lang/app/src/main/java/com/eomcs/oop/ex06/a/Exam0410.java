// 다형성 - 다형적 변수의 활용
package com.eomcs.oop.ex06.a;

public class Exam0410 {

  // Sedan과 Truck의 모델명과 cc를 출력하라!

  public static void printSedan(Sedan sedan) {
    // Sedan의 subclass를 파라미터로 넘겨줄수 있다. 
    System.out.printf("모델명: %s\n", sedan.model); // Vehicle의 설계도로 만든 인스턴스 변수
    System.out.printf("cc: %d\n", sedan.cc); // Car 설계도로 만든 인스턴스 변수
    System.out.println("-------------------------");
  }

  public static void main(String[] args) throws Exception {
    java.io.PrintStream obj = new java.io.PrintStream(new java.io.FileOutputStream("a.data"));
    //파라미터 생성자가 OutputStream이고 OutputStream이면 추상클래스이면
    //인스턴스를 만들수 있는 OutputStream의 subclass를 넘겨주면 된다. =>다형적 변수 
    //FileOutputStream 은 OutputStream의 subclass다. 
    //ByteOutputStream을 넘겨줄 수도 있다. OutputStream의 subclass이기때문이다. 

    Sedan sedan = new Sedan();
    sedan.model = "티코";
    sedan.cc = 800;

    Truck truck = new Truck();
    truck.model = "타이탄II";
    truck.cc = 10000;

    printSedan(sedan);

    // printSedan()의 파라미터는 Sedan 객체의 주소만 받을 수 있다.
    // 그래서 Truck 객체를 전달할 수 없다.
    //    printSedan(truck); // 컴파일 오류!

    // Truck 인스턴스에서 model과 cc 값을 꺼내서 출력할 메서드를
    // 따로 만들어야 한다.
  }

}




