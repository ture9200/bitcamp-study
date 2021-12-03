//리터럴 = 값을 표현한 것,숫자를 표현하는 다양한 방- 산수법  

package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam2")
public class Exam2 {


  @GetMapping("/test1")
  public int test1() {return 100;}  //10진수 ,100
  //( 숫자를 표현할 때 기본으로 많이 사용) 


  @GetMapping("/test2")
  public int test2() {return 0144;}   //8진수 ,100
  //8진수는 앞에 0을 붙인다. 

  @GetMapping("/test3")
  public int test3() {return 0b110_0100;}//2진수 binary,100 
  //0b0110_0100이랑 값이 같다. 
  //2진수는 앞에 0b를 붙인다. 

  @GetMapping("/test4")
  public int test4() {return 0x64;}  //16진수 ,100
  // 문자의 코드 값을 표현할 때 많이 사용)  
}
