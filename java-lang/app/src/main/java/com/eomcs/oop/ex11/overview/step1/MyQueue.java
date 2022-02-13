package com.eomcs.oop.ex11.overview.step1;


public class MyQueue extends MyList {
  public void offer(Object obj) { 
    this.add(obj); 
  }

  public Object poll() { // 값을 꺼낸다. 
    if (size == 0) { // 더이상 꺼낼 게 없으면 , 큐가 비어있으면 null을 리턴 
      return null; 
    }
    return remove(0); // 그 밖에는 맨 앞에것을 꺼내서 제거한다. 순서대로 꺼낸다. 그래서 0이 나온다.
  }

}

