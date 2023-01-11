package com.nr.vaadinpractice.practicalVaadin.ElementApi;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import elemental.json.JsonObject;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery.B;

@Route("custom-component")
public class CustomComponentView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var button = new PictureButton(
      "https://live.staticflickr.com/65535/51154022090_22fd569976_k.jpg",
      event -> {
        JsonObject data = event.getEventData();
        var x = data.getNumber("event.clientX");
        var y = data.getNumber("event.clientY");
        Notification.show("Clicked at " + x + ", " + y);
      }
    );
    var layout = new VerticalLayout(button);
    button.setWidth("50%");

    layout.setAlignItems(Alignment.CENTER);
    return layout;
  }
}
