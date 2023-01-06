package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(_NotificationView.ROUTE)
@PageTitle(_NotificationView.TITLE)
public class _NotificationView extends Composite<Component> {

  public static final String ROUTE = "notificationView";
  public static final String TITLE = "Notification View";

  static boolean firstClick = true;

  @Override
  protected Component initContent() {
    return new VerticalLayout(
      new Button(
        "Notification",
        event -> {
          Notification notification = new Notification();
          notification.add(new VerticalLayout(new Text("Button Clicked")));
          notification.setPosition(Position.MIDDLE);
          if (firstClick) {
            notification.setDuration(0);
            notification.add(
              new Button(
                "Close",
                e -> {
                  notification.close();
                }
              )
            );
          } else {
            notification.setDuration(2000);
          }
          firstClick = false;
          notification.open();
        }
      )
    );
  }
}
