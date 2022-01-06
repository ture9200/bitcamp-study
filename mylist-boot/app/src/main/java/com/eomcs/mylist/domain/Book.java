package com.eomcs.mylist.domain;

import java.sql.Date;

public class Book {
  String title;
  String author;
  String press;
  int page;
  int price;
  Date readDate;
  String review;
  //int viewCount;

  public Book() {
    System.out.println("Book() 호출됨!");
  } 

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Date getReadDate() {
    return readDate;
  }

  public void setReadDate(Date readDate) {
    this.readDate = readDate;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  //  public int getViewCount() {
  //    // TODO Auto-generated method stub
  //    return viewCount;
  //  }
  //
  //  public void setViewCount(int viewCount) {
  //    this.viewCount = viewCount;
  //  }

  @Override
  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", press=" + press + ", page=" + page
        + ", price=" + price + ", readDate=" + readDate + ", review=" + review + "]";
  }
}
