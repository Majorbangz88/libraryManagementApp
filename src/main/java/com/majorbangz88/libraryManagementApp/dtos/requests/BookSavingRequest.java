package com.majorbangz88.libraryManagementApp.dtos.requests;

import com.majorbangz88.libraryManagementApp.data.models.Genre;
import com.majorbangz88.libraryManagementApp.data.models.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BookSavingRequest {

    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private Status status;
    private int quantityAvailable;
    private BigDecimal borrowPrice;
    private LocalDateTime dateTimeAdded;
}
