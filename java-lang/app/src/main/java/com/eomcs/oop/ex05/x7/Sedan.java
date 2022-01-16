package com.eomcs.oop.ex05.x7;

public class Sedan extends Car{
  boolean auto;
  boolean openedSunroof;

  @Override
  public void start() {
    System.out.println("출발하다");
  }

  @Override
  public void stop() { 
    System.out.println("멈추다");
  }

  @Override
  public void run() {
    System.out.println("달린다");
  }

  public void openSunroof() {
    System.out.println("썬루프 연다");
    this.openedSunroof =true;
  }

  public void closeSunroof() {
    System.out.println("썬루프 닫는다.");
    this.openedSunroof = false;
  }
}

