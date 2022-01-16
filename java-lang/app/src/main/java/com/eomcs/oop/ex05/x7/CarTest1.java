package com.eomcs.oop.ex05.x7;

public class CarTest1 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    testSedan(sedan);
    System.out.println("---------------------");

    Truck truck = new Truck();
    testTruck(truck);
    System.out.println("-----------------------");

    static void testSedan(Sedan car) {
      car.run();

    }

  }

  private static void testSedan(Sedan sedan) {
    // TODO Auto-generated method stub

  }

}
