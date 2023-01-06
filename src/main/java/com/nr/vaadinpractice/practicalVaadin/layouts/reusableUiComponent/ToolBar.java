package com.nr.vaadinpractice.practicalVaadin.layouts.reusableUiComponent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ToolBar extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new HorizontalLayout(
      new Button("Button 1"),
      new Button("Button 2"),
      new Button("Button 3")
    );
  }
}
