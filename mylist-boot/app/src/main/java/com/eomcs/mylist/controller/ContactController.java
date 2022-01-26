package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;

//1) 생성자에서 FileReader 객체를 준비한다.
//2) 파일에서 문자를 읽어 출력한다.
//3) 파일을 더이상 읽을 수 없으면 반복문을 종료한다.
//4) 파일에서 읽은 문자를 버퍼에 담았다가 줄바꿈 코드를 만나면 출력한다. 
//5) 한 줄 출력한 다음에 버퍼를 비운다.
//6) 한 줄의 CSV 데이터를 읽어 분석한 후 Contact 객체에 담아서 목록에 추가한다.
//7) CSV 데이터로 Contact 객체를 초기화시키는 일을 Contact 객체의 생성자로 옮긴다.
//8) Contact 클래스의 valueOf() 스태틱 메서드를 사용하여 CSV 데이터로 객체를 생성한다.
//9) while 문 정리!
//
@RestController 
public class ContactController {

  ContactDao contactDao;


  @RequestMapping("/contact/list")
  public Object list() {
    return contactDao.findAll(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) throws Exception {
    //    System.out.println(contact);
    contactDao.insert(contact);
    return contactDao.countAll();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) throws Exception {
    Contact contact = contactDao.findByEmail(email);
    if (email == null) {
      return "";
    }
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(String email, Contact contact) throws Exception {
    Contact old = contactDao.findByEmail(email);
    if (old == null) {
      return 0;
    }
    contact.setEmail(old.getEmail());
    return contactDao.update(contact);
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) throws Exception {
    return contactDao.delete(email);
  }
}



