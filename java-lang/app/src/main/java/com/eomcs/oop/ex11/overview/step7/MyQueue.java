package com.eomcs.oop.ex11.overview.step7;

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
    // anonymous class(익명 클래스)
    // - 클래스의 이름이 없다. 
    // - 그래서 클래스를 정의한 후 따로 인스턴스를 생성할 수 없다. 
    // - 그래서 클래스 정의와 인스턴스 생성 문장이 합쳐져 있다. 
    // - 인터페이스와 수퍼클래스 둘 중 하나만 올 수 있다. 
    // - iterator 인터페이스를 구현한 서브클래스를 만들고 만들자마자 즉시 인스턴스를 생성하고,
    //   이 때 인스턴스를 생성한 후, 호출할 생성자는 수퍼클래스 
    
   return new Iterator() {
     // 수퍼클래스는 Object 
     // iterator 구현체니까 iterator 인터페이스 레퍼런스로 받을 수 있다. 
     // 이 생성자는 수퍼클래스인 object 기본 생성자를 호출하라는 뜻 
     // iterator 인터페이스를 구현한 익명클래스가 있고 
     // 이 익명클래스에 인스턴스를 만들어서 이 자리에 놓는다는 뜻 
     // iterator 구현체가 리턴된다. 정확히는 구현한 객체주소가 리턴된다. 
     // 람다 문법은 메서드 1개짜리 인터페이스만 가능해서 구현 불가능 
      
      @Override
      public boolean hasNext() {
        return MyQueue.this.size() > 0;
      }
      

      @Override
        public Object next() {
          return MyQueue.this.poll();
        }
    };
  }
}

