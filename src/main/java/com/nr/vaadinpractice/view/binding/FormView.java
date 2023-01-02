package com.nr.vaadinpractice.view.binding;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ReadOnlyHasValue;
import java.time.LocalDate;

public class FormView extends FormLayout {

  private final Paragraph nameText = new Paragraph();
  private final Paragraph priceText = new Paragraph();
  private final Paragraph dateText = new Paragraph();

  private Binder<Product> binder = new Binder<>(Product.class);

  public FormView(Product product) {
    setWidthFull();
    getStyle().set("margin", "auto");

    addFormItem(nameText, "Name");
    addFormItem(priceText, "Price");
    addFormItem(dateText, "Date");

    binder
      .forField(new ReadOnlyHasValue<String>(name -> nameText.setText(name)))
      .bind(Product::getName, null);

    binder
      .forField(
        new ReadOnlyHasValue<Double>(price ->
          priceText.setText(String.valueOf(price))
        )
      )
      .bind(Product::getPrice, null);

    binder
      .forField(
        new ReadOnlyHasValue<LocalDate>(date ->
          dateText.setText(date.toString())
        )
      )
      .bind(Product::getDate, null);

    binder.setBean(product);
  }

  public void setProduct(Product product) {
    binder.readBean(product);
  }
}
