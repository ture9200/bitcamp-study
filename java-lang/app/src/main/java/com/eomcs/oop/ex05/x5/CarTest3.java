package com.eomcs.oop.ex05.x5;

public class CarTest3 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();

    ElectricEngine electricOption = new ElectricEngine(sedan);
    electricOption.chargeBattery(100);

    Trailer trailer = new Trailer(sedan);
    // 트레일러를 sedan으로 받았다. 
    trailer.start();
    trailer.run();
    // run을 호출하면 car한테 위임을 하고 덧붙이고 싶은 기능이 있으면 수행한다. 
    trailer.stop();

    System.out.println("----------------------------");

    Truck truck = new Truck();
    ElectricEngine electricOption2 = new ElectricEngine(truck);
    electricOption2.chargeBattery(300);
    electricOption2.start();
    electricOption2.run();
    electricOption2.stop();
  }

}