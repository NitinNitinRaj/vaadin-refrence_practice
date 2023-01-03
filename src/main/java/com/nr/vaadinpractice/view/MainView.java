package com.nr.vaadinpractice.view;

import com.nr.vaadinpractice.view.binding.FormBinding;
import com.nr.vaadinpractice.view.form.Form;
import com.nr.vaadinpractice.view.grid.gridView.PersonGrid;
import com.nr.vaadinpractice.view.gridFiltering.FilteringDataProvider;
import com.nr.vaadinpractice.view.layout.Layout;
import com.nr.vaadinpractice.view.validation.FormValidation;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/styles.css")
public class MainView extends AppLayout {

  public MainView() {
    addToNavbar(new DrawerToggle());
    addToNavbar(new H2("Vaadin Refrence"));
    Tab layout = new Tab(
      new Span("1) "),
      new RouterLink(Layout.TITLE, Layout.class)
    );
    Tab formValidation = new Tab(
      new Span("3) "),
      new RouterLink(FormValidation.TITLE, FormValidation.class)
    );

    Tab layoutTab = new Tab(
      new Span("2) "),
      new RouterLink(Form.TITLE, Form.class)
    );

    Tab formBinding = new Tab(
      new Span("4) "),
      new RouterLink(FormBinding.TITLE, FormBinding.class)
    );

    Tab grid = new Tab(
      new Span("5) "),
      new RouterLink(PersonGrid.TITLE, PersonGrid.class)
    );

    Tab gridFiltering = new Tab(
      new Span("6) "),
      new RouterLink(FilteringDataProvider.TITLE, FilteringDataProvider.class)
    );

    addToDrawer(
      layout,
      layoutTab,
      formValidation,
      formBinding,
      grid,
      gridFiltering
    );
  }
}
