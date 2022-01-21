package com.eomcs.app1;

import java.util.ArrayList;

public class Command {
  String name;
  ArrayList params = new ArrayList(); // params = parameters 축약형 

  public Command(String name, String[] values) {
    this.name = name;
    for(String value : values) {
      this.params.add(value);
    }
  }

  public String getName() {
    return this.name;
  }

  public String getString(int parmaIndex) {
    return (String)this.params.get(parmaIndex);
  }

  public int getInt(int paramIndex) {
    return Integer.parseInt((String) this. params.get(paramIndex));
  }

  public int getParamSize() {
    return this.params.size();
  }
}
