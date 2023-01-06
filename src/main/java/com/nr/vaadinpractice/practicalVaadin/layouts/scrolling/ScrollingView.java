package com.nr.vaadinpractice.practicalVaadin.layouts.scrolling;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(ScrollingView.ROUTE)
@PageTitle(ScrollingView.TITLE)
public class ScrollingView extends Composite<Component> {

  public static final String ROUTE = "scrollingView";
  public static final String TITLE = "Scrolling View";

  @Override
  protected Component initContent() {
    var layout = new VerticalLayout();
    for (int i = 0; i < 1000; i++) {
      layout.add(new Button("Button " + i));
    }
    layout.setHeight("200px");
    layout.getStyle().set("overflow", "auto");
    // Scroller scroller = new Scroller(layout);
    // scroller.setHeight("200px");
    // scroller.getStyle().set("border", "solid 1px black");
    return layout;
  }
}
