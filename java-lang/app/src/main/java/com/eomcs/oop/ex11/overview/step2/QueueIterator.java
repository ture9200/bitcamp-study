package com.eomcs.oop.ex11.overview.step2;

//MyQueue 컬렉션에서 데이터를 꺼내는 일을 한다. 

public class QueueIterator implements Iterator{
  MyQueue queue; 
  int cursor;
  
  public QueueIterator(MyQueue myQueue) {
    this.queue= queue;
  }

  @Override
  public boolean hasNext() { // 꺼낼 게 있냐고 물어보면 size() 
    return queue.size() >0;
  }
  

  @Override
    public Object next() { // 꺼낼 게 있으면 poll() 사용 
      return queue.poll();
    }
}