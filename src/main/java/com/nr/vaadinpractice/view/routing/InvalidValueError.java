package com.nr.vaadinpractice.view.routing;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;

@Tag("div")
public class InvalidValueError
  extends Component
  implements HasErrorParameter<InvalidValueExeption> {

  @Override
  public int setErrorParameter(
    BeforeEnterEvent arg0,
    ErrorParameter<InvalidValueExeption> arg1
  ) {
    getElement().setText(arg1.getException().getMessage());
    return 500;
  }
}
