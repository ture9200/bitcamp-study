// 포함 관계로 기능 확장하기 - BufferedInputStream, BufferedOutputStream
package com.eomcs.io.ex08;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0120 {

  public static void main(String[] args) throws Exception {

    FileInputStream in = new FileInputStream("temp/jls11.pdf");
    BufferedInputStream in2 = new BufferedInputStream(in); 
    //FileInputStream에 BufferedInputStream연결
    //읽은걸 버퍼에 담았다가 한개씩 리턴 

    FileOutputStream out = new FileOutputStream("temp/jls11.pdf");
    BufferedOutputStream out2 = new BufferedOutputStream(out);
    // FileOutputStream에 BufferedOutputStream연결 
    // 버퍼에 담았다가 꽉차면 한개씩 FileOutputStream 통해서 왕창 출력  
    // 버퍼가 꽉찰때까지 기다림 

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    while ((b = in2.read()) != -1) //BufferedInputStream에서 1바이트 읽어서 
      out2.write(b); //BufferedOutputStream 으로 1바이트 출력 

    // 아직 파일로 출력되지 않고 버퍼 남아 있는 데이터를
    // 마무리로 출력한다.
    out2.flush();

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);

    in2.close();
    out2.close();
  }
}


