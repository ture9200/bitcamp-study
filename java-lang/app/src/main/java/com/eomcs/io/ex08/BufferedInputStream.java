package com.eomcs.io.ex08;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream {
  InputStream in; // 추상클래스라서 모든 서브클래스 객체를 가리키는것이 포함된다. 

  byte[] buf = new byte[8192];
  int size; // 배열에 저장되어 있는 바이트의 수
  int cursor; // 바이트 읽은 배열의 위치

  public BufferedInputStream(InputStream in) {// 생성자에서 InputStream을 받는다.
    this.in = in;
  }

  public int read() throws IOException { // 1바이트를 읽어줘 
    if (cursor == size) { // 버퍼에 저장되어 있는 데이터를 모두 읽었다는 의미
      if ((size = in.read(buf)) == -1) { // 파일에서 데이터를 읽으려 했는데 데이터가 없으면.
        return -1;
      }
      cursor = 0;
    }
    return buf[cursor++] & 0x000000ff; //버퍼에 보관된 데이터를 리턴
  }

  public int read(byte[] buf) throws IOException {
    int i = 0;
    for (; i < buf.length; i++) {
      // 1바이트를 읽어서 파라미터로 받은 바이트 배열에 채운다.
      int b = this.read();
      if (b == -1) {
        // 바이트 배열을 다 채우기도 전에 읽을 데이터가 없다면 읽기를 멈춘다.
        break;
      }
      buf[i] = (byte) b;
    }
    return i; // 지금까지 읽은 데이터의 수를 리턴한다.
  }

  public void close() throws IOException {
    in.close();
  }
}


