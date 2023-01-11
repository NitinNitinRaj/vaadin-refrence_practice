package com.nr.vaadinpractice.practicalVaadin.serverPush;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.communication.PushMode;

// @Push(value = PushMode.MANUAL)
@Route("manual-push")
public class ManualPushView
  extends Composite<Component> /*  implements AppShellConfigurator */{

  private VerticalLayout layout;
  private ProgressBar progressBar = new ProgressBar(0, 10);
  private Button button = new Button("Run long task");

  @Override
  protected Component initContent() {
    button.addClickListener(event -> {
      runLongTask();
    });
    button.setDisableOnClick(true);
    layout =
      new VerticalLayout(
        button,
        new Button("Does this work?", e -> addText()),
        progressBar
      );
    return layout;
  }

  private void runLongTask() {
    Notification.show("Running the task...", 10000, Position.BOTTOM_START);
    progressBar.setValue(0);
    var ui = UI.getCurrent();
    new Thread(() -> {
      try {
        for (int i = 1; i <= 10; i++) {
          Thread.sleep(1000);
          double progress = i;
          ui.access(() -> {
            progressBar.setValue(progress);
            ui.push();
          });
        }
        ui.access(() -> {
          Notification.show("Task Completed");
          button.setEnabled(true);
          ui.push();
        });
      } catch (InterruptedException ignored) {}
    })
      .start();
  }

  private void addText() {
    layout.add(new Paragraph("It works!"));
  }
}
