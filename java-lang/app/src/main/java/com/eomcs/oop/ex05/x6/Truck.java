package com.eomcs.oop.ex05.x6;

public  class Truck extends Car {

  int weight;

  @Override
  public void run() {
    //기존에 이미 있는 메서드를 호출한다. 
    this.go();
  }

  @Override
  public void start() {
    // TODO Auto-generated method stub
    this.launch();
  }

  @Override
  public void stop() {
    this.stopping();
  }

  public void launch() {
    System.out.println("출바아아아알");
  }

  public void stopping() {
    System.out.println("멈춘당");
  }

  public void go() {
    System.out.println("갑니당");
  }

  public void dump() {
    System.out.println("짐을 내린당");
  }
}
