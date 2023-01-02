package com.nr.vaadinpractice.view.validation;

import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;

public class VaadinValidator implements Validator<String> {

  @Override
  public ValidationResult apply(String value, ValueContext context) {
    if (value.equalsIgnoreCase("vaadin")) {
      return ValidationResult.ok();
    } else {
      return ValidationResult.error(value + " is not valid");
    }
  }
}
