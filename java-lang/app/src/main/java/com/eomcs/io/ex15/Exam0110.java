package com.eomcs.io.ex15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;


public class Exam0110 {
  public static void main(String[] args) throws Exception {
   Encoder encoder= Base64.getEncoder();
   
   File file = new File("./temp/윈터3 .jpg");
    FileInputStream in = new FileInputStream(file);
    FileWriter out = new FileWriter("./temp/윈터3 .txt");
    
    byte[] buf = new byte[(int)file.length()];
    int len = in.read(buf);
    //while((len= in.read(buf)) != -1 ) {
      System.out.printf("읽은 바이트 수: %d\n" , len);
      
      // 바이트 배열에 저장된 바이너리 데이터를 텍스트로 변환하기 
    String encodedStr = encoder.encodeToString(Arrays.copyOf(buf, len));
      
      // 텍스트로 변환한 데이터를 파일로 출력하기 
      out.write(encodedStr);
  
    
    in.close();
    out.close();
  }
}
