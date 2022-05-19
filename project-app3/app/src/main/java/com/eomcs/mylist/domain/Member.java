package com.eomcs.mylist.domain;

import java.sql.Date;



public class Member {
  int no;
  String name;
  String email;
  String password;
  Date registDate;
  
@Override
public String toString() {
	return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", registDate="
			+ registDate + "]";
}

public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Date getRegistDate() {
	return registDate;
}
public void setRegistDate(Date registDate) {
	this.registDate = registDate;
}
  


}