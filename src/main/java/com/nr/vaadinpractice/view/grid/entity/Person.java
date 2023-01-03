package com.nr.vaadinpractice.view.grid.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  private String name;
  private int age;
  private LocalDate birthday;
  private String email;
}
