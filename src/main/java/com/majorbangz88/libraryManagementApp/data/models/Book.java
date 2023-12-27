package com.majorbangz88.libraryManagementApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document("Book")
public class Book {

    @Id
    private String id;
    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private Status status;
    private int quantityAvailable;
    private BigDecimal borrowPrice;
    private LocalDateTime dateTimeAdded;
}
