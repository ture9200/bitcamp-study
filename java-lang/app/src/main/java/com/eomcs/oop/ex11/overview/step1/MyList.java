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

  //실기 문제 나옴 
  public Object remove(int index) {
    if (index < 0 || index >= size) { // 만약 0 이하거나 사이즈보다 크거나 같다면 , 무효한 인덱스라면 
      throw new ArrayIndexOutOfBoundsException(); // 예외 던진다. 
    }

    Object old = arr[index];// 삭제할것을 old에 저장 

    for (int i = index; i < (size - 1); i++) { //그 인덱스부터 앞으로 땡기면 
      arr[i] = arr[i+1]; // i+1번째 있는것을 i번째로 붙여넣는것 저장
      // 맨 끝에 있는 경우는 어떻게 처리? 맨 마지막은 반복문 돌면 안됨 
      // 앞으로 값을 땡겻으면 기존의 레퍼런스 주소가 남아있기 때문에 실제적으로 레퍼런스가 하나 증가
      // 가비지 컬렉션에서 가비지로서 다루어질 때 힘들어진다.
      // 레퍼런스 카운트를 증가시키지 않게 하기 위해서 
      // 기존의 배열항목을 레퍼런스를 null 로 초기화 시키는게 필요하다. 
    }

    arr[--size] = null; // 배열의 크기를 줄이고, 마지막 항목에 들어 있는 값을 null로 초기화하여 객체의 레퍼런스를 줄인다.
    // 마지막은 가비지가 안된다. 참조하는 주소가 없어야 가비지가 됨.  
    // 맨마지막까지 안와서 사용하는데 지장은 없음 문제는 null로 안해주면 주소를 갖고 있기 때문 
    // 가비지 = 객체를 더이상 참조하는 변수가 없을 때, 객체주소를 담고있는 변수가 없을 때 
    // 이곳저곳에서 객체 주소가 어딘가에 기록이 되어있으면 
    //  JVM 입장에서는 가비지가 아니고 계속 쓰이고 있구나라고 착각 
    // 객체를 자동으로 청소하는 가비지 컬렉션 같은 시스템 경우는 
    // 개발자가 개발할 때 객체를 참조하는 레퍼런스가 없도록 유념해서 관리 
    

    return old; // 다 옮기면 old값을 리턴
  }
}

