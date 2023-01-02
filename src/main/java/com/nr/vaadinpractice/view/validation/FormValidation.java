package com.nr.vaadinpractice.view.validation;

import com.nr.vaadinpractice.view.MainView;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.router.Route;

@Route(value = FormValidation.ROUTE, layout = MainView.class)
public class FormValidation extends FormLayout {

  public static final String TITLE = "Form Validation";
  public static final String ROUTE = "formValidation";

  private EmailField emailValidationField;

  @PropertyId("lengthValidation")
  private TextField lengthValidationField;

  @PropertyId("vaadinValidation")
  private TextField vaadinValidationField;

  private Binder<Data> binder = new Binder<>(Data.class);

  public FormValidation() {
    setSizeFull();

    emailValidationField = new EmailField("Email Validation");
    lengthValidationField = new TextField("Length Validation");
    vaadinValidationField = new TextField("Vaadin Validation");

    emailValidationField.setWidthFull();
    lengthValidationField.setWidthFull();
    vaadinValidationField.setWidthFull();

    binder
      .forField(emailValidationField)
      .withValidator(
        new EmailValidator("Are you sure the given value is an email address.")
      )
      .bind(Data::getEmailValidation, Data::setEmailValidation);

    binder
      .forField(lengthValidationField)
      .withValidator(
        new StringLengthValidator("Max length of 10 allowed.", null, 10)
      )
      .bind("lengthValidation");

    binder
      .forField(vaadinValidationField)
      .withValidator(new VaadinValidator())
      .bind(Data::getVaadinValidation, Data::setVaadinValidation);

    add(emailValidationField, lengthValidationField, vaadinValidationField);

    setWidth("25em");
  }
}
