package com.eomcs.oop.ex11.overview.step1;

import java.util.EmptyStackException;

public class MyStack extends MyList {
  public void push(Object obj) {
    this.add(obj); // 상속받은 메서드에 add시킴 
  }
  
  public Object pop() {  // 꺼낼때는 맨 끝에부터 꺼낸다. 
    if(size == 0) {
      throw new EmptyStackException(); // 더 이상 꺼낼게 없으면 에러를 띄운다. 
    }
    return remove(size -1); // size에서 하나 줄이면 바로 맨 끝에 항목을 remove 
    // 아예 꺼내버려서 mystack.size 하면 0이 나온다. 
    
  }

}
