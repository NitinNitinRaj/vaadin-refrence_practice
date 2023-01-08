package com.nr.vaadinpractice.practicalVaadin.dataBinding.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Manufacturer {

  private String name;

  @Size(max = 7, message = "Invalid number")
  private String phoneNumber;

  @Email(message = "Invalid email address")
  private String email;
}
