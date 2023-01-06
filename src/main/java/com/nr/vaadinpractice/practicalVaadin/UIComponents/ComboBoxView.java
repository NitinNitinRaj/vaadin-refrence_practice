package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(ComboBoxView.ROUTE)
@PageTitle(ComboBoxView.TITLE)
public class ComboBoxView extends Composite<Component> {

  public static final String ROUTE = "comboBoxView";
  public static final String TITLE = "ComboBox View";

  @Override
  protected Component initContent() {
    ComboBox<String> comboBox = new ComboBox<>("Department");
    comboBox.setItems("R&D", "HR", "Sales", "Marketing");
    ComboBox<Department> departmentComboBox = new ComboBox<>(
      "Department using class"
    );
    departmentComboBox.setItems(
      new Department(1, "R&D"),
      new Department(2, "HR"),
      new Department(3, "Sales"),
      new Department(4, "Marketing")
    );

    departmentComboBox.setItemLabelGenerator(department -> {
      return department.getName() + " department";
    });

    RadioButtonGroup<Department> radioButtonGroup = new RadioButtonGroup<>(
      "Department"
    );
    radioButtonGroup.setItems(
      new Department(1, "R&D"),
      new Department(2, "HR"),
      new Department(3, "Sales"),
      new Department(4, "Marketing")
    );
    radioButtonGroup.setItemLabelGenerator(department -> {
      return department.getName() + " department";
    });

    ListBox<Department> listBox = new ListBox<>();
    listBox.setItems(
      new Department(1, "R&D"),
      new Department(2, "HR"),
      new Department(3, "Sales"),
      new Department(4, "Marketing")
    );
    listBox.setItemLabelGenerator(department -> {
      return department.getName() + " department";
    });

    MultiSelectListBox<Department> multiSelectListBox = new MultiSelectListBox<>();
    multiSelectListBox.setItems(
      new Department(1, "R&D"),
      new Department(2, "HR"),
      new Department(3, "Sales"),
      new Department(4, "Marketing")
    );
    multiSelectListBox.setItemLabelGenerator(department -> {
      return department.getName() + " department";
    });

    CheckboxGroup<Department> checkboxGroup = new CheckboxGroup<>("Department");
    checkboxGroup.setItems(
      new Department(1, "R&D"),
      new Department(2, "HR"),
      new Department(3, "Sales"),
      new Department(4, "Marketing")
    );
    checkboxGroup.setItemLabelGenerator(department -> {
      return department.getName() + " department";
    });

    checkboxGroup.addValueChangeListener(e -> {
      Notification.show(e.getValue().toString());
    });

    return new VerticalLayout(
      comboBox,
      departmentComboBox,
      radioButtonGroup,
      listBox,
      checkboxGroup,
      multiSelectListBox
    );
  }
}
