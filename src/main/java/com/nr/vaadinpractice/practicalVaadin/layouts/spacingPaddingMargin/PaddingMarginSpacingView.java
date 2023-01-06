package com.nr.vaadinpractice.practicalVaadin.layouts.spacingPaddingMargin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(PaddingMarginSpacingView.ROUTE)
@PageTitle(PaddingMarginSpacingView.TITLE)
public class PaddingMarginSpacingView extends Composite<Component> {

  public static final String ROUTE = "paddingMarginSpacingView";
  public static final String TITLE = "Padding Margin Spacing View";

  @Override
  protected Component initContent() {
    var layout = new HorizontalLayout();
    layout.getStyle().set("border", "1px solid");
    layout.setPadding(false);
    layout.setMargin(false);
    layout.setSpacing(false);
    layout.add(
      new Paragraph("Toggle"),
      new Button(
        "Padding",
        e -> {
          layout.setPadding(!layout.isPadding());
        }
      ),
      new Button(
        "Margin",
        e -> {
          layout.setMargin(!layout.isMargin());
        }
      ),
      new Button(
        "Spacing",
        e -> {
          layout.setSpacing(!layout.isSpacing());
        }
      )
    );
    return layout;
  }
}
