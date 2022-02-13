package com.eomcs.oop.ex11.overview.step2;

//MyStack 컬렉션에서 데이터를 꺼내는 일을 한다. 

public class StackIterator implements Iterator{
  MyStack stack; // 데이터 보관 
  int cursor;
  
  public StackIterator(MyStack stack) { // 생성자에서 stack을 받아야 꺼낸다. 
    this.stack= stack;
}
  
  @Override
  public boolean hasNext() { // 꺼낼게 있는지 물어봄 
    return stack.size() >0; // 현재 스택 사이즈가 0보다 꺼낼게 있으면 꺼낼 게 있다. 
    // 크면 true, 작으면 false 니까 boolean타입이 오는게 맞다. 
  }
  

  @Override
    public Object next() { // 꺼낼게 있으면 pop 호출 
      return stack.pop(); 
    }
}