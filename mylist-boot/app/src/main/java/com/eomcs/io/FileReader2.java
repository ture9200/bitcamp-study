package com.eomcs.io;

import java.io.FileReader;

//기존 코드를 자신의 코드인양 사용하기 위해 해당클래스를 포함한다. 
public class FileReader2  {

  //기존의 클래스 포함! 
  FileReader in;

  public FileReader2(String filename)throws Exception{
    //기존 객체를 준비한다. 
    in = new FileReader(filename);
  }

  public String readLine() throws Exception {
    StringBuilder buf = new StringBuilder();
    int c;

    while ((c = in.read()) != -1) {
      if (c == '\n') { 
        return buf.toString();
      } else if(c == '\r') { 
        //무시! CR(Carriage Return; \r) 코드는 버퍼에 담지 말고 버린다.  
      } else { 
        buf.append((char) c);
      }
    }
    return buf.toString();
  }

  // 자원해제라는 요청이 들어오면 실제 일을 하는 객체에게 전달한다. 
  public void close() throws Exception {
    in.close();
  }
}

