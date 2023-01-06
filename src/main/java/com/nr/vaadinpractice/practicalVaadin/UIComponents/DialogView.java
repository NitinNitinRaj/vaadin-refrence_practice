package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(DialogView.ROUTE)
@PageTitle(DialogView.TITLE)
public class DialogView extends Composite<Component> {

  public static final String ROUTE = "dialogView";
  public static final String TITLE = "Dialog View";

  @Override
  protected Component initContent() {
    return new VerticalLayout(
      new Button(
        "Open Pop-up",
        event -> {
          Button close = new Button("Close");
          Dialog dialog = new Dialog(
            new VerticalLayout(
              new H2("Title"),
              new Text("Text!,ESC will close dialog"),
              close
            )
          );
          close.addClickListener(e -> dialog.close());
          dialog.open();
          dialog.setModal(true);
          dialog.setCloseOnOutsideClick(false);
          dialog.setCloseOnEsc(true);
          dialog.setDraggable(true);
        }
      )
    );
  }
}
