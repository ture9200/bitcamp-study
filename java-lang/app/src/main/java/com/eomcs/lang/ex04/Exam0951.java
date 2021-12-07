package com.eomcs.lang.ex04;

//# 형변환 - 명시적 형변환이 불가능한 경우, 특별한 메서드를 사용하면 가능하다. 
// 
public class Exam0951 {
  public static void main(String[] args) {

    byte b= Byte.valueOf("100"); //문자열 ==>Byte
    short s= Short.valueOf("32767"); //문자열 ==> short
    int i1=Integer.valueOf("2122223333"); // 문자열 ==> int
    int i2= Integer.parseInt("2122223333");
    long l=Long.valueOf("9221111222233334444"); //문자열 ==>long
    float f1= Float.valueOf("3.14f"); // 문자열 ==>Float 
    float f2=Float.parseFloat("3.14f"); 
    double d= Double.valueOf("9876.54321"); //문자열 ==> Double 
    boolean bool1=Boolean.valueOf("TRUE"); //문자열 ==> boolean
    boolean bool2=Boolean.parseBoolean("TRUE"); 
    char c = "가".charAt(0); //문자열 ==> char
    //String으로 저장된 문자열 중에서 한 글자만 선택해서
    //char타입으로 변환해준다. 
    //문자열에서 0번째에 있는 문자를 char타입으로 변환한다


    System.out.println(b);
    System.out.println(s);
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(l);
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(d);
    System.out.println(bool1);
    System.out.println(bool2);
    System.out.println(c);
  }
}
