package com.example.demo.book.dto;

import com.example.demo.book.enums.CategoryEnum;
import lombok.Data;
import lombok.NonNull;

@Data
public class BookDto {

    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String author;

    private CategoryEnum category;

    private String description;

    private int opinionOnScale;
    //a bean validation annotation @Size makes the bean independent of JPA and its vendors such as Hibernate.
    @Size(min = 10, max = 500)
    private String myNotes;

    private int numberOfPages;
}
