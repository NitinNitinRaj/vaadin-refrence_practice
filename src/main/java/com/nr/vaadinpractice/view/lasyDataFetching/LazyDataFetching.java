package com.nr.vaadinpractice.view.lasyDataFetching;

import com.nr.vaadinpractice.view.MainView;
import com.nr.vaadinpractice.view.grid.entity.Person;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Route;
import java.util.LinkedList;
import java.util.List;

@Route(value = LazyDataFetching.ROUTE, layout = MainView.class)
public class LazyDataFetching extends VerticalLayout {

  public static final String ROUTE = "lazyDataFetching";
  public static final String TITLE = "Lazy Data Fetching";

  private ComboBox<AgeValue> ageComboBox;
  private List<AgeValue> listAgeValues;
  private Grid<Person> people;
  private final PersonServiceLazy service = new PersonServiceLazy();

  public LazyDataFetching() {
    setWidthFull();

    listAgeValues = new LinkedList<>();
    listAgeValues.add(new AgeValue(1, 20));
    listAgeValues.add(new AgeValue(20, 40));
    listAgeValues.add(new AgeValue(40, 60));
    listAgeValues.add(new AgeValue(60, 80));
    listAgeValues.add(new AgeValue(90, 100));

    ageComboBox = new ComboBox<>("Age Limit", listAgeValues);
    ageComboBox.setClearButtonVisible(true);
    ageComboBox.setWidth("150px");

    add(ageComboBox);

    people = new Grid<>();
    people.setWidth("90%");

    add(people);

    CallbackDataProvider<Person, AgeValue> dataProvider = DataProvider.fromFilteringCallbacks(
      q ->
        service.getPerons(
          q.getOffset(),
          q.getLimit(),
          q.getFilter().orElse(null)
        ),
      q ->
        service.countPersons(
          q.getOffset(),
          q.getLimit(),
          q.getFilter().orElse(null)
        )
    );

    ConfigurableFilterDataProvider<Person, Void, AgeValue> filterProvider = dataProvider.withConfigurableFilter();

    people.setItems(filterProvider);

    ageComboBox.addValueChangeListener(e ->
      filterProvider.setFilter(e.getValue())
    );

    people.addColumn(Person::getName).setHeader("Name").setKey("name");
    people.addColumn(Person::getAge).setHeader("Age").setKey("age");
    people
      .addColumn(new LocalDateRenderer<Person>(Person::getBirthday))
      .setHeader("Birthday")
      .setKey("birthday");
    people.addColumn(Person::getEmail).setHeader("Email").setKey("email");
    people.getColumns().forEach(col -> col.setAutoWidth(true));
  }
}
