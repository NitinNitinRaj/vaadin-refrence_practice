package com.nr.vaadinpractice.view.binding;

import com.nr.vaadinpractice.view.MainView;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;

@Route(value = FormBinding.ROUTE, layout = MainView.class)
public class FormBinding extends VerticalLayout {

  private static final Product PRODUCT_DEFAULT = new Product(
    "Test Prodcut",
    9.99,
    LocalDate.now()
  );
  public static final String ROUTE = "formBinding";
  public static final String TITLE = "Form Binding";

  private FormEditor formEditor = new FormEditor();
  private FormView formView = new FormView(PRODUCT_DEFAULT);

  public FormBinding() {
    setSizeFull();
    FlexLayout flexLayout = new FlexLayout();
    flexLayout.add(formEditor, formView);
    flexLayout.setFlexGrow(1, formEditor);
    flexLayout.setFlexGrow(1, formView);

    addingListners();

    add(flexLayout);
  }

  private void addingListners() {
    formEditor.addListner(FormEditor.SaveEvent.class, this::saveProduct);
    formEditor.addListner(
      FormEditor.CloseEvent.class,
      event -> {
        formView.setProduct(PRODUCT_DEFAULT);
      }
    );
  }

  public void saveProduct(FormEditor.SaveEvent event) {
    formView.setProduct(event.getProduct());
  }
}
