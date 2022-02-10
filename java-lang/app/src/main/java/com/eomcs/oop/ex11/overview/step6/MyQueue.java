package com.eomcs.oop.ex11.overview.step6;


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

  public Iterator iterator( ) {
    class QueueIterator implements Iterator{
      
      @Override
      public boolean hasNext() {
        return MyQueue.this.size() > 0;
      }
      

      @Override
        public Object next() {
          return MyQueue.this.poll();
        }
    }
    return new QueueIterator();
  }
  
  
}

