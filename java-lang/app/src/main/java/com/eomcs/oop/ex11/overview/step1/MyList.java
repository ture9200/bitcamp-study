package com.eomcs.oop.ex11.overview.step1;

import java.util.Arrays;

public class MyList {
  Object[] arr = new Object[10]; // 객체를 주면 객체를 배열에 담을 것 
  int size; // 현재 사이즈 

  public void add(Object obj) { 
    if (size == arr.length) { // 현재 사이즈가 배열의 크기와 같다면 
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1)); 
      // 배열의 크기에다 배열의 크기에 1비트 이동한것 (나누기 2와같다) => 기존의 한 절반정도 크기를 증가 , 50%정도 크게 만듦
      // 리턴한것은 새 배열인데 새 배열을 arr에 담는다. 
    }
    arr[size++] = obj; // 배열에 사이즈번째에다가 obj를 담는다. 담은다음 사이즈를 하나 증가시킨다. 
  }

  public Object get(int index) { //index 주는데 0 이하이거나 현재 입력한 사이즈보다 크거나 같다면 유효한 인덱스가 아니다. 
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException(); //배열범위를 벗어난 오류를 던짐. 
      // 예외는 RuntimeException의 자손이라 throw Exception이 생략가능 , try~catch구문 생략가능 
      // 일반 계열의 exception이라면 try~catch 구문, throw Exception 둘 중 사용해줘야한다. 
    }
    return arr[index]; // 그밖에는 리턴, arr[index] 값을 리턴
  }

  public int size() { // 메서드이름과 필드이름이 같아도 상관없다. 
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
}

