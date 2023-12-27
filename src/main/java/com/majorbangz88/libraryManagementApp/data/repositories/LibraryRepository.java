package com.majorbangz88.libraryManagementApp.data.repositories;

import com.majorbangz88.libraryManagementApp.data.models.Library;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Library, String> {
}
