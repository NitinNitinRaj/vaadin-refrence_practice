package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
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
    NumberField numberField = new NumberField("Rating");
    return new VerticalLayout(numberField);
  }
}
