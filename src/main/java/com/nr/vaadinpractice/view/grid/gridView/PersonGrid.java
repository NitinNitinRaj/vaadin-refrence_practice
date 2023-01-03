package com.nr.vaadinpractice.view.grid.gridView;

import com.nr.vaadinpractice.view.MainView;
import com.nr.vaadinpractice.view.grid.entity.Person;
import com.nr.vaadinpractice.view.grid.service.PersonService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Route;

@Route(value = PersonGrid.ROUTE, layout = MainView.class)
public class PersonGrid extends VerticalLayout {

  public static final String ROUTE = "personGrid";
  public static final String TITLE = "Grid";

  Grid<Person> grid = new Grid<>();

  PersonService service = new PersonService();

  public PersonGrid() {
    setWidthFull();
    add(grid);
    grid.setItems(service.getPeople());

    grid
      .addColumn(Person::getName)
      .setSortable(true)
      .setHeader("Name")
      .setFooter("Total: " + service.getPeople().size() + " people");
    grid.addColumn(Person::getAge).setSortable(true).setHeader("Age");
    grid
      .addColumn(new LocalDateRenderer<Person>(Person::getBirthday))
      .setHeader("BirthDay");
    grid.addColumn(Person::getEmail).setHeader("Email");

    grid.getColumns().forEach(col -> col.setAutoWidth(true));
  }
}
