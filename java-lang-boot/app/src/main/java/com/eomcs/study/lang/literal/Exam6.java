//리터럴 = 문자 리터럴 
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam6")
public class Exam6 {
  @GetMapping("/test1")
  public String test1() {
    return "012AB가각간똘똠똡똥"; //012AB가각간똘똠똡똥
  }

  // 제어코드
  //  \f - Form Feed, 0x0c
  //  \' - Single Quote, 0x27
  //  \" - Double Quote, 0x22

  @GetMapping("/test2")
  public String test2() {
    //제어코드
    //  \n - Line Feed(LF), 0x0a ,개행문자 엔터기능 ,줄바꿈
    return "012\nABC\n가각간\n똘똠똡똥"; //012 ABC 가각간 똘똠똡똥
  }

  @GetMapping("/test3")
  public String test3() {
    //제어코드
    //  \r - Carrage Return(CR), 0x0d ,처음으로 돌아가기 
    //그 라인의 맨 앞으로 가서 뒤에 글자들을 덮어서 출력한다
    return "012\rABC\r가각간\r똘똠똡똥"; //012 ABC 가각간 똘똠똡똥
    //웹브라우저에서 소용없다. 
  }

  @GetMapping("/test4")
  public String test4() {
    //제어코드
    //  \t - Tab, 0x09 ,탭공간 추가
    return "012\tABC\t가각간\t똘똠똡똥"; //012 ABC 가각간 똘똠똡똥
  }

  @GetMapping("/test5")
  public String test5() {
    //제어코드
    //   \b - Backspace, 0x08 ,한칸뒤로가기 
    //백스페이스 누른 것처럼 \b 숫자만큼 앞으로 간다
    return "012\bABC\b가각간\b똘똠똡똥";
    //웹브라우저에서 소용없다. 
  }

  @GetMapping("/test6")
  public String test6() {
    //제어코드
    //  \\ - Backslash, 0x5c
    return "012\\ABC\\가각간\\똘똠똡똥"; 
    //웹브라우저에서 소용없다. 
  }
}