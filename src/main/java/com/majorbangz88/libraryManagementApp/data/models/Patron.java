package com.majorbangz88.libraryManagementApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Patrons")
public class Patron {

    @Id
    private String id;
    private String membershipId;
    private BorrowedBooks borrowedBooks;
    private Book reservations;
//    private Book checkOut; These are the patron methods
//    private Book renew;
//    private Book reserve;
}
