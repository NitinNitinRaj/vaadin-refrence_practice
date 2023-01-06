package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.nr.vaadinpractice.view.validation.Data;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

@Route(DatePickerView.ROUTE)
@PageTitle(DatePickerView.TITLE)
public class DatePickerView extends Composite<Component> {

  public static final String ROUTE = "datePicker";
  public static final String TITLE = "Date Picker View";

  @Override
  protected Component initContent() {
    DatePicker datePicker = new DatePicker(
      "Enter your Birthday",
      LocalDate.now(),
      e -> {
        showMessage(e.getValue());
      }
    );
    datePicker.setAutoOpen(false);
    datePicker.setClearButtonVisible(true);
    datePicker.setInitialPosition(LocalDate.now().minusMonths(1));
    datePicker.setMin(LocalDate.now().minusYears(50));
    datePicker.setMax(LocalDate.now().plusYears(50));
    datePicker.setLocale(Locale.US);

    TimePicker timePicker = new TimePicker(
      "Pick a time",
      LocalTime.now(),
      e -> {
        Notification.show(e.getValue().toString());
      }
    );

    DateTimePicker dateTimePicker = new DateTimePicker(
      "Pick a Date and time",
      LocalDateTime.now(),
      e -> {
        Notification.show(e.getValue().toString());
      }
    );
    return new VerticalLayout(datePicker, timePicker, dateTimePicker);
  }

  private void showMessage(LocalDate date) {
    Notification.show("BirthDay: " + date);
  }
}
