package com.eomcs.oop.ex11.h.Test;

// 시험문제에 자주 출시함 

public class LinkedList {
  Node head;
  Node tail;
  int size;
  
 public void add(Object value) {
   Node node =new Node(value); // 노드 생성 
    
   if(head == null) {
    tail = head = node;
   } else {
     node.prev=tail;
     tail.next=node;
     tail = node;
   }
   
   size++;
 }
 
 public void add(int index, Object value) {
   Node node = getNode(index);
   
   Node newNode = new Node(value);
   
   if(node.prev != null) { // 첫 번째 노드가 아니라면 
   node.prev.next = newNode; // 앞 노드 뒤에 노드를 새 노드로 설정 
   }
   newNode.prev = node.prev; // 새 노드의 앞 노드 설정 
   
   node.prev = newNode; // 현재 노드의 앞 노드를  새 노드로 설정 
   newNode.next = node; // 현재 노드의 다음 노드를 현재 노드로 설정 
  
   if(node == head) { // 첫번째 노드라면 
     head = newNode; // 새 노드를 첫번째 노드로 만든다. 
   }
   
   
  size++;
 
 }
 
 public int size() {
   return size; 
 }
 
 public Object get(int index) {
   Node node = getNode(index);   
   
   return node.value; 
 }
 
 public Object remove(int index) {
   Node node = getNode(index);
   
   if(size == 1 ) { 
     head = tail = null;
   } else if (node == head) {
     head = node.next;
   } else if ( node == tail) {
     tail = node.prev;
   } else {
     node.prev.next =node.next;
     node.next.prev = node.prev;
   }
   
   //삭제된 노드는 다른 노드나 객체를 참조하지 않도록 초기화 시킨다. 
   //  => 삭제된 노드끼리 참조하는 경우 가비지가 되지 않는 문제가 발생한다. 
   // 삭제한 노드가 값 객체의 주소를 갖고 있으면 값 객체가 가비지가 되지 않는 문제가 발생한다. 
   node.prev = null;
   node.next = null;
   Object deleted = node.value;
   node.value = null;
   
   size--; // -- size; 해도 된다. 
   
   return deleted;  // 삭제되기 전의 값 리턴 
 }
 
 public Object set(int index,Object value) {
   Node node = getNode(index);
   Object old = node.value;
   node.value = value; 
   return old; // 변경되기 전의 값 리턴 
 }
 
 private Node getNode(int index) {
   if( index < 0 || index >= size) {
     throw new IndexOutOfBoundsException();
   }
   //이부분 다룰수 있어야함
   Node node = head;
   int count = 0; 
   while(count < index) {
     node = node.next;
     count++;
   }
   
   return node;
 }
 
 public Iterator iterator() {
// Non-static nested class( = inner class) 활용 예 
 // => 특정 클래스 안에서만 사용될 때 
 // => 바깥 클래스의 인스턴스 멤버를 사용할 때
   return new  Iterator() {

     int cursor;
    
     @Override
     public boolean hasNext() {
       return cursor < LinkedList.this.size();      
     }
     
     @Override
     public Object next() {
       return LinkedList.this.get(cursor++);
     }
   };
 }
 
 // static nested class 활용 예 
 // => 특정 클래스 안에서만 사용되는 클래스 일 때 
 // => 바깥 클래스의 인스턴스 멤버를 사용하지 않을 때 
 private static class Node {
   Node prev;
   Object value;
   Node next;
   

   public Node(Object value) {
     this.value = value; // 필요하면 생성자를 추가 
   }
 }
 
 
   }
   
   

