package com.eomcs.oop.ex05.x6;

public class CarTest3 {
  public static void main(String[] args) {
    Sedan sedan= new Sedan();
    SnowChain snowchain = new SnowChain(sedan);
    testCar(snowchain);

    System.out.println("------------------------");

    Truck truck = new Truck();
    Blackbox blackbox = new Blackbox(truck);
    testCar(blackbox);

    System.out.println("------------------------");

    SUV suv = new SUV();
    SnowChain snowChainSuv = new SnowChain(suv);
    Blackbox blackBoxSuv = new Blackbox(snowChainSuv);
    testCar(blackBoxSuv);
  }

  static void testCar(Car car) {
    car.start();
    car.run();
    car.stop();
  }
}