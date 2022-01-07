package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController
public class BookController {
  ArrayList bookList= new ArrayList();

  public BookController() {
    System.out.println("Bookcontroller() 호출됨!");
  }

  @RequestMapping("/book/list")
  public Object list() { //클라이언트 요청을 처리한다. 
    return bookList.toArray(); // 배열을 다룬다. 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    book.setReadDate(new Date(System.currentTimeMillis()));   
    bookList.add(book);
    return bookList;
  }



  @RequestMapping("/book/get")
  public Object get(int index) {
    if(index < 0 || index >= bookList.size()) {
      return "";
    }
    Book book = (Book)bookList.get(index);
    return book; 
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if(index < 0 || index >= bookList.size()) {
      return 0;
    }
    Book old = (Book)bookList.get(index);
    book.setReadDate(old.getReadDate()); 
    return bookList.set(index, book) == null ? 0 :1; //한번 더 거르겠다는 말!! 
  }


  @RequestMapping("/book/delete")
  public Object delete(Book book, int index) {
    if(index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0:1;  // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
  }
}


