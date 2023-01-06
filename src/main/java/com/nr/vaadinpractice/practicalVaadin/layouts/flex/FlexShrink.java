package com.nr.vaadinpractice.practicalVaadin.layouts.flex;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(FlexShrink.ROUTE)
@PageTitle(FlexShrink.TITLE)
public class FlexShrink extends Composite<Component> {

  public static final String ROUTE = "flexShrink";
  public static final String TITLE = "Flex Shrink View";

  @Override
  protected Component initContent() {
    Button button1 = new Button("Button 1");
    Button button2 = new Button("Button 2");

    button1.setWidth("200px");
    button1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    button2.setWidth("200px");

    var layout = new FlexLayout(button1, button2);
    layout.setWidth("300px");

    layout.getStyle().set("border", "solid 1px black");
    layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
    layout.setFlexShrink(1d, button1);
    layout.setFlexShrink(2d, button2);

    return layout;
  }
}
