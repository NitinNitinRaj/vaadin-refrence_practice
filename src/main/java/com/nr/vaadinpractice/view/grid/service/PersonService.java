package com.nr.vaadinpractice.view.grid.service;

import com.nr.vaadinpractice.view.grid.entity.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private static String[] firstName = {
    "James",
    "John",
    "Robert",
    "Michael",
    "William",
    "David",
    "Richard",
    "Charles",
    "Joseph",
    "Christopher",
    "Mary",
    "Patricia",
    "Linda",
    "Barbara",
    "Elizabeth",
    "Jennifer",
    "Maria",
    "Susan",
    "Margaret",
    "Dorothy",
    "Lisa",
  };

  private static String[] lastName = {
    "Smith",
    "Johnson",
    "Williams",
    "Jones",
    "Brown",
    "Davis",
    "Miller",
    "Wilson",
    "Moore",
    "Taylor",
    "Andreson",
    "Thomas",
    "Jackson",
    "White",
  };

  private List<Person> people;

  public List<Person> getPeople() {
    people = new ArrayList<>();
    final Random random = new Random();

    for (int i = 0; i < 100; i++) {
      Person person = new Person();
      person.setName(
        firstName[random.nextInt(firstName.length)] +
        " " +
        lastName[random.nextInt(lastName.length)]
      );
      person.setAge(random.nextInt(50) + 18);
      LocalDate date = LocalDate
        .now()
        .minusYears(person.getAge())
        .withDayOfYear(random.nextInt(28) + 1)
        .withMonth(random.nextInt(12) + 1);
      person.setBirthday(date);
      person.setEmail(
        person.getName().toLowerCase().replaceAll(" ", ".") + "@gmail.com"
      );
      people.add(person);
    }
    return people;
  }
}
