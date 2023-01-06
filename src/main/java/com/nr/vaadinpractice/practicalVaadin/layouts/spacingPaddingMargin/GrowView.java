package com.nr.vaadinpractice.practicalVaadin.layouts.spacingPaddingMargin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(GrowView.ROUTE)
@PageTitle(GrowView.TITLE)
public class GrowView extends Composite<Component> {

  public static final String ROUTE = "growView";
  public static final String TITLE = "Grow View";

  @Override
  protected Component initContent() {
    Button button1 = new Button("Button 1");
    Button button2 = new Button("Button 2");
    var layout = new HorizontalLayout();
    layout.getStyle().set("border", "solid 1px black");
    layout.add(button1, button2);
    layout.setWidthFull();
    layout.setFlexGrow(1, button1);
    layout.setFlexGrow(2, button2);
    return layout;
  }
}
