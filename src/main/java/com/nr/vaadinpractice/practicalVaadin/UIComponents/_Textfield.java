package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(_Textfield.ROUTE)
@PageTitle(_Textfield.TITLE)
public class _Textfield extends Composite<Component> {

  public static final String ROUTE = "text-field";
  public static final String TITLE = "Textfield View";

  @Override
  protected Component initContent() {
    var textfield = new TextField();
    textfield.setLabel("Name");
    textfield.setPlaceholder("enter your full name");
    textfield.setAutoselect(true);
    textfield.setAutofocus(true);
    textfield.setClearButtonVisible(true);
    textfield.setValue("Nitin Raj");
    textfield.setRequired(true);
    textfield.setMinLength(2);
    textfield.setMaxLength(10);
    textfield.setPattern("[a-zA-Z\\s]+");
    textfield.setErrorMessage("Letter only. Min 2 chars");
    textfield.addValueChangeListener(e -> {
      if (textfield.isInvalid()) {
        Notification.show("Invalid Name");
      }
    });
    textfield.setValueChangeMode(ValueChangeMode.EAGER);
    return textfield;
  }
}
