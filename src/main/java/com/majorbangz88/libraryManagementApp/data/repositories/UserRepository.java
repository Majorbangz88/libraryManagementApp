package com.majorbangz88.libraryManagementApp.data.repositories;

import com.majorbangz88.libraryManagementApp.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByUsername(String username);
}
