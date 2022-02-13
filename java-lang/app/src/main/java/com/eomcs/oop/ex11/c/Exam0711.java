// inner class 응용 I : 1단계 - 스태틱 중첩 클래스 사용 
package com.eomcs.oop.ex11.c;

import java.util.ArrayList;
import java.util.List;

public class Exam0711 {

  public static void main(String[] args) {
    Musics1 m1 = new Musics1(); // 플레이리스트 
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");

    Musics1 m2 = new Musics1();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");

    // Player가 사용할 Musics2 객체를 넘길 떄는 
    // 다음과 같이 파라미터가 아니라 
    // 생성자 호출 문장 앞쪽에 놓는다. 
    //Musics1.Player p1 = m1.new.Player(m1);
    //Musics1.Player p1 = m2.new.Player(m1);
    
    
    Musics1.Player p1 = new Musics1.Player(m1);
    Musics1.Player p2 = new Musics1.Player(m2);

    p1.play();
    p2.play();
  }
}


class Musics1 {

  List<String> songs = new ArrayList<>(); // 음악 목록을 관리 

  public void add(final String song) {
    songs.add(song);
  }

  public void delete(final int index) {
    songs.remove(index);
  }


  static class Player {

    // 스태틱 중첩 클래스에서 바깥 클래스의 인스턴스를 사용하려면
    // 다음과 같이 바깥 클래스의 인스턴스 주소를 저장하는 변수를 개발자가 직접 선언해 줘야 한다.
    Musics1 musics;

    // 또한 바깥 클래스의 인스턴스 주소를 받는 파라미터를 
    // 개발자가 직접 생성자에 선언해 줘야 한다.
    public Player(Musics1 musics) {
      this.musics = musics;
    }

    public void play() {
      // 필드에 보관되어 있는 Musics 객체에서 음악 파일을 꺼내 플레이 한다.
      for (final String song : musics.songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------------");
    }
  }


}


