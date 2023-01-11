package com.nr.vaadinpractice.practicalVaadin.ElementApi;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.function.SerializableConsumer;

@Tag("img")
public class PictureButton extends Component implements HasSize {

  private static final String shadow = "1em 1em 1em #777";
  private Style style = getElement().getStyle();

  public PictureButton(
    String imageUrl,
    SerializableConsumer<DomEvent> clickListner
  ) {
    getElement().setAttribute("src", imageUrl);

    style.set("border", "1em solid #333");
    style.set("box-sizing", "border-box");
    style.set("box-shadow", shadow);

    getElement()
      .addEventListener("click", clickListner::accept)
      .addEventData("event.clientX")
      .addEventData("event.clientY");

    getElement()
      .addEventListener(
        "mousedown",
        e -> {
          style.set("transform", "scale(0.93)");
          style.remove("box-shadow");
        }
      );
    DomEventListener listner = e -> {
      style.set("transform", "scale(1)");
      style.set("box-shadow", shadow);
    };
    getElement().addEventListener("mouseup", listner);
    getElement().addEventListener("pointerleave", listner);
  }
}
