package com.nr.vaadinpractice.practicalVaadin.dataBinding.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

  @NotNull
  @NotBlank(message = "Please enter name of product")
  private String name;

  private boolean available = true;

  @NotNull(message = "Select Manufacturer")
  private Manufacturer manufacturer;

  @NotNull(message = "Please introduce a code")
  private Code code = new Code(Type.DRINK, "");
}
