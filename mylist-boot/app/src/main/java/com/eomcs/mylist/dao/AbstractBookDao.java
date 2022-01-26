package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

//서브클래스의 공통분모를 추출하여 수퍼클래스를 정의할 경우, 
// - 보통 이런 수퍼클래스는 직접 사용하려고 만든 클래스가 아니다. 
// - 단지 서브클래스에게 공통분모를 물려주려고 만든 클래스이다. 
// - 이런 경우 "추상클래스"로 선언한다. 
// - 또한 추상 클래스 만이 추상 메서드를 가질 수 있기 때문에 
//   추상 메서드가 있는 클래스는 방드시 추상 클래스로 선언해야 한다. 
public abstract class AbstractBookDao implements BookDao {

  // 서브 클래스에서 접근해야 할 필드라면, 접근범위를 protected로 설정한다. 
  protected ArrayList bookList = new ArrayList();

  protected abstract void save() throws Exception;

  @Override
  public int countAll() {
    return bookList.size();
  }

  @Override
  public Object[] findAll() {
    return bookList.toArray();
  }

  @Override
  public void insert(Book book) throws Exception {
    bookList.add(book);
    save();
  }

  @Override
  public Book findByNo(int no) {
    if (no < 0 || no >= bookList.size()) {
      return null;
    }
    return (Book) bookList.get(no);
  }

  @Override
  public int update(int no, Book book) throws Exception {
    if (no < 0 || no >= bookList.size()) {
      return 0;
    }
    bookList.set(no, book);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= bookList.size()) {
      return 0;
    }
    bookList.remove(no);
    save();
    return 1;
  }

}

