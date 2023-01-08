package com.nr.vaadinpractice.practicalVaadin.serverPush;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("no-push")
public class NoPushView extends Composite<Component> {

  private VerticalLayout layout;

  @Override
  protected Component initContent() {
    layout =
      new VerticalLayout(
        new Button("Run long task", event -> runLongTask()),
        new Button("Does this work?", e -> addText())
      );
    return layout;
  }

  private void runLongTask() {
    Notification.show("Running the task...");
    new Thread(() -> {
      try {
        Thread.sleep(5000);
        Notification.show("Task completed.");
      } catch (InterruptedException ignored) {}
    })
      .start();
  }

  private void addText() {
    layout.add(new Paragraph("It works!"));
  }
}
