package com.eomcs.io.ex15;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Exam0120 {
  public static void main(String[] args) throws Exception {
   Decoder decoder= Base64.getDecoder();
   
    FileReader in = new FileReader("./temp/윈터3 .txt");
    FileOutputStream out = new FileOutputStream("./temp/윈터x .jpg");
    char[] buf = new char[10000000];
    int len = in. read(buf);
   // while((len= in.read(buf)) != -1 ) {
      System.out.printf("읽은 문자 수: %d\n" , len);
      
      // 문자 배열에 저장된 Base64 데이터를 텍스트로 변환하기 
     
    byte[] decodedBytes = decoder.decode(String.valueOf(buf, 0, len));
      
      // 텍스트로 변환한 데이터를 파일로 출력하기 
      out.write(decodedBytes);
    
    
    in.close();
    out.close();
  }
}
