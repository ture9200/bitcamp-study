package com.eomcs.oop.ex05.x6;

public abstract class Car {
  int cc;
  int valve;

  public void start() {
    System.out.println("시동건당 ");
  }

  public void stop() {
    System.out.println("시동끈당");
  }

  public abstract void run();

}

