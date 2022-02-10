package com.eomcs.oop.ex11.overview.step5;

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
    return new ListIterator();
  }

  // non-static nested class(논스태틱 중첩 클래스)
  // - inner class 라고도 부른다. 
  // - ListIterator가 사용할 바깥 클래스 MyList의 인스턴스 주소를 저장할 필드와 생성자가 자동으로 추가된다. 
  // - 기존의 static nested class 처럼 개발자가 직접 추가할 필요가 없다. 
  // - 바깥 클래스의 인스턴스를 사용하는 경우, static nested class로 만드는 것 보다 더 편리하다. 
  // 이 개념을 이해할 때는 navigator에 따라 클래스 정보를 봐야한다. 
  //
   class ListIterator implements Iterator {

    int cursor;
    //MyList this$0;
    
    // public ListIterator(MyList arg0) {
    // this.this$0 =arg0;


    @Override
    public boolean hasNext() {
      return cursor < MyList.this.size(); // 서버를 경유해서 이루어짐 
      // 문법으로 정해짐, navigator, 생성자 호출할때 mylist주소를 받게 되있음
      // 기본생성자가 만들어지는게 아니라 바깥 객체 주소를 받는 기본 생성자
      // 이 코드를 컴파일할 때 non-static이니까 원래 MyListIterator 에는 cursor라는 변수는 있지만 this$0라는 변수는 없다.
      // 컴파일러가 여기에 MyList$0 라는 변수를 만든거 
      // 생성자가 없을떄  컴파일러는 기본생성자를 만든다. 기본 생성자는 파라미터가 없는건데 
      // 컴파일러가 논스태틱 중첩클래스를 만들때는 MyList 바깥클래스 객체주소를 파라미터로 받는 
      // MyList args0라는 파라미터를 받는 생성자를 만들고 this.this$0 = args0; 를 넣는다. 
      // 바깥클래스 인스턴스 주소가 밖에 담겨있으니 MyList. this$0 에 있는 this$0으로 싹 바뀐다. 
      // MyList.this.size() -> this$0.size 
      // ListIterator에서 바깥객체주소를 받게 되있고 그 바깥 객체 주소로 받은 변수로 바뀌도록 약속되있다. 
      // hasnext() 보면 this$0 니까 this에 this$0 가 들어가있고 this$0. size()를 호출하게 되어있다 
      // 바깥 클래스의 인스턴스 주소를 가리키기 위해서 바깥클래스명.this.name 
      // 그냥 this라고 하면 ListIterator 객체를 가리킨다. 
      // 컴파일하게되면 바깥클래스의 객체주소를 담는 생성자고 바뀌니까 return new ListIterator(this);로 바뀐다. 
      // MyList에 iterator라는 메서드 호출을 딱 보면 this를 넘겨주는데 
      // 바로 ListIterator()라는 생성자를 호출하게되고 바깥클래스 객체주소를 파라미터로 넘겨준다. 
      // 직접 작성할거냐 아니면 자동으로 작성하게 할거냐의 문제다. 
      // ListIterator 객체가 생성자를 통해서 받은 바깥클래스 객체 주소를 가리킬때는 MyList.this.size() 로 해야한다.
      // 자동이라는 개념이 없다. 컴파일할때 그렇게 코드를 바꾼것이다. 
      // 생략하는 조건이 있는데 여기에 public int size() {return 0;}  가 있고 MyList.this 생략하게되면 현재 클래스에서 사이즈를 찾는다. 
      // 하지만 우리는 바깥 클래스의 사이즈를 원하니까 그럴경우 생략하면 안된다. 그래서 MyList.this.size 하게 된다. 
      // 현재클래스에 public int size() {return 0;} 이게 없으면 헷갈릴이유가 없으니 생략하면 안된다. 
      // 밑에 MyList.this.get에서 MyList.this도 생략할 수 있다. 없으면 자동으로 MyList.size(), MyList.get()이 된다. 
      // 생략하면 자동으로 컴파일러가 붙인다. 없이 호출할 수 없다. 
      
      
    }

    @Override
    public Object next() {
      return MyList.this.get(cursor++);
    }
  }

}


