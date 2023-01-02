package com.nr.vaadinpractice.view.binding;

import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @NotEmpty(message = "Enter name")
  @NotBlank(message = "Enter name")
  private String name;

  @NotNull
  @Min(value = 0, message = "Should be postive value")
  private double price;

  @NotNull
  @Past(message = "Invalid Date")
  private LocalDate date;
}
