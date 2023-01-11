package com.nr.vaadinpractice.practicalVaadin.serverPush;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.catalina.Executor;
import org.springframework.scheduling.annotation.Scheduled;

//@Push
//@Route("with-server-push")
public class ServerPushView
  extends Composite<Component>
  implements AppShellConfigurator, ServletContextListener {

  private static ScheduledExecutorService executorService;

  private VerticalLayout layout;
  Button button = new Button("Run long task");

  public static ScheduledExecutorService getExecutorService() {
    return executorService;
  }

  @Override
  protected Component initContent() {
    button.addClickListener(event -> {
      runLongTask();
    });
    // button.setDisableOnClick(true);
    layout =
      new VerticalLayout(button, new Button("Does this work?", e -> addText()));
    return layout;
  }

  private void runLongTask() {
    Notification.show("Running the task...");
    var ui = UI.getCurrent();
    ServerPushView
      .getExecutorService()
      .execute(() -> {
        try {
          Thread.sleep(5000);
          ui.access(() -> {
            button.setEnabled(true);
            Notification.show("Task completed.");
          });
        } catch (InterruptedException ignored) {}
      });
  }

  private void addText() {
    layout.add(new Paragraph("It works!"));
  }

  @Override
  public void contextInitialized(ServletContextEvent event) {
    executorService = Executors.newScheduledThreadPool(3);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    executorService.shutdown();
  }
}
