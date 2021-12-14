package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class my1Controller {
  String[] menu= new String [4];
  int total=0; //배열에 집어넣은 개수 

  @RequestMapping("/food/list")
  public Object list() {
    String[] arr = new String[total]; //배열에 저장된 값만 복사할 새 배열을 만든다 .
    for (int i = 0; i < total; i++) {
      arr[i]=menu[i]; //전체 배열에서 값이 들어있는 항목만 복사한다. 
    }
    return arr; // 복사한 항목들을 담고있는 새 배열을  리턴한다. 
  }

  @RequestMapping("/food/plus")
  public Object plus(String name, String price, String type, String size) {
    String food = name + "," + price+ ","+ type + "," + size;
    //String food = name + "," + Integer.parseInt(price)+ ","+ type + "," + size;
    menu[total] =food;
    total++;
    return food; //현재 몇개를 입력했는지 리턴 
  }

  @RequestMapping ("/food/get")
  public Object get(String name) { 
    // System.out.println("Name: "+name + ", price: "+ price+ ", type: " +type + ", size: " + size);
    //System.out.println("name : " + name);
    for (int i = 0; i < total; i++) {     
      if(menu[i].split(",")[0].equals(name)) {
        return menu[i]; 
      } 
    }
    return "";
  }

  @RequestMapping("/food/update")
  public Object update(String name, String price, String type, String size) { 
    String food = name + "," + price + "," + type + "," + size;
    for(int i = 0; i < total; i++) {
      if(menu[i].split(",")[0].equals(name)) {
        menu[i] = food;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("/food/minus")
  public Object minus(String name) { 
    for (int i = 0; i < total; i++) {
      if(menu[i].split(",")[0].equals(name)) {
        //현재 위치의 다음 항목에서 배열 끝까지 반복하며 앞으로 값을 당긴다. 
        for(int j=i+1; j < total; j++) {
          menu[j-1] = menu[j];
        }
        total--;
        return 1; 
      }
    }
    return 0;
  }
}

