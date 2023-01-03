package com.nr.vaadinpractice.view.gridFiltering;

import com.nr.vaadinpractice.view.MainView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;

@Route(value = FilteringDataProvider.ROUTE, layout = MainView.class)
public class FilteringDataProvider extends Composite<VerticalLayout> {

  public static final String ROUTE = "gridFiltering";
  public static final String TITLE = "Grid Filtering";

  private final ListDataProvider<Product> dataProvider;
  private DatePicker start = new DatePicker("Start");
  private DatePicker end = new DatePicker("End");
  private Button filter = new Button("Filter");
  private HorizontalLayout dataFields = new HorizontalLayout();
  private Grid<Product> productGrid = new Grid<>();

  public FilteringDataProvider() {
    final VerticalLayout layout = getContent();
    layout.setWidth("100%");

    dataProvider = DataProviderHelper.createProductDataProvider();

    filter.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    dataFields.add(start, end, filter);
    dataFields.setDefaultVerticalComponentAlignment(Alignment.END);

    productGrid.addColumn(Product::getName).setHeader("Name");
    productGrid.addColumn(Product::getPrice).setHeader("Price");
    productGrid
      .addColumn(Product::getAvailable)
      .setSortable(true)
      .setHeader("Available");

    productGrid.setItems(dataProvider);

    layout.add(dataFields, productGrid);

    start.setClearButtonVisible(true);
    end.setClearButtonVisible(true);

    filter.addClickListener(event -> {
      dataProvider.setFilter(product ->
        filterProduct(product, start.getValue(), end.getValue())
      );
      dataProvider.refreshAll();
    });
  }

  private boolean filterProduct(
    Product product,
    LocalDate start,
    LocalDate end
  ) {
    if (start == null && end == null) {
      return true;
    } else {
      LocalDate available = product.getAvailable();
      if (start == null && end != null) {
        if (
          available.isBefore(end) ||
          available.isEqual(end)
        ) {
          return true;
        } else {
          return false;
        }
      } else if (start != null && end == null) {
        if (
          available.isAfter(start) ||
          available.isEqual(start)
        ) {
          return true;
        } else {
          return false;
        }
      } else {
        if (
          (
            available.isAfter(start) ||
            available.isEqual(start)
          ) &&
          (
            available.isBefore(end) ||
            available.isEqual(end)
          )
        ) {
          return true;
        } else {
          return false;
        }
      }
    }
  }
}
