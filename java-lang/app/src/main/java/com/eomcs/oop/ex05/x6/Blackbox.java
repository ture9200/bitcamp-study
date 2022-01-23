package com.eomcs.oop.ex05.x6;

public class Blackbox extends Option{
  public Blackbox(Car car) {
    super(car);
  }

  @Override
  public void run() {
    car.run();
  }

  @Override
  public void start() {
    super.start(); // 시동건다. 
    System.out.println("녹화시작!"); // 녹화시작 
    // 문장이 반대면 녹화시작 후 시동건다. 
  }

  @Override
  public void stop() {
    super.stop(); // 시동끈다. 
    System.out.println("녹화종료!"); //녹화종료 
    // 문장이 반대면 녹화종료후 시동끈다. 

  }
}  
