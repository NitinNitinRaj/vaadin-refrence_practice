package com.nr.vaadinpractice.practicalVaadin.ElementApi;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;

@Route("creating-dom-elements")
public class CreatingDomElementsView extends Div {

  public CreatingDomElementsView() {
    Element div = getElement();
    div.setAttribute("id", "my-div");

    Element h1 = new Element("h1");
    h1.setText("Element API example");
    div.appendChild(h1);

    Element span = new Element("span");
    span.setText("From the low-level API");
    div.appendChild(span);
  }
}
