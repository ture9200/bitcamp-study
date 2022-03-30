package com.eomcs.mylist.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
//@NoArgsConstructor(force = true) //기본생성자를 무조건 만들게 한다. 
//@RequiredArgsConstructor //final이 붙은 필드의 값을 파라미터로 받는 생성자를 만들게 한다. 
public class ResultMap {
  public static final String SUCCESS="success"; 
  public static final String FAIL="fail"; 
  
  private String status;
  private Object data;
}
