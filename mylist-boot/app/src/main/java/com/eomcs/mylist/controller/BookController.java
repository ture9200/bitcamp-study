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
    //Calendar calendar =Calendar.getInstance();
    //현재 시간을 일반 시간이 아닌 요일, 오전/오후 등인 달력 기준으로 표기해주는 방식이다.  
    //board.setCreatedDate(new Date(System.currentTimeMillis()));
    //함수를 사용해서 현재 시간을 받아오고 board 에 날짜를 설정하라는 뜻. 

    bookList.add(book);
    return bookList;
  }



  @RequestMapping("/book/get")
  public Object get(int index) {
    if(index < 0 || index >= bookList.size()) {
      return "";
    }
    Book book = (Book)bookList.get(index);
    // board 리스트 항목을 Book로 형변환해서 book에 저장한다. 
    //book.setViewCount(book.getViewCount()+1);
    // board의 조회수를 하나씩 늘린다. 
    return book;
    // 그렇게 해서 ArrayList의 항목을 리턴한다. 
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if(index < 0 || index >= bookList.size()) {
      return 0;
    }
    Book old = (Book)bookList.get(index);
    // boardlist 항목들을 Board로 형변환해서 old에 저장한다. 
    //book.setViewCount( old.getViewCount());
    // 기존조회수를 viewCount에 담고 
    book.setReadDate(old.getReadDate()); 
    // 기존 날짜도 게시글 날짜에 저장이 된다. 

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


