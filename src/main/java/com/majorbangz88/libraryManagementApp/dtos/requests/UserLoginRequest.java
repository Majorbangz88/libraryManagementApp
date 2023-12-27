package com.majorbangz88.libraryManagementApp.dtos.requests;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String username;
    private String password;
}
