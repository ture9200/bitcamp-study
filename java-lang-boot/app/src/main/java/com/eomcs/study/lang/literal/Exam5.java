//리터럴 = 문자 리터럴 
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam5")
public class Exam5 {

  @GetMapping("/test1")
  public String test1() {
    return "문자1:"+'A'+ '가';} //문자1:A가

  @GetMapping("/test2")
  public String test2() {
    return "문자2:"+'\u0041'+ '\uac00'; //문자2:A가
    //문자에 대한 유니코드 값을 지정해도 된다. 
    //char 은 \u0000~\uffff  자바의 정석 참고!! 
  }
  @GetMapping("/test3")
  public String test3() {
    return "문자2:"+(char)0x41+ ","+(char)0xac00; //문자2:A,가
  }
  //문자의 코드 값은 그냥 정수 값으로 지정한다. 
  //대신 문자를 가리키는 코드임을 표시해야한다. 
  //0x로 시작하는것은(16진수) , 윈도우 계산기 사용하면 그 결과가 나옴 

  @GetMapping("/test4")
  public String test4() {
    return "문자2:"+(char)65+ ","+(char)44032;  //문자2:A,가
    //문자의 코드 값은 그냥 정수 값이다. 
    //대신 문자를 가리키는 코드임을 표시해야한다. 
    //앞에 char 이 붙은것은 문자열로 형변환!! 
  }

  @GetMapping("/test5")
  public String test5() {
    return "문자2:"+'\u4eba'+'\u00a9'+'\u03c0'+'\u03a3';
    //키보드에서 입력불가능한 특수문자를 가리킬때 주로 유니코드를 사용한다. 

  }


}