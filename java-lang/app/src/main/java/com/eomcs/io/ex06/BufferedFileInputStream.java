package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedFileInputStream extends FileInputStream {

  byte[] buf = new byte[8192];
  int size; // 배열에 저장되어 있는 바이트의 수
  int cursor; // 바이트 읽은 배열의 위치

  public BufferedFileInputStream(String filename) throws Exception {
    super(filename);
  }

  // 파일에서 버퍼로 왕창 읽어온 횟수 
  int readCount = 0;

  // 버퍼를 사용하는 서브 클래스의 특징에 맞춰서 
  // 상속받은 메서드를 재정의한다. 
  @Override
  public int read() throws IOException { // 1바이트 읽어줘 
    if (cursor == size) { // 8192바이트(=size) , 버퍼(바이트 배열)에 저장되어 있는 데이터를 모두 읽었다면,
      if ((size = super.read(buf)) == -1) { 
        // 다시 파일에서 바이트 배열로 데이터를 왕창 읽어 온다. 
        // -1은 데이터를 읽으려 했는데 데이터가 없다. 더 이상 읽을게 없다.
        // size => read(buf))실제 버퍼에 읽은 개수 , 커서 => 앞으로 읽을 바이트의 인덱스  
        return -1;
      }
      readCount++; //버퍼에서 읽어올 때마다 카운트를 증가한다. 
      System.out.printf("==> 버퍼로 왕창 읽었음! -%d번째\n", readCount); //읽은
      cursor = 0;
    }
    return buf[cursor++] & 0x000000ff; 
    //커서에 들어있는 값을 리턴 임시변수 저장하고 커서는 하나 증가시키고 임시변수에 저장한것을 리턴
    // 뒤에 0x000000ff는 왜 붙이는건지? 

    // 위의 리턴 문장은 컴파일 할 때 아래의 문장으로 바뀐다. 
    /*
    int temp; //int 임시변수를 만들고 
    temp = buf[cursor]; //커서가 가리키는 버퍼의 값을 임시변수에 담는다.
    cursor++; // 커서를 증가시킨다.
    return temp & 0x000000ff; // temp & 0x000000ff 결과를 리턴한다
     */

  }
}


