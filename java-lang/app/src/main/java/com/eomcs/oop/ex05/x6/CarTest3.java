package com.eomcs.oop.ex05.x6;

public class CarTest3 {
  public static void main(String[] args) {
    //Sedan에 snowchain 붙여서 테스트  
    Sedan sedan= new Sedan();
    SnowChain snowchain = new SnowChain(sedan); //세단에 snowchain 붙인다. 
    testCar(snowchain);

    System.out.println("------------------------");

    //블랙박스 단 트럭 테스트하기 
    Truck truck = new Truck();
    Blackbox blackbox = new Blackbox(truck);//트럭에 블랙박스 붙인다. 
    testCar(blackbox); 

    System.out.println("------------------------");

    // snowchain, blackbox를 suv에 장착후 테스트하기 
    SUV suv = new SUV();
    SnowChain snowChainSuv = new SnowChain(suv); // suv에 snowchain붙인다. 
    Blackbox blackBoxSuv = new Blackbox(snowChainSuv);//그리고 블랙박스붙인다. 
    testCar(blackBoxSuv); // blackboxsuv 테스트해라. 
  }

  static void testCar(Car car) {
    car.start();
    car.run();
    car.stop();
  }
}