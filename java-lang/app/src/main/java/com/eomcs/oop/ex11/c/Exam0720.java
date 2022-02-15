// inner class 응용 II : inner 클래스와 인터페이스  
package com.eomcs.oop.ex11.c;

import java.util.ArrayList;
import java.util.List;

public class Exam0720 {

  public static void main(String[] args) {
    Musics4 m1 = new Musics4();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");

    Musics4 m2 = new Musics4();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");

    // Musics4의 플레이어 객체를 생성한다.
    // 리턴 객체는 Player 규칙에 따라 만든 객체이다.
    Player p1 = m1.createPlayer();
    Player p2 = m2.createPlayer();

    p1.play();
    p2.play();
  }
}

// 음악 플레이어의 사용법을 정의한다. 
interface Player {
  void play();
}

class Musics4 {

  List<String> songs = new ArrayList<>();

  public void add(final String song) {
    songs.add(song);
  }

  public void delete(final int index) {
    songs.remove(index);
  }

  // Player 구현 객체를 리턴한다.
  // Player 구현체는 Musics4의 inner 클래스로 되어 있다.
  // 규칙에 따른 플레이어를 생성 
  public Player createPlayer() {
    return new PlayerImpl(); // ==> this.new PlayerImpl();  // 바깥 클래스의 객체 주소 생략!
  }

  // 인터페이스 구현체를 inner 클래스로 정의한다.
  class PlayerImpl implements Player {
    public void play() {
      for (final String song : Musics4.this.songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------------");
    }
  }


}

// 인터페이스 구현체를 inner 클래스로 정의한다.
//나중에 확장성을 생각해서 player 사용법을 아예 인터페이스로 따로 정의한 후
//player 규칙에 따라서 동작하는 클래스를 만든 후에
//그 클래스의 인스턴스를 리턴한다.
//이게 향후 시스템을 확장하기 좋은 구조다


