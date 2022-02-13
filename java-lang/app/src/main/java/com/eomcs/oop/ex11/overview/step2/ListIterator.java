package com.eomcs.oop.ex11.overview.step2;

//MyList 컬렉션에서 데이터를 꺼내는 일을 한다. 

public class ListIterator implements Iterator{
  MyList list; // list를 내가 보관하고 있다가 
  int cursor; // 현재 꺼낼 위치, 어디까지 꺼내는지 알려줘야겠지. 

  public ListIterator(MyList list) { // list를 내가 알려줄 때 
    this.list= list;
  }

  @Override
  public boolean hasNext() { 
    // 꺼낼게 있냐고 물어보면 확인해보고 
    // 만약 커서가 현재 리스트의 사이즈보다 작으면 리턴 
    return cursor < list.size();
  }
  
  @Override
    public Object next() { // 꺼내달라고 하면 
      return list.get(cursor++); 
      // 현재 커서가 가리키는걸 꺼내서 리턴하는데 꺼내는데 
      // 현재 커서가 가리키는걸 꺼내고 나서 값은 하나 증가해야한다. 
      // 그래서 후위연산자를 사용 
    }
  }

