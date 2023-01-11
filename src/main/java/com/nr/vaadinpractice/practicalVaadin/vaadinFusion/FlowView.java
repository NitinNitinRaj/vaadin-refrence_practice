package com.nr.vaadinpractice.practicalVaadin.vaadinFusion;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("flow")
public class FlowView extends Composite<Div> {

  public FlowView() {
    getContent().add(new Text("Hello from Vaddin Flow!"));
  }
}
