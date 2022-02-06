package com.eomcs.app1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //이거 붙이는게 규칙 
public class CalculateController {

  @RequestMapping("/calc") //클라이언트에서 어떤 요청을 보냈을 때 어떤 요청인지 그 url을 지정 
  // 스프링 부트에서 자동으로 인코딩 디코딩 처리하기 때문에 따로 문장을 명시해줄 필요 없다. 
  // 문자열을 숫자로 처리하는것도 알아서 해주기때문에 명시해줄 필요없다. 
  public String calc(String op, double a, double b) { 
    // 파라미터로 넘겨주는 값이 op, a,b 이기때문에 이렇게 넣어주고 
    // int만 하면 정수만 가능해서 double로 리턴타입을 변경해준다. 
    // 어떤 요청이 들어오면 이 메서드를 호출해라! 
    String response = null;

    switch (op) { // 계산식이 정상이라면 
      case "+": 
        response = String.format("%.2f", a + b); // 결과리턴 
        // 부동소수점이기때문에 d->f 로 변경, 소숫점이하는 두자리까지 표시한다.  
        // String.format 은 println ,printf와 같다. 
        break;
      case "-": 
        response = String.format("%.2f", a - b);
        break;
      case "*": 
        response = String.format("%.2f", a * b);
        break;  
      case "/": 
        response = String.format("%.2f", a / b);
        break;
      default: 
        response = "연산 불가!";
    }
    return response; //최종적으로 결과는 response에 담으니까 response로 처리 
  }
}
