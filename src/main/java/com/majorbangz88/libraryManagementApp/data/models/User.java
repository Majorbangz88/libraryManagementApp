package com.majorbangz88.libraryManagementApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User")
public class User {

    @Id
    private String id;
    private String firstName;
    private  String lastName;
    private String phoneNumber;
    private String username;
    private String password;
    private boolean isLoggedIn;
}
