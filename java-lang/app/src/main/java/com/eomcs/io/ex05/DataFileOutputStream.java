package com.eomcs.io.ex05;

import java.io.FileOutputStream;

public class DataFileOutputStream extends FileOutputStream {

  public DataFileOutputStream(String filename) throws Exception { //생성자에 filename넘어오면 
    super(filename); // 수퍼클래스 생성자에 넘긴다. 
  }

  public void writeUTF(String str) throws Exception {
    // 상속 받은 write() 메서드를 사용하여 문자열 출력  
    byte[] bytes = str.getBytes("UTF-8"); // writeUTF를 주면 UTF-8 바이트로 뽑아낸다.  
    this.write(bytes.length); // 바이트 개수 1바이트로 출력 ob = 11 byte 항상 몇개인지 알려줘야한다.
    //이 문장없이 출력하면 몇바이트부터 몇바이트까지가 문자열인지 모른다. 앞부분에 알려줘야한다. 
    this.write(bytes); // 바이트 출력 
  }

  public void writeInt(int value) throws Exception {
    // 상속 받은 write() 메서드를 사용하여 int 값 출력
    // writeInt에 int값 주면 내부적으로 상속받은 write 메서드를 네번 호출해서 int값 출력 
    this.write(value >> 24);
    this.write(value >> 16);
    this.write(value >> 8);
    this.write(value);
  }

  public void writeLong(long value) throws Exception {
    // 상속 받은 write() 메서드를 사용하여 long 값 출력
    // long값 받아서 8번의 write()를 호출해서 출력
    this.write((int)(value >> 56));
    this.write((int)(value >> 48));
    this.write((int)(value >> 40));
    this.write((int)(value >> 32));
    this.write((int)(value >> 24));
    this.write((int)(value >> 16));
    this.write((int)(value >> 8));
    this.write((int)value);
  }

  public void writeBoolean(boolean value) throws Exception {
    // 상속 받은 write() 메서드를 사용하여 boolean 값 출력
    // true, false에 따라서 true면 1 , false면 0  1바이트 값을 출력
    if (value) 
      this.write(1);
    else 
      this.write(0);
  }
}





