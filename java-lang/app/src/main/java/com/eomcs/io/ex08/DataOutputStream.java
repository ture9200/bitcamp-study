package com.eomcs.io.ex08;

import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStream {

  OutputStream out;  //FileOutputStream, ByteArrayOutputStream 포함된다. 

  public DataOutputStream(OutputStream out) throws Exception {
    this.out = out;
  }

  public void write(int b) throws IOException { //int값줄테니 출력해 
    out.write(b);
  }

  public void writeUTF(String str) throws Exception { //String 줄테니 출력해 
    byte[] bytes = str.getBytes("UTF-8"); //String에서 바이트배열 뽑아내서 
    out.write(bytes.length); //바이트 배열 개수 출력 
    out.write(bytes); //바이트 배열 출력 
    // 직접 출력하는게 아니라 생성자에 받아놓은 OutputStream 에게 위임한다. 
  }

  public void writeInt(int value) throws Exception {
    out.write(value >> 24);
    out.write(value >> 16);
    out.write(value >> 8);
    out.write(value);
  }

  public void writeLong(long value) throws Exception {
    out.write((int)(value >> 56));
    out.write((int)(value >> 48));
    out.write((int)(value >> 40));
    out.write((int)(value >> 32));
    out.write((int)(value >> 24));
    out.write((int)(value >> 16));
    out.write((int)(value >> 8));
    out.write((int)value);
  }

  public void writeBoolean(boolean value) throws Exception {
    if (value)
      out.write(1);
    else
      out.write(0);
  }

  public void close() throws IOException {
    out.close();
  }
}





