package com.nr.vaadinpractice.practicalVaadin.styling;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/custom-style.css")
@Route("custom-styling")
@PageTitle("CustomStyling")
public class CustomStyling extends Composite<Component> {

  private H1 heading;
  private TextField name;
  private Button send;

  public CustomStyling() {
    heading = new H1("Custom CSS Example");
    name = new TextField("What's your name");
    send = new Button("Send");
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(heading, name, send);
  }
}
