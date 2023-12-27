package com.majorbangz88.libraryManagementApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document("BorrowedBooks")
public class BorrowedBooks {

    @Id
    private String id;
    private Book bookName;
    private User borrower;
    private LocalDate borrowDateTime;
    private LocalDateTime dueDateTime;
}
