package com.majorbangz88.libraryManagementApp.services;

import com.majorbangz88.libraryManagementApp.data.models.Book;
import com.majorbangz88.libraryManagementApp.data.models.User;
import com.majorbangz88.libraryManagementApp.dtos.requests.BorrowBookRequest;
import com.majorbangz88.libraryManagementApp.dtos.requests.RegisterUserRequest;
import com.majorbangz88.libraryManagementApp.dtos.requests.UserLoginRequest;

import java.util.List;

public interface UserService {
    void registerUser(RegisterUserRequest registerUserRequest);

    User isLocked();

    User setLogin(UserLoginRequest userLoginRequest);

    List<Book> viewAllBooks();

    long count();

    String borrowBook(BorrowBookRequest borrowBookRequest);
}
