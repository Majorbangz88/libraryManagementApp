package com.majorbangz88.libraryManagementApp.utils.userServiceImplMapper;

import com.majorbangz88.libraryManagementApp.data.models.User;
import com.majorbangz88.libraryManagementApp.dtos.requests.RegisterUserRequest;

public class Mapper {

    public static User map(RegisterUserRequest registerUserRequest) {
        User newUser = new User();
        newUser.setFirstName(registerUserRequest.getFirstName());
        newUser.setLastName(registerUserRequest.getLastName());
        newUser.setPhoneNumber(registerUserRequest.getPhoneNumber());
        newUser.setUsername(registerUserRequest.getUsername());
        newUser.setPassword(registerUserRequest.getPassword());
        return newUser;
    }
}
