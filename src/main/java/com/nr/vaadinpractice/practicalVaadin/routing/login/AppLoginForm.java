package com.nr.vaadinpractice.practicalVaadin.routing.login;

import com.nr.vaadinpractice.practicalVaadin.routing.routerLayout.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import org.apache.catalina.User;

@Route("login")
public class AppLoginForm extends Composite<Component> {

  @Override
  protected Component initContent() {
    RouteConfiguration.forSessionScope().removeRoute(AdminView.class);
    RouteConfiguration.forSessionScope().removeRoute(UserView.class);
    LoginI18n i18n = LoginI18n.createDefault();
    LoginOverlay loginOverlay = new LoginOverlay(i18n);
    loginOverlay.setTitle("Login");
    loginOverlay.setDescription("Navigation and routing");
    loginOverlay.setOpened(true);

    loginOverlay.addForgotPasswordListener(event ->
      Notification.show("User admin/admin or user/user")
    );
    loginOverlay.addLoginListener(event -> {
      if (
        "user".equals(event.getUsername()) && "user".equals(event.getPassword())
      ) {
        RouteConfiguration
          .forSessionScope()
          .setRoute("user", UserView.class, MainLayout.class);
        RouteConfiguration.forSessionScope().removeRoute(AdminView.class);
        UI.getCurrent().navigate(UserView.class);
        loginOverlay.close();
      } else if (
        "admin".equals(event.getUsername()) &&
        "admin".equals(event.getPassword())
      ) {
        RouteConfiguration
          .forSessionScope()
          .setRoute("admin", AdminView.class, MainLayout.class);
        RouteConfiguration.forSessionScope().removeRoute(UserView.class);
        UI.getCurrent().navigate(AdminView.class);
        loginOverlay.close();
      } else {
        loginOverlay.setError(true);
      }
    });

    return new VerticalLayout(loginOverlay);
  }
}
