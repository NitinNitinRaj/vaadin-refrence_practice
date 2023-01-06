package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {

  private Integer id;
  private String name;

  public Department(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return id + " - " + name;
  }
}
