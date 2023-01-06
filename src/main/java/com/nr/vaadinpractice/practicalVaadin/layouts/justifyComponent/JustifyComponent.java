package com.nr.vaadinpractice.practicalVaadin.layouts.justifyComponent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(JustifyComponent.ROUTE)
@PageTitle(JustifyComponent.TITLE)
public class JustifyComponent extends Composite<Component> {

  public static final String ROUTE = "justifyComponent";
  public static final String TITLE = "Justify Component View";

  @Override
  protected Component initContent() {
    Button button1 = new Button("START");
    Button button2 = new Button("CENTER");
    Button button3 = new Button("END");

    var button1Layout = new HorizontalLayout(button1);
    var button2Layout = new HorizontalLayout(button2);
    var button3Layout = new HorizontalLayout(button3);

    button1Layout.setWidthFull();
    button2Layout.setWidthFull();
    button3Layout.setWidthFull();

    button1Layout.setJustifyContentMode(JustifyContentMode.START);
    button2Layout.setJustifyContentMode(JustifyContentMode.CENTER);
    button3Layout.setJustifyContentMode(JustifyContentMode.END);

    var buttons = new VerticalLayout(
      button1Layout,
      button2Layout,
      button3Layout
    );
    buttons
      .getChildren()
      .forEach(child -> {
        child.getElement().getStyle().set("border", "solid 1px black");
        child.getElement().getStyle().set("padding", "0");
      });
    return buttons;
  }
}
