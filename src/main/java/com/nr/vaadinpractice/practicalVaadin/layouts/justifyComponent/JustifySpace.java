package com.nr.vaadinpractice.practicalVaadin.layouts.justifyComponent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(JustifySpace.ROUTE)
@PageTitle(JustifySpace.TITLE)
public class JustifySpace extends Composite<Component> {

  public static final String ROUTE = "justifySpace";
  public static final String TITLE = "Justify Space View";

  @Override
  protected Component initContent() {
    var button1Layout = new HorizontalLayout(
      new Button("1"),
      new Button("2"),
      new Button("3")
    );
    var button2Layout = new HorizontalLayout(
      new Button("1"),
      new Button("2"),
      new Button("3")
    );
    var button3Layout = new HorizontalLayout(
      new Button("1"),
      new Button("2"),
      new Button("3")
    );

    button1Layout.setWidthFull();
    button2Layout.setWidthFull();
    button3Layout.setWidthFull();

    button1Layout.getStyle().set("border", "solid 1px black");
    button2Layout.getStyle().set("border", "solid 1px black");
    button3Layout.getStyle().set("border", "solid 1px black");

    button1Layout.setSpacing(false);
    button2Layout.setSpacing(false);
    button3Layout.setSpacing(false);

    var buttons = new VerticalLayout(
      new H3("BETWEEN:"),
      button1Layout,
      new H3("AROUND:"),
      button2Layout,
      new H3("EVENLY:"),
      button3Layout
    );

    button1Layout.setJustifyContentMode(JustifyContentMode.BETWEEN);
    button2Layout.setJustifyContentMode(JustifyContentMode.AROUND);
    button3Layout.setJustifyContentMode(JustifyContentMode.EVENLY);

    return buttons;
  }
}
