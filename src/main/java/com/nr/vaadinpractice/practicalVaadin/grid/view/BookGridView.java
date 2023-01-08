package com.nr.vaadinpractice.practicalVaadin.grid.view;

import com.nr.vaadinpractice.practicalVaadin.grid.entity.Book;
import com.nr.vaadinpractice.practicalVaadin.grid.service.BookService;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Comparator;

@Route(value = BookGridView.ROUTE)
@PageTitle(value = BookGridView.TITLE)
public class BookGridView extends Composite<Component> {

  public static final String ROUTE = "bookGridView";
  public static final String TITLE = "Book Grid View";
  private Grid<Book> grid = new Grid<>(Book.class);

  @Override
  protected Component initContent() {
    //grid.setSelectionMode(Grid.SelectionMode.MULTI);
    var increaseQuanitiy = new Button("Increase Quanitiy");
    increaseQuanitiy.setEnabled(false);
    grid.removeColumnByKey("publisher");
    grid.setColumns("title", "publisher.name", "author", "quantity");
    grid.getColumnByKey("publisher.name").setHeader("Publisher");
    grid
      .getColumnByKey("title")
      .setHeader("Book")
      .setFooter("Total Books:" + 150)
      .setAutoWidth(true);
    grid.setItems(/* query ->
      BookService.findAll(query.getOffset(), query.getLimit()).stream()*/
      BookService.findAll(0, 150)
    );

    grid.addSelectionListener(event -> {
      // Book selectedBook = grid.asSingleSelect().getValue();
      // increaseQuanitiy.setEnabled(selectedBook != null);
      Boolean present = event.getFirstSelectedItem().isPresent();
      increaseQuanitiy.setEnabled(present);
    });
    increaseQuanitiy.addClickListener(event -> {
      grid
        .asSingleSelect()
        .getOptionalValue()
        .ifPresent(book -> {
          BookService.increaseQuantity(book);
          updateGrid(grid);
        });
    });

    /*Set<Book> selectedBooks = grid.asMultiSelect().getValue();Set<Book> selectedBooks = event.getAllSelectedItems() */

    // grid.addComponentColumn(book ->
    //   new Button(
    //     VaadinIcon.PLUS.create(),
    //     event -> {
    //       BookService.increaseQuantity(book);
    //       updateGrid(grid);
    //     }
    //   )
    // );

    // grid.addComponentColumn(book ->
    //   new Button(
    //     VaadinIcon.MINUS.create(),
    //     event -> {
    //       BookService.decreaseQuantity(book);
    //       updateGrid(grid);
    //     }
    //   )
    // );

    grid
      .addComponentColumn(book -> new ProgressBar(0, 50, book.getQuantity()))
      .setHeader("Quantity")
      .setSortable(true)
      .setComparator(Comparator.comparingInt(Book::getQuantity));

    grid.setItemDetailsRenderer(
      new ComponentRenderer<>(book ->
        new VerticalLayout(
          new Text(book.getDescription()),
          new Button(
            "Quantity",
            VaadinIcon.ARROW_UP.create(),
            event -> {
              BookService.increaseQuantity(book);
              updateGrid(grid);
              grid.select(book);
            }
          ),
          new Button(
            "Quantity",
            VaadinIcon.ARROW_DOWN.create(),
            event -> {
              BookService.decreaseQuantity(book);
              updateGrid(grid);
              grid.select(book);
            }
          )
        )
      )
    );

    var streamResourse = new StreamResource(
      "books.csv",
      () -> {
        try {
          var books = grid.getGenericDataView().getItems();
          StringWriter output = new StringWriter();
          var beanToCsv = new StatefulBeanToCsvBuilder<Book>(output)
            .withIgnoreField(Book.class, Book.class.getDeclaredField("id"))
            .withIgnoreField(Book.class, Book.class.getDeclaredField("nextId"))
            .build();
          beanToCsv.write(books);
          return new ByteArrayInputStream(output.toString().getBytes());
        } catch (
          CsvDataTypeMismatchException
          | CsvRequiredFieldEmptyException
          | IllegalArgumentException
          | NoSuchFieldException
          | SecurityException e
        ) {
          e.printStackTrace();
          return null;
        }
      }
    );

    var download = new Anchor(streamResourse, "Download");

    return new VerticalLayout(download, grid);
  }

  private void updateGrid(Grid<Book> grid) {
    grid.setItems(BookService.findAll());
  }
}
