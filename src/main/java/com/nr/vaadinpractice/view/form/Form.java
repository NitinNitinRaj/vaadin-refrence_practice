package com.nr.vaadinpractice.view.form;

import com.nr.vaadinpractice.view.MainView;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;

@Route(value = Form.ROUTE, layout = MainView.class)
public class Form extends FormLayout {

  public static final String ROUTE = "form";
  public static final String TITLE = "Form";

  private TextField firstName;
  private TextField lastName;
  private TextField email;
  private Checkbox doNotCall;
  private NumberField phone;
  private PasswordField password;
  private PasswordField repeatPassword;

  public Form() {
    setSizeFull();

    firstName = new TextField();
    lastName = new TextField();
    email = new TextField();
    phone = new NumberField();
    doNotCall = new Checkbox("Do not call");
    password = new PasswordField();
    repeatPassword = new PasswordField();

    firstName.setWidthFull();
    lastName.setWidthFull();
    email.setWidthFull();
    password.setWidthFull();
    repeatPassword.setWidthFull();

    addFormItem(firstName, "First Name");
    addFormItem(lastName, "Last Name");
    addFormItem(email, "Email").getElement().setAttribute("colSpan", "2");

    FlexLayout phonLayout = new FlexLayout();
    phonLayout.setWidthFull();
    phonLayout.add(phone, doNotCall);
    phonLayout.expand(phone);
    phonLayout.setAlignItems(Alignment.CENTER);

    addFormItem(phonLayout, "Phone").getElement().setAttribute("colSpan", "2");
    addFormItem(password, "Password");
    getElement().appendChild(ElementFactory.createBr());
    addFormItem(repeatPassword, "Repeat Password");
  }
}
