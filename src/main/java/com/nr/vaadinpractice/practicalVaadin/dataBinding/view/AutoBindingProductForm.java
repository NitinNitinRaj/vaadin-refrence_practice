package com.nr.vaadinpractice.practicalVaadin.dataBinding.view;

import com.nr.vaadinpractice.practicalVaadin.dataBinding.converter.StringToCodeConverter;
import com.nr.vaadinpractice.practicalVaadin.dataBinding.entity.Manufacturer;
import com.nr.vaadinpractice.practicalVaadin.dataBinding.entity.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.function.SerializableRunnable;
import java.util.Set;

public class AutoBindingProductForm extends Composite<Component> {

  private final SerializableRunnable saveListener;
  private Product product;

  @PropertyId("name")
  private TextField name = new TextField("Name");

  @PropertyId("manufacturer")
  private ComboBox<Manufacturer> manufacturer = new ComboBox<>("Manufacturer");

  private TextField code = new TextField("Code");

  @PropertyId("available")
  private Checkbox available = new Checkbox("available");

  private TextField phoneNumber = new TextField("Manufacturer phone number");

  private TextField email = new TextField("Manufacturer email");

  private Binder<Product> binder = new BeanValidationBinder<>(Product.class);

  public AutoBindingProductForm(
    Product product,
    Set<Manufacturer> manufacturers,
    SerializableRunnable saveListener
  ) {
    this.product = product;
    this.saveListener = saveListener;
    manufacturer.setItems(manufacturers);
    manufacturer.setItemLabelGenerator(Manufacturer::getName);

    binder
      .forField(code)
      .withConverter(new StringToCodeConverter())
      .bind(Product::getCode, Product::setCode);

    binder.bindInstanceFields(this);

    if (product.getName() == null) {
      phoneNumber.setVisible(false);
      email.setVisible(false);
    } else {
      manufacturer.setEnabled(false);
      binder.bind(phoneNumber, "manufacturer.phoneNumber");
      binder.bind(email, "manufacturer.email");
    }

    binder.setBean(product);
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
      new H1("Product"),
      name,
      available,
      manufacturer,
      phoneNumber,
      email,
      code,
      new Button(
        "Save",
        VaadinIcon.CHECK.create(),
        event -> {
          binder.validate();
          if (binder.isValid()) {
            saveListener.run();
          } else {
            Notification notification = new Notification();
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.add("Please fix the error");
            notification.open();
          }
        }
      )
    );
  }
}
