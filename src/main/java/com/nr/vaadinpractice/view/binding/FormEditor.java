package com.nr.vaadinpractice.view.binding;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class FormEditor extends FormLayout {

  @PropertyId("name")
  private TextField name = new TextField("Name");

  @PropertyId("price")
  private NumberField price = new NumberField("Price");

  @PropertyId("date")
  private DatePicker date = new DatePicker("Available");

  private Button save = new Button("Save");
  private Button cancel = new Button("Cancel");

  private Binder<Product> binder = new BeanValidationBinder<>(Product.class);
  private Product product;

  public FormEditor() {
    setWidthFull();
    getStyle().set("margin", "5px");
    getStyle().set("marginRight", "25%");

    product = new Product();

    name.setAutofocus(true);

    Div suffix = new Div();
    suffix.setText("$");

    price.setSuffixComponent(suffix);
    price.clear();

    binder.setBean(product);

    final HorizontalLayout buttonLayout = new HorizontalLayout();
    save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    buttonLayout.add(save, cancel);

    configButtonActions();

    add(name, price, date, buttonLayout);

    binder.bindInstanceFields(this);
  }

  private void configButtonActions() {
    save.addClickListener(event -> saveProduct());
    cancel.addClickListener(event -> {
      fireEvent(new CloseEvent(this));
      binder.readBean(new Product());
    });
  }

  private void saveProduct() {
    Product product = new Product(
      name.getValue(),
      price.getValue(),
      date.getValue()
    );

    try {
      binder.writeBean(product);
      fireEvent(new SaveEvent(this, product));
    } catch (ValidationException e) {
      add(Notification.show(e.getMessage()));
    }
  }

  public static class FormEvent extends ComponentEvent<FormEditor> {

    private Product product;

    public FormEvent(FormEditor source, Product product) {
      super(source, false);
      this.product = product;
    }

    public Product getProduct() {
      return product;
    }
  }

  public static class SaveEvent extends FormEvent {

    public SaveEvent(FormEditor source, Product product) {
      super(source, product);
    }
  }

  public static class CloseEvent extends FormEvent {

    public CloseEvent(FormEditor source) {
      super(source, null);
    }
  }

  public <T extends ComponentEvent<?>> Registration addListner(
    Class<T> eventType,
    ComponentEventListener<T> listener
  ) {
    return getEventBus().addListener(eventType, listener);
  }
}
