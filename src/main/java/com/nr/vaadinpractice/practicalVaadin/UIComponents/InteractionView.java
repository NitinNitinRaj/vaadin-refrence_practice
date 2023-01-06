package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.helger.commons.io.stream.StringInputStream;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import java.nio.charset.Charset;
import java.time.LocalTime;

@Route(InteractionView.ROUTE)
@PageTitle(InteractionView.TITLE)
public class InteractionView extends Composite<Component> {

  public static final String ROUTE = "interactionView";
  public static final String TITLE = "Interaction View";

  @Override
  protected Component initContent() {
    Button button = new Button("Time in the server");
    button.addClickListener(e -> {
      Notification.show("Sure: " + LocalTime.now());
      e.getSource().setEnabled(false);
    });

    Anchor youtube = new Anchor(
      "https://www.youtube.com",
      new Button("Youtube")
    );
    youtube.setTarget("_blank");

    Anchor textAnchor = new Anchor(
      new StreamResource(
        "text.txt",
        () -> {
          String content = "Time: " + LocalTime.now();
          return new StringInputStream(content, Charset.defaultCharset());
        }
      ),
      "Server-generated text"
    );

    return new VerticalLayout(button, youtube, textAnchor);
  }
}
