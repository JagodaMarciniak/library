package com.example.demo.book.model;

import com.example.demo.book.enums.CategoryEnum;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
//@Data is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode,
// @Getter / @Setter and @RequiredArgsConstructor together: In other words, @Data generates all the boilerplate
// that is normally associated with simple POJOs (Plain Old Java Objects) and beans: getters for all fields,
// setters for all non-final fields, and appropriate toString, equals and hashCode implementations that involve
// the fields of the class, and a constructor that initializes all final fields, as well as all non-final fields
// with no initializer that have been marked with @NonNull, in order to ensure the field is never null.
@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "author")
    private String author;

    @NonNull
    @Column(name = "category")
    private CategoryEnum category;

    @Column(name = "description")
    private String description;

    @Column(name = "opinion_on_scale")
    private int opinionOnScale;

    @Column(name = "my_notes")
    private String myNotes;

    @Column(name = "number_of_pages")
    private int numberOfPages;
}