package com.eomcs.lang.ex04;

//# 값 저장과 메모리 크기 - 작은 크기의 메모리 값을 큰 크기의 메모리에 저장할 수 있다. 

public class Exam0910 {
  public static void main(String[] args) {
    byte b = 100;  //1 byte
    short v1 = b; //1 byte => 2 byte 

    short s = 100; //2 byte (-32768~32767)
    int v2=s; //2 byte => 4 byte

    int i = 98765678; //4 byte
    long v3 =i; //4 byte => 8byte 

    long l = 98765678; //8 byte

    char c = 100; //2 byte (0~65535)
    //short x1=c; //char(0~65535) => short( -32768~32767) , 값의 범위가 맞지 않아 컴파일 오류! 
  }
}

