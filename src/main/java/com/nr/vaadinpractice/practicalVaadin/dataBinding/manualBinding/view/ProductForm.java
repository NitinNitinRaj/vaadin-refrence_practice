package com.nr.vaadinpractice.practicalVaadin.dataBinding.manualBinding.view;

import com.nr.vaadinpractice.practicalVaadin.dataBinding.manualBinding.entity.Manufacturer;
import com.nr.vaadinpractice.practicalVaadin.dataBinding.manualBinding.entity.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.function.SerializableRunnable;
import java.util.Set;

public class ProductForm extends Composite<Component> {

  private final SerializableRunnable saveListener;
  private Product product;

  private TextField name = new TextField("Name");
  private ComboBox<Manufacturer> manufacturer = new ComboBox<>("Manufacturer");
  private Checkbox available = new Checkbox("Available");

  public ProductForm(
    Product product,
    Set<Manufacturer> manufacturers,
    SerializableRunnable saveListener
  ) {
    this.product = product;
    this.saveListener = saveListener;
    manufacturer.setItems(manufacturers);
    manufacturer.setItemLabelGenerator(Manufacturer::getName);

    Binder<Product> binder = new Binder<>();
    binder.bind(name, Product::getName, Product::setName);
    binder.bind(
      manufacturer,
      Product::getManufacturer,
      Product::setManufacturer
    );
    binder.bind(available, Product::isAvailable, Product::setAvailable);
    binder.setBean(product);
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
      new H1("Product"),
      name,
      manufacturer,
      available,
      new Button("Save", VaadinIcon.CHECK.create(), event -> saveListener.run())
    );
  }
}
