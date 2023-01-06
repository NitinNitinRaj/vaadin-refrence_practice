package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(NumericInputView.ROUTE)
@PageTitle(NumericInputView.TITLE)
public class NumericInputView extends Composite<Component> {

  public static final String ROUTE = "numericInputView";
  public static final String TITLE = "Numeric Input View";

  @Override
  protected Component initContent() {
    NumberField numberField = new NumberField("Rating"); //IntegerField
    numberField.setMin(0.0);
    numberField.setMax(10.0);
    numberField.setStep(0.5);
    numberField.setClearButtonVisible(true);
    numberField.setHelperText("Form 0.0 to 10.0");
    numberField.addValueChangeListener(e -> {
      Notification.show("Your rating: " + e.getValue());
    });
    return new VerticalLayout(numberField);
  }
}
