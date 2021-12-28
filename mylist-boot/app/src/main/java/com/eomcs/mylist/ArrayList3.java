package com.eomcs.mylist;

public class ArrayList3 {
  static Object[] list= new Object[5]; 
  static int size = 0;

  // 기능: 
  // - 배열에 항목을 추가한다. 
  // - 배열이 꽉찼으면 배열의 크기를 늘린다.
  // 
  static void add(Object obj) {
    if (size == list.length) { // 배열이 꽉찼다면,
      list = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    list[size++] = obj;
  }

  // 기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  //
  static Object[] grow() {
    Board[] arr = new Board[newLength()];
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
  static void copy(Object[] source, Object[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  // 기능: 
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다. 
  // 
  static Object[] toArray() {
    Object[] arr= new Object[size];
    for (int i = 0; i < size ; i++) { 
      arr[i] = list[i]; 
    }
    return arr; 
  }

  //기능:
  // - 배열에서 지정한 항목을 삭제한다.
  // 손코딩 문제 나옴... ㅠㅠ 
  static Object remove(int index) {
    Object old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    size--;
    return old;
  }

  // 기능:
  // - 배열의 특정 위치에 값을 변경한다. 
  // - 리턴 값: 변경하기 전에 저장되어 있던 값 
  //
  static Object set (int index, Object obj) {
    if (index < 0 || index >= size) { //값이 저장된 위치가 무효한 인덱스라면 
      return null;

    }
    Object old = list[index]; // 이 위치에 있던 값을 old 에 저장 
    list[index] = obj; // 새 값을 그 위치에 저장 
    return old; // 기존 값은 사라지고 옛날 값을 리턴 
  }

  static Object get (int index) {
    if (index < 0 || index >= size) { //값이 저장된 위치가 무효한 인덱스라면 
      return null;
    }
    return list[index];
  }
}

