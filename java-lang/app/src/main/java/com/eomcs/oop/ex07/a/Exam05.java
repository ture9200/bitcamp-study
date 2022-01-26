// 추상 클래스와 추상 메서드의 활용
package com.eomcs.oop.ex07.a;

abstract class Letter {

  // 수퍼 클래스는 서브 클래스에게 구현된 멤버를 상속해준다.
  String content;

  public void setContent(String content) {
    this.content = content;
  }

  // 수퍼 클래스에서 기능이 어떻게 동작하는지 정의한다.
  // => 템플릿의 역할을 하는 메서드를 수퍼 클래스에 둔다.
  // => 자세한 구현은 서브 클래스에 맡긴다.
  public void print() { // <== 템플릿 메서드 디자인 패턴에서 "템플릿 메서드"에 해당한다. 
    this.printHeader(); // 실무에는 this를 안붙인다. printHeader();  
    // 추상클래스는 인스턴스 생성 불가이기때문에 추상메서드를 구현한 서브클래스의 주소가 this에 넘어간다.
    // 메서드를 호출할 때는 주소없이 호출할 수 없다. 앞에 클래스 이름(static), 인스턴스 주소(instance) 둘 중에 하나가 반드시 와야한다. 
    // 혹시라도 앞에 아무것도 없다고 하면 this(인스턴스 메서드)가 생략되었거나 클래스명(static 메서드)이 생략된 거다. 
    // 컴파일 할때 자동으로 this가 붙는다. 
    // 로컬변수는 앞에 아무것도 안붙는다. 
    System.out.println(this.content);
    System.out.println();
    System.out.printf("              From %s!\n", this.getSign());
    System.out.println();
    this.printFooter();
  }

  // 세부 사항에 대한 것은
  // 서브 클래스에게 구현을 맡긴다.
  public abstract void printHeader();
  public abstract void printFooter();
  public abstract String getSign();
}

// 상세한 기능에 대한 구현은 다음과 같이 서브 클래스에게 맡긴다.
class LoveLetter extends Letter {

  @Override
  public void printHeader() {
    System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥ [사랑을 그대에게] ♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
  }

  @Override
  public String getSign() {
    return "당신의 영원한 팔로워, 홍길동";
  }

  @Override
  public void printFooter() {
    System.out.println("♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪♪");

  }
}

class ReportLetter extends Letter {
  @Override
  public void printHeader() {
    System.out.println("[비트캠프 강의 보고서]");
  }

  @Override
  public String getSign() {
    return "강사 홍길동";
  }

  @Override
  public void printFooter() {
    System.out.println("==========================================");

  }
}

public class Exam05 {
  public static void main(String[] args) {
    Letter letter = new LoveLetter(); // 추상클래스의 서브클래스 객체주소가 letter자리에 올 수 있다. 
    // jvm의 입장: 인스턴스 주소를 만들었고 주소를 담았다. 
    letter.setContent("눈이 녹으면 무엇이 될까요?\n"  
        + "봄이 온다 합니다.\n"
        + "따뜻한 봄이 기다려지네요.");
    //letter는 loveletter의 인스턴스가 들어있다. loveletter에 없으니 수퍼클래스 따라 올라가서 찾는다. 
    letter.print(); // 수퍼클래스에 정의된 print 메서드 호출 

    Letter letter2 = new ReportLetter(); // 서브클래스의 객체를 담을 수 있다. 
    letter2.setContent("강의중!"); // ReportLetter에는 setContent가 없다. 그래서 수퍼클래스로 따라 올라가서 찾는다. 
    letter2.print();
  }
}
