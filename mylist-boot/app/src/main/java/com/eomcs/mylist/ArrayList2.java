package com.eomcs.mylist;

public class ArrayList2 {
  static Todo[] list= new Todo[5]; 
  static int size = 0;


  static Todo remove(int index) {
    Todo old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    size--;
    return old;
  }



  static Todo[] grow() {
    Todo[] arr = new Todo[newLength()];
    copy(list, arr);
    return arr;
  }

  //기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //
  static int newLength() {
    return list.length + (list.length >> 1);
  }

  //기능: 
  // - 배열을 복사한다.
  // 
  static void copy(Todo[] source, Todo[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  static Todo[] toArray() {
    Todo[] arr= new Todo[size];
    for (int i = 0; i < size ; i++) { 
      arr[i] = list[i]; 
    }
    return arr; 
  }

  static void add(Todo contact) {
    if (size == list.length) { // 배열이 꽉찼다면,
      list = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    list[size++] = contact;
  }

  static Todo set (int index, Todo contact) {
    if (index < 0 || index >= size) { //값이 저장된 위치가 무효한 인덱스라면 
      return null;

    }
    Todo old = list[index];
    list[index] = contact;
    return old;
  }
}
