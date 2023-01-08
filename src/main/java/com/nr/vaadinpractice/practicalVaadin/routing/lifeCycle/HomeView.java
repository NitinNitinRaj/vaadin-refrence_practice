package com.nr.vaadinpractice.practicalVaadin.routing.lifeCycle;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinSession;
import java.util.Optional;

@Route("navgationLifeCycle")
public class HomeView
  extends Composite<Component>
  implements BeforeEnterObserver {

  @Override
  protected Component initContent() {
    return new VerticalLayout(
      new H1("Welcome!"),
      new RouterLink("Go to my data", DataView.class)
    );
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    if (getData().isEmpty() || getData().get().isEmpty()) {
      event.rerouteTo(NoDataView.class);
    }
  }

  private Optional<String> getData() {
    String data = (String) VaadinSession.getCurrent().getAttribute("data");
    return Optional.ofNullable(data);
  }
}
