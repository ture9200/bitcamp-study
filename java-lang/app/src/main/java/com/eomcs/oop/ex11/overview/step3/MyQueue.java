package com.eomcs.oop.ex11.overview.step3;


public class MyQueue extends MyList {
  public void offer(Object obj) {
    this.add(obj);
  }

  public Object poll() {
    if (size == 0) {
      return null;
    }
    return remove(0);
  }

  @Override
  public Iterator iterator( ) {
    return new QueueIterator(this); // this에 MyQueue 객체가 들어있다. 객체를 주면서 queueIterator를 만들어서 리턴 
    // Iterator 구현체를 리턴 
    // 더이상 queueIterator란 클래스를 알 필요가 없다. = low coupling
    // Iterator 메서드호출할 당시 넘겨준 주소가 파라미터로 넘어감 
    //  this = myQueue  (Test3에 있는 myQueue) 
  }
}

