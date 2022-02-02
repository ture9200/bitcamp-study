package com.eomcs.openapi.json.test;

public class Phone {

  String name; // 폰이름
  String maker; //제조사 

  //오른쪽 클릭후 source > Generator Getter and Setter >Select All > Generate  클릭 
  //오른쪽 클릭후 generate > toString 오버라이드 
  //인스턴스 필드를 문자열로 출력하기위해 toString 오버라이드 
  @Override
  public String toString() {
    return "Phone [name=" + name + ", maker=" + maker + "]";
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
}
