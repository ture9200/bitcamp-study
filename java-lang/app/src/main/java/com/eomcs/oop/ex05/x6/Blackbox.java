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
    super.start();
    System.out.println("녹화시작!");
  }

  @Override
  public void stop() {
    super.stop();
    System.out.println("녹화종료!");

  }
}  
