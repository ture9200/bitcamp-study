package com.eomcs.oop.ex05.x4.app2;

//자동차를 만들기 

//app1에서 복사해온 Engine에 기능 덧붙이기 
public class CarTest2 {

  public static void main(String[] args) {
    // Car 클래스를 상속 받아 트럭을 위한 덤프 기능을 추가한다.  
    // =>start() , stop() 메서드 추가 

    Truck car = new Truck(); 
    car.start();
    car.run();
    car.dump();
    car.stop();


  }

}
