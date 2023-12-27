package com.majorbangz88.libraryManagementApp.services;

import com.majorbangz88.libraryManagementApp.data.models.User;
import com.majorbangz88.libraryManagementApp.data.repositories.UserRepository;
import com.majorbangz88.libraryManagementApp.dtos.requests.BorrowBookRequest;
import com.majorbangz88.libraryManagementApp.dtos.requests.RegisterUserRequest;
import com.majorbangz88.libraryManagementApp.dtos.requests.UserLoginRequest;
import com.majorbangz88.libraryManagementApp.exceptions.UserAlreadyExistsException;
import com.majorbangz88.libraryManagementApp.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void startWithThis() {
        userRepository.deleteAll();
    }

    @Test
    public void testThatANewUserCanRegisterOnThePlatform() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("LastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertThat(userRepository.count(), is(1L));
    }

    @Test
    public void testThatApplicationIsLockedByDefault() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("LastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertThat(userRepository.count(), is(1L));

        User user = userService.isLocked();
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void testThatExceptionIsThrownWhenSameUsernameIsRegistered() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("LastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertThat(userRepository.count(), is(1L));

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setFirstName("firstName");
        registerUserRequest1.setLastName("LastName");
        registerUserRequest1.setPhoneNumber("phoneNumber");
        registerUserRequest1.setUsername("username");
        registerUserRequest1.setPassword("password");
        assertThrows(UserAlreadyExistsException.class, ()-> userService.registerUser(registerUserRequest1));
    }

    @Test
    public void testThatWhenNewUserRegisters_UserCanLogInUsingCorrectUsernameAndPassword() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("LastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertThat(userRepository.count(), is(1L));

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("username");
        userLoginRequest.setPassword("password");
        User user = userService.setLogin(userLoginRequest);
        assertTrue(user.isLoggedIn());
    }

    @Test
    public void testThatExceptionIsThrownWhenLoginDetailsAreIncorrect() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("LastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertThat(userRepository.count(), is(1L));

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("usernames");
        userLoginRequest.setPassword("password");
        assertThrows(UserNotFoundException.class, ()-> userService.setLogin(userLoginRequest));
    }

    @Test
    public void testThatUserCanAccessTheListOfBooks() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("LastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertThat(userRepository.count(), is(1L));

        userService.viewAllBooks();
        assertThat(userService.count(), is(1L));
    }

    @Test
    public void testThatUserCanBorrowBooks() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("LastName");
        registerUserRequest.setPhoneNumber("phoneNumber");
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        userService.registerUser(registerUserRequest);
        assertThat(userRepository.count(), is(1L));

        BorrowBookRequest borrowBookRequest = new BorrowBookRequest();
        borrowBookRequest.setBookAuthor("Author");

        assertThat(userService.borrowBook(borrowBookRequest), is("Book reserved!"));
    }
}