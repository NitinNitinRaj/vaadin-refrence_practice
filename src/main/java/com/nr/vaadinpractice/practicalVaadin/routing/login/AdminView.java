package com.nr.vaadinpractice.practicalVaadin.routing.login;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouteConfiguration;

public class AdminView extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(
      new Text("Hello admin."),
      new Button(
        "Logout",
        e -> {
          RouteConfiguration.forSessionScope().removeRoute(AdminView.class);
          UI.getCurrent().navigate("login");
        }
      )
    );
  }
}
