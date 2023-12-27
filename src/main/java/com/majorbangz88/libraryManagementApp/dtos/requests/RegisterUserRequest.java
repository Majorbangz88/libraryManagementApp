package com.majorbangz88.libraryManagementApp.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String firstName;
    private  String lastName;
    private String phoneNumber;
    private String username;
    private String password;
}
