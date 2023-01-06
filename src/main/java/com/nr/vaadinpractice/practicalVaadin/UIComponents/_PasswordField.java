package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(_PasswordField.ROUTE)
@PageTitle(_PasswordField.TITLE)
public class _PasswordField extends Composite<Component> {

  public static final String ROUTE = "password-field";
  public static final String TITLE = "PasswordField View";

  @Override
  protected Component initContent() {
    PasswordField passwordField = new PasswordField();
    passwordField.setLabel("Password");
    passwordField.setRevealButtonVisible(true);
    passwordField.addValueChangeListener(e -> {
      System.out.println("Password: " + e.getValue());
    });

    Checkbox checkbox = new Checkbox();
    checkbox.setValue(true);
    checkbox.setIndeterminate(true);
    Notification.show("Initial Value: " + checkbox.getValue());
    checkbox.setLabel("I'm learning Vaadin!");
    checkbox.addValueChangeListener(e -> {
      Notification.show("Learning Vaadin: " + e.getValue());
    });
    return new VerticalLayout(passwordField, checkbox);
  }
}
