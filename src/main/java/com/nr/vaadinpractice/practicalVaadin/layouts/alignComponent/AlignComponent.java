package com.nr.vaadinpractice.practicalVaadin.layouts.alignComponent;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(AlignComponent.ROUTE)
@PageTitle(AlignComponent.TITLE)
public class AlignComponent extends Composite<Component> {

  public static final String ROUTE = "alignComponent";
  public static final String TITLE = "Align Component View";

  @Override
  protected Component initContent() {
    Button button1 = new Button("START");
    Button button2 = new Button("CENTER");
    Button button3 = new Button("END");
    Button button4 = new Button("Button 4");
    var buttons = new HorizontalLayout(button1, button2, button3);
    buttons.setHeightFull();
    buttons.getStyle().set("border", "1px solid black");
    buttons.setAlignSelf(Alignment.START, button1);
    buttons.setAlignSelf(Alignment.CENTER, button2);
    buttons.setAlignSelf(Alignment.END, button3);
    //  buttons.setAlignSelf(Alignment.STRETCH, button4);
    return buttons;
  }
}
