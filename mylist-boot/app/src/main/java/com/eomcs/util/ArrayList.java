package com.eomcs.util;

public class ArrayList implements java.io.Serializable{

  //인스턴스 필드(변수)
  // => 인스턴스 필드는 new 명령을 통해 생성한다.  
  Object[] list= new Object[5]; 
  int size = 0;

  public ArrayList() {}

  public ArrayList(Object[] arr) {
    this.addAll(arr); 
  }

  // 기능: 
  // - 배열에 항목을 추가한다. 
  // - 배열이 꽉찼으면 배열의 크기를 늘린다.
  // 
  //인스턴스 주소를 앞쪽에서 받으려면 static 키워드를 붙이면 안된다. 
  // non-static 메서드로 정의해야 한다. 
  // 그리고 메서드가 호출될 때 받은 인스턴스를 사용하려면 내장 변수 this를 이용해야 한다.
  public void add(Object obj) {
    if (this.size == this.list.length) { // 배열이 꽉찼다면,
      this.list = this.grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    this.list[this.size++] = obj;
  }

  public void addAll(Object[] arr) { //배열을 주면 
    for(Object obj : arr) {
      this.add(obj); // 하니씩 꺼내자 . 
    }
  }

  // 기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  //
  Object[] grow() {
    Object[] arr = new Object[this.newLength()];
    this.copy(arr);
    return arr;
  }

  //기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //
  int newLength() {
    return this.list.length + (this.list.length >> 1);
  }

  //기능: 
  // - 배열을 복사한다.
  // 
  void copy( Object[] target) {
    int length = this.list.length;
    if (target.length < this.list.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = this.list[i];
    }
  }

  // 기능: 
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한다. 
  // 
  public Object[] toArray() {
    Object[] arr= new Object[this.size];
    for (int i = 0; i < this.size ; i++) { 
      arr[i] = this.list[i]; 
    }
    return arr; 
  }

  //기능:
  // - 배열에서 지정한 항목을 삭제한다.
  // 손코딩 문제 나옴... ㅠㅠ 
  public Object remove(int index) {
    if (index < 0 || index >= this.size) { //값이 저장된 위치가 무효한 인덱스라면 
      return null;
    }
    Object old = this.list[index];
    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.size--;
    return old;
  }

  // 기능:
  // - 배열의 특정 위치에 값을 변경한다. 
  // - 리턴 값: 변경하기 전에 저장되어 있던 값 
  //
  public Object set (int index, Object obj) {
    if (index < 0 || index >= this.size) { //값이 저장된 위치가 무효한 인덱스라면 
      return null;

    }
    Object old =this.list[index]; // 이 위치에 있던 값을 old 에 저장 
    this.list[index] = obj; // 새 값을 그 위치에 저장 
    return old; // 기존 값은 사라지고 옛날 값을 리턴 
  }

  public int size() {
    return this.size;
  }

  public Object get(int index) {
    return this.list[index];
  }
}

