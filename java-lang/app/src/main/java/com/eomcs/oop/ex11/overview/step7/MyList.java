package com.eomcs.oop.ex11.overview.step7;

import java.util.Arrays;

public class MyList {

  Object[] arr = new Object[10];
  int size;

  public void add(Object obj) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
    }
    arr[size++] = obj;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return arr[index];
  }

  public int size() {
    return size;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }

    Object old = arr[index];

    for (int i = index; i < (size - 1); i++) {
      arr[i] = arr[i+1];
    }

    arr[--size] = null; // 배열의 크기를 줄이고, 마지막 항목에 들어 있는 값을 null로 초기화하여 객체의 레퍼런스를 줄인다.
    return old;
  }

  public Iterator iterator() {
    // anonymous class(익명 클래스)
    // - 클래스의 이름이 없다. 
    // - 그래서 클래스를 정의한 후 따로 인스턴스를 생성할 수 없다. 
    // - 그래서 클래스 정의와 인스턴스 생성 문장이 합쳐져 있다. 
    // - 인터페이스와 수퍼클래스 둘 중 하나만 올 수 있다. 
    // - iterator 인터페이스를 구현한 서브클래스를 만들고 만들자마자 즉시 인스턴스를 생성하고,
    //   이 때 인스턴스를 생성한 후, 호출할 생성자는 수퍼클래스 
    
   return  new  Iterator() { // 수퍼클래스는 Object 
     // iterator 구현체니까 iterator 인터페이스 레퍼런스로 받을 수 있다. 
     // 이 생성자는 수퍼클래스인 object 기본 생성자를 호출하라는 뜻 
     // iterator 인터페이스를 구현한 익명클래스가 있고 
     // 이 익명클래스에 인스턴스를 만들어서 이 자리에 놓는다는 뜻 
     // iterator 구현체가 리턴된다. 정확히는 구현한 객체주소가 리턴된다. 
     // 람다 문법은 메서드 1개짜리 인터페이스만 가능해서 구현 불가능 

      int cursor;

      @Override
      public boolean hasNext() {
        return cursor < MyList.this.size();
      }

      @Override
      public Object next() {
        return MyList.this.get(cursor++);
      }
    };
  }
}


