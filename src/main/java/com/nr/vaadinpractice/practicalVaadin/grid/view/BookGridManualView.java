package com.nr.vaadinpractice.practicalVaadin.grid.view;

import com.nr.vaadinpractice.practicalVaadin.grid.entity.Book;
import com.nr.vaadinpractice.practicalVaadin.grid.service.BookService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = BookGridManualView.ROUTE)
@PageTitle(value = BookGridManualView.TITLE)
public class BookGridManualView extends Composite<Component> {

  public static final String ROUTE = "bookGridManualView";
  public static final String TITLE = "Book Grid View";
  private Grid<Book> grid = new Grid<>();

  @Override
  protected Component initContent() {
    grid.addColumn(Book::getTitle).setHeader("Book").setAutoWidth(true);
    grid
      .addColumn(book -> book.getPublisher().getName())
      .setHeader("Publisher");
    grid
      .addColumn(Book::getAuthor)
      .setComparator((book1, book2) ->
        book1.getAuthor().compareToIgnoreCase(book2.getAuthor())
      )
      .setHeader("Author");

    grid.addColumn(Book::getQuantity).setHeader("Quantity").setKey("quantity");
    grid.setItems(/*query ->
      BookService.findAll(query.getOffset(), query.getLimit()).stream()*/
      BookService.findAll()
    );
    return new VerticalLayout(grid);
  }
}
