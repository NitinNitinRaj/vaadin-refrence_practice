package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(TabsView.ROUTE)
@PageTitle(TabsView.TITLE)
public class TabsView extends Composite<Component> {

  public static final String ROUTE = "tabsView";
  public static final String TITLE = "Tabs View";

  @Override
  protected Component initContent() {
    VerticalLayout tabsContainer = new VerticalLayout();

    Tab order = new Tab("Order");
    Tab delivery = new Tab("Delivery");
    Tabs tabs = new Tabs(order, delivery);

    tabs.addSelectedChangeListener(event -> {
      Tab selected = event.getSelectedTab();
      tabsContainer.removeAll();
      if (order.equals(selected)) {
        tabsContainer.add(buildOrderTab());
      } else if (delivery.equals(selected)) {
        tabsContainer.add(buildDeliveryTab());
      }
    });

    return new VerticalLayout(tabs, tabsContainer);
  }

  private Component buildDeliveryTab() {
    return new H1("Delivery Tab"); //ideally return any layout
  }

  private Component buildOrderTab() {
    return new H1("Order Tab"); //ideally return any layout
  }
}
