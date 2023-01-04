package com.nr.vaadinpractice.view.lasyDataFetching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgeValue {

  private int minAge;
  private int maxAge;

  @Override
  public String toString() {
    return minAge + " - " + maxAge;
  }
}
