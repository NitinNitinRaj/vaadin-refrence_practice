package com.nr.vaadinpractice.view.routing;

import com.nr.vaadinpractice.view.MainView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import java.util.Random;

@Route(value = LotteryView.ROUTE, layout = MainView.class)
public class LotteryView
  extends Composite<VerticalLayout>
  implements HasComponents, HasUrlParameter<Integer> {

  public static final String ROUTE = "lottery";
  public static final String TITLE = "Lottery View";

  private final Div lotteryResult = new Div();
  final TextField numberInput;

  public LotteryView() {
    add(new H2("Lottery View"));

    HorizontalLayout inputBar = new HorizontalLayout();
    numberInput = new TextField();
    inputBar.add(numberInput);
    numberInput.setPlaceholder("Input your number");
    Button button = new Button(
      "Try my luck!",
      e -> {
        final String value = numberInput.getValue();
        if (value != null && !value.isEmpty()) {
          final Integer number = Integer.parseInt(value);
          validate(number);
          updateContent(number);
        }
      }
    );
    button.setEnabled(false);
    numberInput.addValueChangeListener(e -> {
      button.setEnabled(e.getValue() != null && !e.getValue().isEmpty());
    });
    inputBar.add(button);
    add(inputBar);
    add(lotteryResult);
  }

  private void updateContent(Integer number) {
    if (number == null) {
      lotteryResult.setText("");
    } else {
      final int luckyNumber = new Random().nextInt(10) + 1;
      StringBuilder builder = new StringBuilder();
      if (number.equals(luckyNumber)) {
        builder.append("Congrats, you win! ");
      } else {
        builder.append("Sorry, better luck next time. ");
      }
      builder
        .append("Your number is: ")
        .append(number)
        .append(", the lucky number is:")
        .append(luckyNumber);

      lotteryResult.setText(builder.toString());
    }
  }

  private void validate(Integer number) {
    if (number != null) {
      if (number < 1 || number > 10) {
        throw new InvalidValueExeption("Input should be between 1 and 10");
      }
    }
  }

  @Override
  public void setParameter(
    BeforeEvent event,
    @OptionalParameter Integer parameter
  ) {
    if (parameter != null) {
      validate(parameter);
      numberInput.setValue(String.valueOf(parameter));
    }
  }
}
