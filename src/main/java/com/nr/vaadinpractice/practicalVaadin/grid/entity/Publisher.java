package com.nr.vaadinpractice.practicalVaadin.grid.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Publisher {

  private String name;

  @Override
  public String toString() {
    return name;
  }
}
