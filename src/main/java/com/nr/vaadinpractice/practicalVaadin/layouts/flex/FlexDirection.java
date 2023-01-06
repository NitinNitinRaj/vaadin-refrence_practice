package com.nr.vaadinpractice.practicalVaadin.layouts.flex;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(FlexDirection.ROUTE)
@PageTitle(FlexDirection.TITLE)
public class FlexDirection extends Composite<Component> {

  public static final String ROUTE = "flexDirection";
  public static final String TITLE = "Flex Direction View";

  @Override
  protected Component initContent() {
    var layout = new FlexLayout(
      new Button("Button 1"),
      new Button("Button 2"),
      new Button("Button 3"),
      new Button("Button 4"),
      new Button("Button 5"),
      new Button("Button 6"),
      new Button("Button 7"),
      new Button("Button 8"),
      new Button("Button 9"),
      new Button("Button 10"),
      new Button("Button 11"),
      new Button("Button 12"),
      new Button("Button 14")
    );

    layout
      .getChildren()
      .forEach(child -> child.getElement().getStyle().set("margin", "20px"));

    layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
    layout.setFlexWrap(FlexWrap.WRAP);
    layout.setAlignContent(ContentAlignment.SPACE_AROUND);
    layout.setSizeFull();
    return layout;
  }
}
