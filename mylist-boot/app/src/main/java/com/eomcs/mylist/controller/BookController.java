package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController 
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!");

    try {
      BufferedReader in = new BufferedReader(new FileReader("books.json"));

      ObjectMapper mapper = new ObjectMapper();

      //      String jsonStr = in.readLine();
      //      Book[] books = mapper.readValue(jsonStr, Book[].class);
      //      bookList = new ArrayList(books);
      bookList= new ArrayList(mapper.readValue(in.readLine(), Book[].class));

      in. close();

    }catch (Exception e) {
      System.out.println("독서록 데이터 로딩중 오류발생!");  
    }
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("books.json")));
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr = mapper.writeValueAsString(bookList.toArray()); 
    out.println(jsonStr);
    out.close();
    return bookList.size();
    //    Object[] arr = bookList.toArray();
    //    for (Object obj : arr) {
    //      Book book = (Book) obj;
    //      out.writeUTF(book.getAuthor());
    //      out.writeInt(book.getPage());
    //      out.writeUTF(book.getPress());
    //      out.writeInt(book.getPrice());
    //out.writeUTF(book.getReadDate().toString());
    //      if(book.getReadDate() == null) {
    //        out.writeUTF("");
    //      } else { 
    //        out.writeUTF(book.getReadDate().toString());
    //      }
    //      out.writeUTF(book.getReview());
    //      out.writeUTF(book.getTitle());
    //    }
  }
}







