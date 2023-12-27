package com.majorbangz88.libraryManagementApp.data.repositories;

import com.majorbangz88.libraryManagementApp.data.models.Patron;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatronRepository extends MongoRepository<Patron, String> {
}
