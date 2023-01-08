package com.nr.vaadinpractice.practicalVaadin.grid.entity;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

  private static AtomicInteger nextId = new AtomicInteger(1);

  private Integer id;

  private String title;

  private String author;

  private Publisher publisher;

  private int quantity = (int) (Math.random() * (50));

  private String description;

  public Book(
    String title,
    String author,
    Publisher publisher,
    String description
  ) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.description = description;
    this.id = nextId.getAndIncrement();
  }
}
