package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BookDao;
import com.eomcs.mylist.domain.Book;

@RestController 
public class BookController {

  @Autowired
  BookDao bookDao;

  @RequestMapping("/book/list")
  public Object list() {
    return bookDao.findAll(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) throws Exception {
    bookDao.insert(book);
    return bookDao.countAll();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    Book book = bookDao.findByNo(index);
    return book != null ? book : "";
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) throws Exception{
    Book old = bookDao.findByNo(index);
    if (old == null) {
      return 0;
    }
    return bookDao.update(index, book);
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) throws Exception {
    Book old = bookDao.findByNo(index);
    if (old == null) {
      return 0;
    }
    return bookDao.delete(index);
  }
}

//  @RequestMapping("/book/save")
//  public Object save() throws Exception {
//    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("books.json")));
//    ObjectMapper mapper = new ObjectMapper();
//    String jsonStr = mapper.writeValueAsString(bookList.toArray()); 
//    out.println(jsonStr);
//    out.close();
//    return bookList.size();
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








