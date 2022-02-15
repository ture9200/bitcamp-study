// local class에서 바깥 메서드의 로컬 변수 접근
// 자바스크립트의 closer 와 유사하다. 
// 바깥쪽 함수의 로컬 변수가 사라지기 전에 클로저 메모리에 따로 백업해둔다고 한 거랑 똑같다. 

package com.eomcs.oop.ex11.d;

// 계산기 사용법을 정의한다. 
interface Calculator { // 계산기주면 이자 계산 
  double compute(int money);
}

class CalculatorFactory{
   static Calculator create(float interest) {
    class CalculatorImpl implements Calculator {
      // 바깥메서드의 로컬변수를 사용하기 때문에 
      // 로컬변수 값을 잃어버리지 않기 위해서 보관할 변수를 준비 
//      float interestClone;
//      
//      public CalculatorImpl(float args0) {
//        this.interestClone = args0;
//      }
      
     @Override
    public double compute(int money) {
      return money +(money * interest);
      // public CalculatorImpl(float f) {return money + (money * interestClone);}
      // }return new CalculatorImpl(interestClone);} } 
      // interest는 create()함수의 로컬 변수이다. 
      // CalculatorImpl 객체를 생성하여 리턴한 후에는 interest 로컬 변수는 스택에서 사라진 상태일 것이다. 
      // 나중에 compute()를 호출할 떄 interest 변수는 없을텐데, 어떻게 된 것인가? 
      // => 로컬 클래스에서 메서드의 로컬 변수를 사용한다면 
      //    컴파일러는 로컬 클래스에 바깥 메서드의 로컬 변수 값을 저장할 필드를 추가한다. 
      //    또한 로컬 클래스의 객체를 생성할 때 생성자에 로컬 변수의 값을 넘겨 줄 것이다. 
      //    컴파일러가 알아서 한다. 
       
    }
}
    // 이 객체를 만들 때 메서드의 로컬변수 값 interest 을 잃어버리지 않기 위해서 넘겨준다. 
    // 나중에 compute를 호출하더라도 그대로 사용할 수 있다. 
   return new CalculatorImpl();
   }
}

public class Exam0310 {
  public static void main(String[] args) {
    Calculator c1 =CalculatorFactory.create(0.02f);
    Calculator c2 =CalculatorFactory.create(0.08f);
    
    System.out.printf("%.2f\n",c1.compute(1235_0000));
    System.out.printf("%.2f\n",c2.compute(1235_0000));
  }
}
