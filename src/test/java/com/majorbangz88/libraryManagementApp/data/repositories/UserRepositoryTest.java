package com.majorbangz88.libraryManagementApp.data.repositories;

import com.majorbangz88.libraryManagementApp.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void startWithThis() {
        userRepository.deleteAll();
    }

    @Test
    public void testThatUserCanBeSaved() {
        User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("phoneNumber");
        user.setUsername("username");
        user.setPassword("password");
        userRepository.save(user);
        assertThat(user.getId(), is(notNullValue()));
        assertThat(userRepository.count(), is(1L));
    }
}