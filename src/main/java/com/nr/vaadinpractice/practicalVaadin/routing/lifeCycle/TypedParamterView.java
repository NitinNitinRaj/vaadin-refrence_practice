package com.nr.vaadinpractice.practicalVaadin.routing.lifeCycle;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import java.util.Optional;

@Route("typed-parameter")
public class TypedParamterView
  extends Composite<Component>
  implements HasUrlParameter<Integer> {

  private H1 text = new H1();

  @Override
  protected Component initContent() {
    return new VerticalLayout(text);
  }

  @Override
  public void setParameter(
    BeforeEvent event,
    @OptionalParameter Integer number
  ) {
    text.setText("" + Optional.ofNullable(number).orElse(0));
  }
}
