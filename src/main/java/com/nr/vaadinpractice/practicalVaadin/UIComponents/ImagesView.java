package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route(ImagesView.ROUTE)
@PageTitle(ImagesView.TITLE)
public class ImagesView extends Composite<Component> {

  public static final String ROUTE = "imagesView";
  public static final String TITLE = "Images View";

  @Override
  protected Component initContent() {
    Image photo = new Image(
      "https://live.staticflickr.com/65535/50969482201_be1163c6f1_b.jpg",
      "Dog"
    );
    photo.setWidth("500px");

    StreamResource source = new StreamResource(
      "tesla",
      () -> getClass().getClassLoader().getResourceAsStream("tesla.jpeg")
    );

    Image tesla = new Image(source, "Tesla");
    tesla.setWidth("500px");

    return new VerticalLayout(photo, tesla);
  }
}
