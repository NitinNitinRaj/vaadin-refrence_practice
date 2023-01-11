package com.nr.vaadinpractice.practicalVaadin.layouts.appLayout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.Tabs.Orientation;

public class BusinessAppLayout extends AppLayout {

  public BusinessAppLayout() {
    Image logo = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
    logo.setHeight("44px");
    addToNavbar(new DrawerToggle(), logo);
    Tabs tabs = new Tabs(
      new Tab("Home"),
      new Tab("Finance"),
      new Tab("Marketing"),
      new Tab("Sales"),
      new Tab("Inventory"),
      new Tab("HR")
    );
    tabs.setOrientation(Orientation.VERTICAL);
    addToDrawer(tabs);
  }
}
