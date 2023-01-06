package com.nr.vaadinpractice.practicalVaadin.layouts.basics;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = GreetingView.ROUTE)
@PageTitle(value = GreetingView.TITLE)
public class GreetingView extends VerticalLayout {

  private static final TextField name = new TextField("Your Name");
  public static final String ROUTE = "greetingView";
  public static final String TITLE = "Greeting View";

  public GreetingView() {
    add(new H1(TITLE));
    add(name);
    add(
      new Button(
        "Submit",
        e -> {
          Notification.show("Hello " + name.getValue());
        }
      )
    );
  }
}
