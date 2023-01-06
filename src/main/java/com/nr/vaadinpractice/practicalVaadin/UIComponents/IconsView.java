package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(IconsView.ROUTE)
@PageTitle(IconsView.TITLE)
public class IconsView extends Composite<Component> {

  public static final String ROUTE = "iconsView";
  public static final String TITLE = "Icons View";

  @Override
  protected Component initContent() {
    Icon icon = VaadinIcon.YOUTUBE.create();
    icon.setSize("2em");
    Button button = new Button("Youtube");
    button.setIcon(icon);
    Anchor anchor = new Anchor("https://www.youtube.com", button);
    anchor.setTarget("_blanck");

    Button editButton = new Button("Edit", VaadinIcon.EDIT.create());
    return new VerticalLayout(anchor, editButton);
  }
}
