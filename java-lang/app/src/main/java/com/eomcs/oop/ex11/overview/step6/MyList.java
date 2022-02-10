package com.eomcs.oop.ex11.overview.step6;

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
    // local class(로컬 클래스, 중첩클래스의 일종)
    // - 메서드나 특정 블록 안에서만 사용될 클래스라면 사용범위를 더 제한할 수 있다. 
    //   그 메서드나 블록에서 클래스를 정의함으로써 명시적으로 사용 범위를 더 제한할 수 있다. 
    // - 단지 사용 범위를 더 제한한 것에 불과하다. 
    //   로컬변수에 public, protected, private 못붙이듯이 로컬클래스에도 붙일 수 없다.
    // - 로컬 클래스에도 바깥 클래스의 인스턴스 주소를 저장할 필드와 생성자가 자동으로 추가된다. 
    //   navigator > step6> MyList$1ListIterator.class (로컬클래스에는 $1이 붙는다)
    //   따로 컴파일되어 바깥소스코드를 뽑아서 바깥에 별도클래스로 뽑아낸다. 
    //   컴파일 된다음에는 바로 return new ListIterator(); 이 된다. 
    class ListIterator implements Iterator {

     int cursor;


     @Override
     public boolean hasNext() {
       return cursor < MyList.this.size();
     }

     @Override
     public Object next() {
       return MyList.this.get(cursor++);
     }
   }
    return new ListIterator();
  }
  
  
  

}


