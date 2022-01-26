package com.eomcs.mylist.dao;


import com.eomcs.mylist.domain.Board;


public interface BoardDao {
  // 인터페이스는 객체의 메서드 호출 규칙을 정의하는 것이기 때문에 
  // 메서드를 작성할 때 메서드 몸체(method body)를 작성하지 말아야한다. 
  // 메서드 바디가 없는 메서드를 "추상 메서드(abstract method)"라 부른다. 

  int countAll();

  Object[] findAll();

  void insert(Board board) throws Exception;


  Board findByNo(int no);


  int update(int no, Board board) throws Exception;

  int delete(int no) throws Exception; 

  void increaseViewCount(int no) throws Exception;

  // save는 바깥에서 호출하는 메서드가 아니다. 
  // 내부적으로 사용되는 메서드라서 지워진다. 
  // 인터페이스에 선언된 모든 메서드들은 기본이 public이다. 
  // 안적어도 public, public이 생략된것이다. default 아니다.  
  //Save는 사용규칙이 아니다. 외부에 노출되는 사용규칙이 인터페이스다. 
  // 그래서 기본이 public이다. 
  // Private 이나 Protected으로 만들려면? => 방법이 없다. 안된다. 

}