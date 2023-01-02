package com.nr.vaadinpractice.view.layout;

import com.nr.vaadinpractice.view.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = Layout.ROUTE, layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
public class Layout extends VerticalLayout implements HasUrlParameter<String> {

  public static final String TITLE = "Layout";
  public static final String ROUTE = "layout";

  private Div header = new Div();
  private Div footer = new Div();
  private Div nav = new Div();
  private Div content = new Div();

  private int blockNum = 0;

  public Layout() {
    setSizeFull();
    setSpacing(false);
    setPadding(false);
    setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

    header.setClassName("header");
    footer.setClassName("footer");
    nav.setClassName("navigation");
    content.setClassName("content");

    header.setText("This is header, Has height of 150px");
    header.setHeight("150px");
    header.getStyle().set("flexShrink", "0");

    footer.setText("This is Footer, Has height of 150px");
    footer.setHeight("150px");
    footer.getStyle().set("flexShrink", "0");

    add(header, mainView(), footer);
  }

  private Component mainView() {
    HorizontalLayout mainView = new HorizontalLayout();
    mainView.setSizeFull();
    mainView.setSpacing(false);
    mainView.setDefaultVerticalComponentAlignment(Alignment.STRETCH);

    nav.setText("This navigation, This is 25% of the width");
    nav.setWidth("25%");

    content.setText("This Content, This is 75% of the width");

    mainView.add(nav, content);
    mainView.expand(content);

    return mainView;
  }

  @Override
  public void setParameter(BeforeEvent event, @OptionalParameter String route) {
    if (!"scroll".equals(route)) {
      setMainContent();
    }
  }

  private void setMainContent() {
    nav.setText(null);
    content.setText(null);

    content.getStyle().set("display", "flex");
    content.getStyle().set("flexWrap", "wrap");
    content.getStyle().set("alignContent", "start");
    content.getStyle().set("overflow-y", "auto");

    Button button = new Button("Add Block");
    button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    button.addClickListener(e -> addBlocks());

    nav.add(button);
  }

  private void addBlocks() {
    Div block = new Div();
    block.setText("Block " + ++blockNum);
    block.setWidth("100px");
    block.setHeight("100px");
    block.getStyle().set("backgroundColor", "white");
    block.getStyle().set("margin", "5px");
    content.add(block);
  }
}
