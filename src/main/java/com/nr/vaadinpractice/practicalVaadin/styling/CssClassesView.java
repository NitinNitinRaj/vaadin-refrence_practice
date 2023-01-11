package com.nr.vaadinpractice.practicalVaadin.styling;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/css-classes.css")
@CssImport(value = "./styles/vaadin-grid.css", themeFor = "vaadin-grid")
@Route("css-classes-view")
@PageTitle("CssClassesView")
public class CssClassesView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var header = new Div(
      VaadinIcon.VAADIN_H.create(),
      new H1("Title"),
      new Anchor("https://vaadin.com", "Vaadin")
    );
    Grid<String> grid = new Grid<>(String.class);
    grid.setItems("item1", "item2", "item3");
    var layout = new Div();
    layout.add(header, grid);

    layout.addClassName(getClass().getSimpleName());
    header.addClassName(getClass().getSimpleName() + "-header");
    grid.addClassName(getClass().getSimpleName() + "-grid");

    return layout;
  }
}
