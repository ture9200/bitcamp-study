package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.eomcs.mylist.domain.Book;
import com.eomcs.mylist.service.BookService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@RestController 
public class BookController {

  private static final Logger log = LoggerFactory.getLogger(BookController.class);

  @Autowired
  BookService bookService;

  @RequestMapping("/book/list")
  public Object list() {
    return new ResultMap().setStatus(SUCCESS).setData(bookService.list());
  }

  @RequestMapping("/book/add")
  public Object add(Book book, MultipartFile file) {
    try {
      book.setPhoto(saveFile(file));
      bookService.add(book);
      return new ResultMap().setStatus(SUCCESS);

    } catch (Exception e) {
      StringWriter out = new StringWriter();
      e.printStackTrace(new PrintWriter(out));
      log.error(out.toString());

      return new ResultMap().setStatus(FAIL);
    }
  }


  @RequestMapping("/book/get")
  public Object get(int no) {
    Book book = bookService.get(no);
    if (book == null) {
      return new ResultMap().setStatus(FAIL).setData("�빐�떦 踰덊샇�쓽 �룆�꽌濡앹씠 �뾾�뒿�땲�떎.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(book);
  }

  @RequestMapping("/book/update")
  public Object update(Book book, MultipartFile file) {
    try {
      book.setPhoto(saveFile(file));
      int count = bookService.update(book);

      if (count == 1) {
        return new ResultMap().setStatus(SUCCESS);
      } else {
        return new ResultMap().setStatus(FAIL).setData("�룆�꽌濡� 踰덊샇媛� �쑀�슚�븯吏� �븡嫄곕굹 �룆�꽌濡� �옉�꽦�옄媛� �븘�떃�땲�떎.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultMap().setStatus(FAIL).setData(e.getMessage());
    }
  }

  @RequestMapping("/book/delete")
  public Object delete(int no) {
    int count = bookService.delete(no);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("�룆�꽌濡� 踰덊샇媛� �쑀�슚�븯吏� �븡嫄곕굹 �룆�꽌濡� �옉�꽦�옄媛� �븘�떃�땲�떎.");
    }
  }

  @RequestMapping("/book/photo")
  public ResponseEntity<Resource> photo(String filename) {

    try {
      // �떎�슫濡쒕뱶�븷 �뙆�씪�쓽 �엯�젰 �뒪�듃由� �옄�썝�쓣 以�鍮꾪븳�떎.
      File downloadFile = new File("./upload/book/" + filename); // �떎�슫濡쒕뱶 �긽�� 寃쎈줈 以�鍮�
      FileInputStream fileIn = new FileInputStream(downloadFile.getCanonicalPath()); // �떎�슫濡쒕뱶 �뙆�씪�쓽 �떎�젣 寃쎈줈瑜� 吏��젙�븯�뿬 �엯�젰 �뒪�듃由� 以�鍮�
      InputStreamResource resource = new InputStreamResource(fileIn); // �엯�젰 �뒪�듃由쇱쓣 �엯�젰 �옄�썝�쑝濡� �룷�옣

      // HTTP �쓳�떟 �뿤�뜑瑜� 以�鍮꾪븳�떎.
      HttpHeaders header = new HttpHeaders();
      header.add("Cache-Control", "no-cache, no-store, must-revalidate");
      header.add("Pragma", "no-cache");
      header.add("Expires", "0");

      // �떎�슫濡쒕뱶 �뙆�씪紐낆쓣 吏��젙�븯怨� �떢�떎硫� �떎�쓬�쓽 �쓳�떟 �뿤�뜑瑜� 異붽��븯�씪!
      // => �떎�슫濡쒕뱶 �뙆�씪�쓣 吏��젙�븯吏� �븡�쑝硫� �슂泥� URL�씠 �뙆�씪紐낆쑝濡� �궗�슜�맂�떎.
      header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);



      //      // HTTP �쓳�떟 �깮�꽦湲곕�� �궗�슜�븯�뿬 �떎�슫濡쒕뱶 �뙆�씪�쓽 �쓳�떟 �뜲�씠�꽣瑜� 以�鍮꾪븳�떎.
      //      BodyBuilder http�쓳�떟�깮�꽦湲� = ResponseEntity.ok(); // �슂泥� 泥섎━�뿉 �꽦怨듯뻽�떎�뒗 �쓳�떟 �깮�꽦湲곕�� 以�鍮꾪븳�떎.
      //      http�쓳�떟�깮�꽦湲�.headers(header); // HTTP �쓳�떟 �뿤�뜑瑜� �꽕�젙�븳�떎.
      //      http�쓳�떟�깮�꽦湲�.contentLength(downloadFile.length()); // �쓳�떟 肄섑뀗�듃�쓽 �뙆�씪 �겕湲곕�� �꽕�젙�븳�떎.
      //      http�쓳�떟�깮�꽦湲�.contentType(MediaType.APPLICATION_OCTET_STREAM); // �쓳�떟 �뜲�씠�꽣�쓽 MIME ���엯�쓣 �꽕�젙�븳�떎.
      //      
      //      // �쓳�떟 �뜲�씠�꽣瑜� �룷�옣�븳�떎.
      //      ResponseEntity<Resource> �쓳�떟�뜲�씠�꽣 = http�쓳�떟�깮�꽦湲�.body(resource);
      //      
      //      return �쓳�떟�뜲�씠�꽣; // �룷�옣�븳 �쓳�떟 �뜲�씠�꽣瑜� �겢�씪�씠�뼵�듃濡� 由ы꽩�븳�떎.

      return ResponseEntity.ok() // HTTP �쓳�떟 �봽濡쒗넗肄쒖뿉 �뵲�씪 �쓳�떟�쓣 �닔�뻾�븷 �깮�꽦湲곕�� 以�鍮꾪븳�떎.
          .headers(header) // �쓳�떟 �뿤�뜑瑜� �꽕�젙�븳�떎.
          .contentLength(downloadFile.length()) // �쓳�떟�븷 �뙆�씪�쓽 �겕湲곕�� �꽕�젙�븳�떎.
          .contentType(MediaType.APPLICATION_OCTET_STREAM) // �쓳�떟 肄섑뀗�듃�쓽 MIME ���엯�쓣 �꽕�젙�븳�떎.
          .body(resource); // �쓳�떟 肄섑뀗�듃瑜� �깮�꽦�븳 �썑 由ы꽩�븳�떎.

    } catch (Exception e) {

      return null;
    }
  }


  private String saveFile(MultipartFile file) throws Exception {
    if (file != null && file.getSize() > 0) { 
      // �뙆�씪�쓣 ���옣�븷 �븣 �궗�슜�븷 �뙆�씪紐낆쓣 以�鍮꾪븳�떎.
      String filename = UUID.randomUUID().toString();

      // �뙆�씪紐낆쓽 �솗�옣�옄瑜� �븣�븘�궦�떎.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      // �뙆�씪�쓣 吏��젙�맂 �뤃�뜑�뿉 ���옣�븳�떎.
      File photoFile = new File("./upload/book/" + filename); // App �겢�옒�뒪瑜� �떎�뻾�븯�뒗 �봽濡쒖젥�듃 �뤃�뜑
      file.transferTo(photoFile.getCanonicalFile()); // �봽濡쒖젥�듃 �뤃�뜑�쓽 �쟾泥� 寃쎈줈瑜� �쟾�떖�븳�떎.

      // �뜽�꽕�씪 �씠誘몄� �뙆�씪 �깮�꽦
      Thumbnails.of(photoFile)
      .size(50, 50)
      .crop(Positions.CENTER)
      .outputFormat("jpg")
      .toFile(new File("./upload/book/" + "50x50_" + filename));

      return filename;

    } else {
      return null;
    }
  }
}

