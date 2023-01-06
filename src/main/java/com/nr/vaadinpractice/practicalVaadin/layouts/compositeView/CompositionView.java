package com.nr.vaadinpractice.practicalVaadin.layouts.compositeView;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = CompositionView.ROUTE)
@PageTitle(value = CompositionView.TITLE)
public class CompositionView extends Composite<VerticalLayout> {

  public static final String ROUTE = "compositionView";
  public static final String TITLE = "Composition View";

  public CompositionView() {
    var toolbar = new HorizontalLayout(
      new Button("Button 1"),
      new Button("Button 2"),
      new Button("Button 3")
    );

    var mainLayout = getContent();
    mainLayout.add(
      toolbar,
      new Paragraph("Paragraph 1"),
      new Paragraph("Paragraph 2"),
      new Paragraph("Paragraph 3")
    );
  }
}
