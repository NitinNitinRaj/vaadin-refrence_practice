package com.nr.vaadinpractice.practicalVaadin.layouts.compositeView;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = CompositionViewV2.ROUTE)
@PageTitle(value = CompositionViewV2.TITLE)
public class CompositionViewV2 extends Composite<Component> {

  public static final String ROUTE = "compositionViewV2";
  public static final String TITLE = "Composition View V2";

  @Override
  protected Component initContent() {
    var toolbar = new HorizontalLayout(
      new Button("Button 1"),
      new Button("Button 2"),
      new Button("Button 3")
    );
    return new VerticalLayout(
      toolbar,
      new Paragraph("Paragraph 1"),
      new Paragraph("Paragraph 2"),
      new Paragraph("Paragraph 3")
    );
  }
}
