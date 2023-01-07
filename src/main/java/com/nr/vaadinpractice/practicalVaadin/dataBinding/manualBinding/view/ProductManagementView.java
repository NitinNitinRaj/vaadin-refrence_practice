package com.nr.vaadinpractice.practicalVaadin.dataBinding.manualBinding.view;

import com.nr.vaadinpractice.practicalVaadin.dataBinding.manualBinding.entity.Manufacturer;
import com.nr.vaadinpractice.practicalVaadin.dataBinding.manualBinding.entity.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.HashSet;
import java.util.Set;

@Route(value = ProductManagementView.ROUTE)
@PageTitle(value = ProductManagementView.TITLE)
public class ProductManagementView extends Composite<Component> {

  public static final String ROUTE = "productManagementView";
  public static final String TITLE = "Product Management View";

  private static Set<Product> products = new HashSet<>();
  private static Set<Manufacturer> manufacturers = new HashSet<>();
  private VerticalLayout productLayout = new VerticalLayout();

  static {
    manufacturers.add(
      new Manufacturer("PepsiCo", "555111", "pepsi@example.com")
    );
    manufacturers.add(new Manufacturer("Cola", "555222", "cola@example.com"));
    manufacturers.add(new Manufacturer("Dew", "555333", "dew@example.com"));

    products.add(
      new Product(
        "Pepsi",
        true,
        new Manufacturer("PepsiCo", "555111", "pepsi@example.com")
      )
    );
  }

  @Override
  protected Component initContent() {
    updateList();
    return new VerticalLayout(
      new Button(
        "New Product",
        VaadinIcon.PLUS.create(),
        e -> {
          showProductForm(new Product());
        }
      ),
      productLayout
    );
  }

  public void updateList() {
    productLayout.removeAll();
    products
      .stream()
      .map(product ->
        new Details(
          product.getName() + (product.isAvailable() ? "" : "(not available)"),
          new HorizontalLayout(
            new Button(
              VaadinIcon.PENCIL.create(),
              e -> showProductForm(product)
            ),
            new Button(VaadinIcon.TRASH.create(), e -> delete(product))
          )
        )
      )
      .forEach(productLayout::add);
  }

  public void showProductForm(Product product) {
    Dialog dialog = new Dialog();
    dialog.setModal(true);
    dialog.open();
    dialog.add(
      new ProductForm(
        product,
        manufacturers,
        () -> {
          dialog.close();
          save(product);
        }
      )
    );
  }

  public void delete(Product product) {
    products.remove(product);
    updateList();
    Notification.show("Product removed: " + product.getName());
  }

  public void save(Product product) {
    products.add(product);
    updateList();
    Notification.show("Product Saved: " + product.getName());
  }
}
