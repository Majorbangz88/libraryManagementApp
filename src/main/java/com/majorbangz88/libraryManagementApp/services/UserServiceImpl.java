package com.majorbangz88.libraryManagementApp.services;

import com.majorbangz88.libraryManagementApp.data.models.Book;
import com.majorbangz88.libraryManagementApp.data.models.Status;
import com.majorbangz88.libraryManagementApp.data.models.User;
import com.majorbangz88.libraryManagementApp.data.repositories.UserRepository;
import com.majorbangz88.libraryManagementApp.dtos.requests.BorrowBookRequest;
import com.majorbangz88.libraryManagementApp.dtos.requests.RegisterUserRequest;
import com.majorbangz88.libraryManagementApp.dtos.requests.UserLoginRequest;
import com.majorbangz88.libraryManagementApp.exceptions.BookNotAvailableException;
import com.majorbangz88.libraryManagementApp.exceptions.UserAlreadyExistsException;
import com.majorbangz88.libraryManagementApp.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.majorbangz88.libraryManagementApp.utils.userServiceImplMapper.Mapper.map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookService bookService;

    @Override
    public void registerUser(RegisterUserRequest registerUserRequest) {
        findUserBy(registerUserRequest);
        User newUser = map(registerUserRequest);
        userRepository.save(newUser);
    }

    @Override
    public User isLocked() {
        User user = new User();
        user.setLoggedIn(false);
        userRepository.save(user);
        return user;
    }

    @Override
    public User setLogin(UserLoginRequest userLoginRequest) {
        Optional<User> user = userRepository.findUserByUsername(userLoginRequest.getUsername());
        if (user.isEmpty()) throw new UserNotFoundException("User not found!");
        if (user.get().getUsername().equals(userLoginRequest.getUsername()) &&
                user.get().getPassword().equals(userLoginRequest.getPassword()))
            user.get().setLoggedIn(true);
        return user.get();
    }

    @Override
    public List<Book> viewAllBooks() {
        return bookService.findAll();
    }

    @Override
    public long count() {
        return bookService.count();
    }

    @Override
    public String borrowBook(BorrowBookRequest borrowBookRequest) {
        bookService.finBookByAuthorName(borrowBookRequest.getBookAuthor());
        return "Book reserved!";
    }

    private void findUserBy(RegisterUserRequest registerUserRequest) {
        Optional<User> foundUser = userRepository.findUserByUsername(registerUserRequest.getUsername());
        if (foundUser.isPresent())
            throw new UserAlreadyExistsException("User exists already!");
    }
}
