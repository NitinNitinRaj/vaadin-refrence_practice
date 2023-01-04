package com.nr.vaadinpractice.view.lasyDataFetching;

import com.nr.vaadinpractice.view.grid.entity.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceLazy {

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

  public void getPeople() {
    if (people == null) {
      people = new ArrayList<>();
      final Random r = new Random();

      for (int i = 0; i < 10000; i++) {
        final Person person = new Person();
        person.setName(
          firstName[r.nextInt(firstName.length)] +
          " " +
          lastName[r.nextInt(lastName.length)]
        );
        person.setAge(r.nextInt(50) + 18);
        person.setEmail(person.getName().replaceAll(" ", ".") + "@example.com");

        LocalDate date = LocalDate.now().minusYears(person.getAge());
        date = date.withMonth(r.nextInt(12) + 1);
        date = date.withDayOfMonth(r.nextInt(28) + 1);
        person.setBirthday(date);

        people.add(person);
      }
    }
  }

  public Stream<Person> getPerons(int offest, int limt, AgeValue filter) {
    getPeople();
    return people
      .stream()
      .filter(p -> filter(p, filter))
      .skip(offest)
      .limit(limt);
  }

  private boolean filter(Person p, AgeValue filter) {
    if (filter == null) {
      return true;
    }
    int age = p.getAge();
    return age >= filter.getMinAge() && age <= filter.getMaxAge();
  }

  public int countPersons(int offset, int limit, AgeValue filter) {
    getPeople();

    return (int) people
      .stream()
      .filter(p -> filter(p, filter))
      .skip(offset)
      .limit(limit)
      .count();
  }
}
