package com.nr.vaadinpractice.view.routing;

import com.nr.vaadinpractice.view.MainView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.Route;

@Route(value = HomeView.ROUTE, layout = MainView.class)
public class HomeView extends Composite<Div> implements HasComponents {

  public static final String ROUTE = "home";
  public static final String TITLE = "Routing";

  public HomeView() {
    add(new H2("Welcome to lottery!"));
  }
}
